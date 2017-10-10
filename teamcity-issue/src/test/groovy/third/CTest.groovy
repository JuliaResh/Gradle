package third

import spock.lang.Specification

class CTest extends Specification {

    def "Fail TC test"() {
        expect:
            1 != 1
    }

}