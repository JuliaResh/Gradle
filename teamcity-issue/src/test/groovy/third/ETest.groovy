package third

import spock.lang.Specification

class ETest extends Specification {

    def "Passed TE test"() {
        expect:
            1 == 1
    }

}