package info.novatec.test

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class RestControllerTests {

    @Inject
    private lateinit var subService1: SubService1
    @Inject
    private lateinit var subService2: SubService2

    @Inject
    @field:Client("/")
    private lateinit var client: HttpClient

    @Test
    fun testIt() {
        every { subService1.hello() } returns "Hi"
        every { subService2.world() } returns "everyone"

        val result = client.toBlocking().retrieve("/test")

        assertThat(result).isEqualTo("Hi everyone")
        println(result)
    }

    @MockBean(SubService1::class)
    fun service1(): SubService1 = mockk()

    @MockBean(SubService2::class)
    fun service2(): SubService2 = mockk()

//    @Replaces(Service1::class)
//    @Singleton
//    class Service1Mock: Service1() {
//        override fun foo() = "Hi"
//    }
//
//    @Replaces(Service2::class)
//    @Singleton
//    class Service2Mock: Service2() {
//        override fun bar() = "everyone"
//    }
}
