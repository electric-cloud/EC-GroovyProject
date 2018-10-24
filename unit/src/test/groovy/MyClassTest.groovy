import mypackage.MyClass
import spock.lang.Specification

class MyClassTest extends Specification {

    def 'sample test'() {
        when:
        def obj = new MyClass()
        then:
        assert obj.sum(1, 2) == 3
        println 'test'
    }
}
