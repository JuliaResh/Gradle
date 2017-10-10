package first

import spock.lang.Specification

class ETest extends Specification {

    def "Passed FE test"() {
        expect:
            1 == 1
    }

}