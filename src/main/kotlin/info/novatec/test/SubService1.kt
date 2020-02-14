package info.novatec.test

import javax.inject.Singleton

@Singleton
class SubService1: Interface1 {

    init {
        throw error("error")
    }
    override fun hello() = "Hello"
}
