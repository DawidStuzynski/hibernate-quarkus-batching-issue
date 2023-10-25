package org.acme

import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.Test
import org.testcontainers.junit.jupiter.Testcontainers

@QuarkusTest
@Testcontainers
@QuarkusTestResource(PostgresResource::class)
class ExampleResourceTestIT {

    @Test
    fun `test for batching`() {

        When {
            get("hello/api1")
        } Then {
            statusCode(200)
        } Extract {
            val result = body().asString()
            println("result=$result")
        }
    }
}
