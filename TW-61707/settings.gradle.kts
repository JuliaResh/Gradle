import de.authada.it.gradle.project.BetterBuildFileNamesPlugin

rootProject.name = "eservice"

val authadaPluginsVersion: String by settings
pluginManagement {
    plugins {
        id("authada-base") version authadaPluginsVersion
        id("authada-kotlin") version authadaPluginsVersion
        id("authada-thorntail") version authadaPluginsVersion
        id("authada-k8s") version authadaPluginsVersion
        id("authada-licenses-report") version authadaPluginsVersion
        id("authada-jib") version authadaPluginsVersion
        id("authada-integration-test") version authadaPluginsVersion
        id("authada-dependency-check") version authadaPluginsVersion
        id("authada-java-test") version authadaPluginsVersion
        id("authada-doc-openapi") version authadaPluginsVersion
    }
}


buildscript {
    repositories {
        maven("https://repo.corp.authada.de/repository/maven-public/")
    }
    dependencies {
        classpath("authada-better-build-file-names:authada-better-build-file-names.gradle.plugin:1.6.0")
    }
}
// For a settings.gradle.kts file
apply<BetterBuildFileNamesPlugin>()

// doc
include(":documentation")

// common
val annotationsProjectPath = ":annotations"
val restCommonProjectPath = ":rest-common"
val redisProjectPath = ":redis"
val securityProjectPath = ":security"
val utilsProjectPath = ":utils"
val mqProjectPath = ":mq"
val restMqTrackingProjectPath = ":rest-mq-tracking"
include(
        annotationsProjectPath,
        restCommonProjectPath,
        redisProjectPath,
        securityProjectPath,
        utilsProjectPath,
        mqProjectPath,
        restMqTrackingProjectPath
)

// tooling
val restTestProjectPath = ":rest-test"
val eidMockProjectPath = ":eid-mock"
val eidMockToolsProjectPath = ":eid-mock-tools"
val demoProjectPath = ":demo"
val eventPersistenceProjectPath = ":event-persistence"
val mobileSpConnectorPath = ":mobile-sp-connector"
val v2AdapterPath = ":v2-adapter"
include(
        demoProjectPath,
        restTestProjectPath,
        eidMockProjectPath,
        eidMockToolsProjectPath,
        eventPersistenceProjectPath,
        mobileSpConnectorPath,
        v2AdapterPath
)

// sp
include(":sp")
include(":sp:sp-api")

// mob
include(":mobile")
include(":mobile:mobile-api")

// prof
include(":prof")
include(":prof:feature-api")
include(":prof:sp-feature-rest-api")
include(":prof:mobile-feature-rest-api")

// features
val eidApiProjectPath = ":eid-api"
val eidImplProjectPath = ":eid-impl"
val eidFeatureImplProjectPath = ":eid-feature-impl"
val eidWsClientProjectPath = ":eid-ws-client"
val eidWsCommonProjectPath = ":eid-ws-common"
val eidServiceProjectPath = ":eid-service"
val eidServiceApiProjectPath = ":eid-service-api"
include(
        eidApiProjectPath,
        eidImplProjectPath,
        eidFeatureImplProjectPath,
        eidWsClientProjectPath,
        eidWsCommonProjectPath,
        eidServiceProjectPath,
        eidServiceApiProjectPath
)

val documentApiProjectPath = ":document-api"
val documentImplProjectPath = ":document-impl"
val documentFeatureImplProjectPath = ":document-feature-impl"
include(
        documentApiProjectPath,
        documentImplProjectPath,
        documentFeatureImplProjectPath
)

val transactioninfoProjectPath = ":transactioninfo"
val apptrackingProjectPath = ":apptracking"
val ocrProjectPath = ":ocr"
include(
        transactioninfoProjectPath,
        apptrackingProjectPath,
        ocrProjectPath
)

// correct paths
project(annotationsProjectPath).projectDir = File("$rootDir/common/annotations")
project(restCommonProjectPath).projectDir = File("$rootDir/common/rest-common")
project(redisProjectPath).projectDir = File("$rootDir/common/redis")
project(securityProjectPath).projectDir = File("$rootDir/common/security")
project(utilsProjectPath).projectDir = File("$rootDir/common/utils")
project(mqProjectPath).projectDir = File("$rootDir/common/mq")
project(restMqTrackingProjectPath).projectDir = File("$rootDir/common/rest-mq-tracking")

project(restTestProjectPath).projectDir = File("$rootDir/tools/rest-test")
project(eidMockProjectPath).projectDir = File("$rootDir/tools/eid-mock")
project(eidMockToolsProjectPath).projectDir = File("$rootDir/tools/eid-mock/eid-mock-tools")
project(demoProjectPath).projectDir = File("$rootDir/tools/demo")
project(eventPersistenceProjectPath).projectDir = File("$rootDir/tools/event-persistence")
project(mobileSpConnectorPath).projectDir = File("$rootDir/tools/mobile-sp-connector")
project(v2AdapterPath).projectDir = File("$rootDir/tools/v2-adapter")

project(eidApiProjectPath).projectDir = File("$rootDir/features/eid/eid-api")
project(eidImplProjectPath).projectDir = File("$rootDir/features/eid/eid-impl")
project(eidFeatureImplProjectPath).projectDir = File("$rootDir/features/eid/eid-feature-impl")
project(eidWsClientProjectPath).projectDir = File("$rootDir/features/eid/eid-ws-client")
project(eidWsCommonProjectPath).projectDir = File("$rootDir/features/eid/eid-ws-common")
project(eidServiceProjectPath).projectDir = File("$rootDir/features/eid/eid-service")
project(eidServiceApiProjectPath).projectDir = File("$rootDir/features/eid/eid-service-api")

project(documentApiProjectPath).projectDir = File("$rootDir/features/document/document-api")
project(documentImplProjectPath).projectDir = File("$rootDir/features/document/document-impl")
project(documentFeatureImplProjectPath).projectDir = File("$rootDir/features/document/document-feature-impl")

project(transactioninfoProjectPath).projectDir = File("$rootDir/features/transactioninfo")
project(apptrackingProjectPath).projectDir = File("$rootDir/features/apptracking")
project(ocrProjectPath).projectDir = File("$rootDir/features/ocr")
