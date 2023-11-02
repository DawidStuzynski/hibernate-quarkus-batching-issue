package org.acme.config

import io.hypersistence.optimizer.HypersistenceOptimizer
import io.hypersistence.optimizer.core.config.JpaConfig
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManagerFactory

class HypersistenceConfiguration {

    @ApplicationScoped
    fun hypersistenceOptimizer(entityManagerFactory: EntityManagerFactory): HypersistenceOptimizer {
        return HypersistenceOptimizer(JpaConfig(entityManagerFactory))
    }
}
