package second

import spock.lang.Specification

class BTest extends Specification {

    def "Fail SB test"() {
        expect:
            1 != 1
    }

}