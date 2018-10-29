package mypackage

import groovy.util.logging.Slf4j


@Slf4j
class MyClass {
    def method() {
        log.debug "Debug"
        println "Hello"
    }

    def sum(one, two) {
        println 'sum is called'
        return one + two
    }
}
