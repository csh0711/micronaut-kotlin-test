package info.novatec.test

import javax.inject.Singleton

@Singleton
class MainService(
        private val subService1: Interface1,
        private val subService2: SubService2
) {
    fun sayHello() = "${subService1.hello()} ${subService2.world()}"
}
