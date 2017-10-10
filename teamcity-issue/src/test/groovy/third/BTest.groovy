package third

import spock.lang.Specification

class BTest extends Specification {

    def "Passed TB test"() {
        expect:
            1 == 1
    }

}