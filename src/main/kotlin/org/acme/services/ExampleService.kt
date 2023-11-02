package org.acme.services

import jakarta.enterprise.context.ApplicationScoped
import org.acme.dtos.ChildDto
import org.acme.dtos.ParentDto
import org.acme.enities.ChildEntity
import org.acme.enities.ParentEntity
import org.acme.repositories.ExampleRepository

@ApplicationScoped
class ExampleService(private val repository: ExampleRepository) {

    fun save(): ParentDto {
        val entity = ParentEntity("")
        addChildEntities(entity)
        repository.saveExampleEntity(entity)
        return toDto(entity)
    }

    private fun addChildEntities(entity: ParentEntity) {
        val childEntities = listOf(
            ChildEntity("Field1", entity),
            ChildEntity("Field2", entity),
            ChildEntity("Field3", entity),
            ChildEntity("Field4", entity)
        )
        childEntities.forEach {
            entity.addEntity(it)
        }
    }

    fun toDto(entity: ParentEntity): ParentDto {
        return ParentDto(entity.stringField, entity.id, getChildDtos(entity))
    }

    fun getChildDtos(entity: ParentEntity): List<ChildDto> {
        return entity.entities.map {
            ChildDto(it.id, it.field)
        }.toList()
    }
}