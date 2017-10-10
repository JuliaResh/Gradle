package first

import spock.lang.Specification

class BTest extends Specification {

    def "Passed FB test"() {
        expect:
            1 == 1
    }

}