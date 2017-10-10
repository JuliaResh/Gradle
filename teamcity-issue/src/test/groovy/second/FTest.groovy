package second

import spock.lang.Specification

class FTest extends Specification {

    def "Passed SF test"() {
        expect:
            1 == 1
    }

}