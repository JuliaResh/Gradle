package second

import spock.lang.Specification

class GTest extends Specification {

    def "Passed SG test"() {
        expect:
            1 == 1
    }

}