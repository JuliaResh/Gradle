package third

import spock.lang.Specification

class GTest extends Specification {

    def "Passed TG test"() {
        expect:
            1 == 1
    }

}