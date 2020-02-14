package info.novatec.test

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("info.novatec.test")
                .mainClass(Application.javaClass)
                .start()
    }
}