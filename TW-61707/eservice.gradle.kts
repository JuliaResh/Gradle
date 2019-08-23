import de.authada.it.gradle.common.versioning.ci.CiVersioning
import de.authada.it.gradle.dependencies.AuthadaDependencyCheckPlugin
import de.authada.it.gradle.dependencies.AuthadaDependencyResolutionCheckPlugin
import de.authada.it.gradle.dependencies.version.AuthadaDependencyVersionCheckPlugin
import de.authada.it.gradle.integrationtest.AuthadaIntegrationTestPlugin
import de.authada.it.gradle.java.AuthadaJavaDocPlugin
import de.authada.it.gradle.java.AuthadaMavenPublishPlugin
import de.authada.it.gradle.java.AuthadaSourceJarPlugin
import de.authada.it.gradle.java.java
import de.authada.it.gradle.java.test.AuthadaJavaTestPlugin
import de.authada.it.gradle.java.test.javaTest
import de.authada.it.gradle.k8s.extensions.OverlayType.CLUSTER
import de.authada.it.gradle.k8s.extensions.k8s
import de.authada.it.gradle.kotlin.AuthadaKotlinPlugin
import de.authada.it.gradle.licenses.AuthadaLicensePlugin
import de.authada.it.gradle.thorntail.thorntail

val gradleVersion: String by project
val wrapper: Wrapper by tasks
wrapper.gradleVersion = gradleVersion

plugins {
    id("authada-base")
    id("authada-kotlin")
    id("authada-thorntail")
    id("authada-k8s")
    id("authada-licenses-report")

    id("authada-jib").apply(false)
    id("authada-integration-test").apply(false)
    id("authada-dependency-check").apply(false)
    id("authada-java-test").apply(false)
    id("authada-doc-openapi").apply(false)

}

gradle.startParameter.isContinueOnFailure = true
defaultTasks("check", "assemble")

thorntail {
    thorntail.set(Versions.thorntail)
    slf4j.set(Versions.slf4j)
    netty.set(Versions.netty)
    jackson.set(Versions.jackson)
    jacksonDatabind.set(Versions.jacksonDatabind)
}

val ciVersioning = the<CiVersioning>()
k8s {

    defaultNamespace.set("eserv3")

    contexts {
        register("development") {
            namespace.set("docker-for-desktop-cluster")
            forIntegrationTests.set(true)
        }
        register("integration-test") {
            namespace { ns ->
                if (ciVersioning.isCiBuild) {
                    return@namespace "development-${generateMd5()}"
                } else {
                    return@namespace "development-${name}"
                }
            }
            forIntegrationTests.set(true)
        }
        register("local") {
            type.set(CLUSTER)
            saveLogs.set(false)
            retrievePorts.set(false)
            onlyIf {
                ciVersioning.isReleaseBranch
            }
        }
        register("staging") {
            type.set(CLUSTER)
            saveLogs.set(false)
            retrievePorts.set(false)
            onlyIf {
                ciVersioning.isReleaseBranch
            }
            version({
                val gitTag = System.getenv("GIT_TAG")
                if (gitTag.isNullOrEmpty()) {
                    throw InvalidUserDataException("GIT_TAG env variable needs to be set")
                }
                return@version gitTag.substring(1)
            })
        }
        register("production") {
            type.set(CLUSTER)
            saveLogs.set(false)
            retrievePorts.set(false)
            onlyIf {
                ciVersioning.isReleaseBranch
            }
            version({
                val gitTag = System.getenv("GIT_TAG")
                if (gitTag.isNullOrEmpty()) {
                    throw InvalidUserDataException("GIT_TAG env variable needs to be set")
                }
                return@version gitTag.substring(1)
            })
        }
    }
}

allprojects {
    apply<AuthadaDependencyVersionCheckPlugin>()
    apply<AuthadaDependencyResolutionCheckPlugin>()
}


subprojects {

    if (name != "documentation") {

        apply<AuthadaMavenPublishPlugin>()

        apply<AuthadaDependencyCheckPlugin>()
        apply<AuthadaLicensePlugin>()

        apply<AuthadaKotlinPlugin>()

        apply<AuthadaSourceJarPlugin>()
        apply<AuthadaJavaDocPlugin>()
        apply<AuthadaJavaTestPlugin>()

        java {
            strictCompiler.set(true)
        }
        javaTest {
            versions.junit.set(Versions.junit)
            versions.mockito.set(Versions.mockito)
            versions.assertj.set(Versions.assertj)
            versions.assertjGuava.set(Versions.assertjGuava)
        }

        apply<AuthadaIntegrationTestPlugin>()

        val testImplementation by configurations
        val testRuntimeOnly by configurations
        dependencies {
            testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
            testRuntimeOnly(Libs.loggingApi)
            testRuntimeOnly(Libs.julToSlf4j)
            testRuntimeOnly("org.slf4j:slf4j-jdk14:${Versions.slf4j}")
        }

        tasks.named<ProcessResources>("processResources") {
            filesMatching("**/*.properties") {
                if (!name.contains("log4j2.properties")) {
                    expand("version" to project.version)
                }
            }
        }
    }
}
