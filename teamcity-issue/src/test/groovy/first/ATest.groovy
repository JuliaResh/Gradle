package first

import spock.lang.Specification

class ATest extends Specification {

    def "Passed FA test"() {
        expect:
            1 == 1
    }

}