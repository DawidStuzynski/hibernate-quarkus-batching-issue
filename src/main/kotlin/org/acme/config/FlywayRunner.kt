package org.acme.config

import io.quarkus.runtime.StartupEvent
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Observes
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.flywaydb.core.Flyway

@ApplicationScoped
@Suppress("UnusedParameter")
class FlywayRunner(
    @ConfigProperty(name = "quarkus.datasource.username") private var username: String,
    @ConfigProperty(name = "quarkus.datasource.password") private var password: String,
    @ConfigProperty(name = "quarkus.datasource.reactive.url") private var url: String
) {

    fun runFlywayMigration(@Observes event: StartupEvent) {
        Flyway.configure()
            .baselineOnMigrate(true)
            .dataSource("jdbc:$url", username, password)
            .load()
            .migrate()
    }
}
