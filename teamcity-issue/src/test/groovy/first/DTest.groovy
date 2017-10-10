package first

import spock.lang.Specification

class DTest extends Specification {

    def "Passed FD test"() {
        expect:
            1 == 1
    }

}