package org.acme

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container

internal class PostgresResource : QuarkusTestResourceLifecycleManager {

    @Container
    val postgres = PostgreSQLContainer("postgres:15.4")
        .withCommand(
            "postgres",
            "-c",
            "log_statement=all",
            "-c",
            "log_destination=stderr"
        )

    override fun start(): MutableMap<String, String> {
        postgres.start()
        return mutableMapOf(
            Pair("quarkus.datasource.reactive.url", postgres.jdbcUrl.replace("jdbc:", "") + "?EncMode=disable%20reWriteBatchedInserts=true"),
            Pair("quarkus.datasource.username", postgres.username),
            Pair("quarkus.datasource.password", postgres.password)
        )
    }

    override fun stop() {
        postgres.stop()
    }
}
