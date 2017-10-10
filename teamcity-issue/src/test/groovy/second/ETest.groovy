package second

import spock.lang.Specification

class ETest extends Specification {

    def "Passed SE test"() {
        expect:
            1 == 1
    }

}