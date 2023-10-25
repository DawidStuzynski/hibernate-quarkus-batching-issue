package org.acme.services

import io.smallrye.mutiny.Uni
import jakarta.enterprise.context.ApplicationScoped
import org.acme.enities.ChildEntity
import org.acme.enities.ParentEntity
import org.acme.repositories.ExampleRepository

@ApplicationScoped
class ExampleService(private val repository: ExampleRepository) {

    fun save(): Uni<ParentEntity> {
        val entity = ParentEntity()
        addChildEntities(entity)
        return repository.saveExampleEntity(entity)
    }

    private fun addChildEntities(entity: ParentEntity) {
        val childEntities = listOf(
            ChildEntity("Field1", entity),
            ChildEntity("Field2", entity),
            ChildEntity("Field3", entity)
        )

        entity.entities.addAll(childEntities)
    }
}