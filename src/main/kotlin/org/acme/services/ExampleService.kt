package org.acme.services

import io.smallrye.mutiny.Uni
import jakarta.enterprise.context.ApplicationScoped
import org.acme.dtos.ChildDto
import org.acme.dtos.ParentDto
import org.acme.enities.ChildEntity
import org.acme.enities.ParentEntity
import org.acme.repositories.ExampleRepository

@ApplicationScoped
class ExampleService(private val repository: ExampleRepository) {

    fun save(): Uni<ParentDto> {
        val entity = ParentEntity()
        addChildEntities(entity)
        return repository.saveExampleEntity(entity).map {
            toDto(it)
        }
    }

    private fun addChildEntities(entity: ParentEntity) {
        val childEntities = listOf(
            ChildEntity("Field1", entity),
            ChildEntity("Field2", entity),
            ChildEntity("Field3", entity),
            ChildEntity("Field4", entity)
        )

        entity.entities.addAll(childEntities)
    }

    fun toDto(entity: ParentEntity): ParentDto {
        return ParentDto(entity.id, getChildDtos(entity))
    }

    fun getChildDtos(entity: ParentEntity): List<ChildDto> {
        return entity.entities.map {
            ChildDto(it.id, it.field)
        }.toList()
    }
}