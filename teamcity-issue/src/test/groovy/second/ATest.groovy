package second

import spock.lang.Specification

class ATest extends Specification {

    def "Passed SA test"() {
        expect:
            1 == 1
    }

}