package first

import spock.lang.Specification

class FTest extends Specification {

    def "Passed FF test"() {
        expect:
            1 == 1
    }

}