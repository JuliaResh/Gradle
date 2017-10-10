package first

import spock.lang.Specification

class CTest extends Specification {

    def "Passed FC test"() {
        expect:
            1 == 1
    }

}