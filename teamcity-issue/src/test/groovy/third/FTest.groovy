package third

import spock.lang.Specification

class FTest extends Specification {

    def "Passed TF test"() {
        expect:
            1 == 1
    }

}