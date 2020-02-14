package info.novatec.test

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/test")
class RestController(
        private val mainService: MainService
) {

    @Get
    fun get(): String {
        return "${mainService.sayHello()}"
    }
}