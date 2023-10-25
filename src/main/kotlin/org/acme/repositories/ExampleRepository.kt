package org.acme.repositories

import io.quarkus.hibernate.reactive.panache.common.WithTransaction
import io.quarkus.hibernate.reactive.panache.kotlin.PanacheRepository
import io.smallrye.mutiny.Uni
import jakarta.enterprise.context.ApplicationScoped
import org.acme.enities.ParentEntity

@ApplicationScoped
class ExampleRepository : PanacheRepository<ParentEntity> {

    @WithTransaction
    fun saveExampleEntity(entity: ParentEntity): Uni<ParentEntity> {
        return persist(entity)
    }
}