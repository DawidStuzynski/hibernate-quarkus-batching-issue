package org.acme.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.acme.enities.ParentEntity

@ApplicationScoped
class ExampleRepository : PanacheRepository<ParentEntity> {

    @Transactional
    fun saveExampleEntity(entity: ParentEntity){
        persist(entity)
    }
}