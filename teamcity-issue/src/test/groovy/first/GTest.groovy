package first

import spock.lang.Specification

class GTest extends Specification {

    def "Passed FG test"() {
        expect:
            1 == 1
    }

}