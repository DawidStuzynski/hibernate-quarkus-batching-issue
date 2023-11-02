package org.acme.enities

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.SequenceGenerator

@Entity
class ParentEntity(
    val stringField: String
) {

    @Id
    @SequenceGenerator(name = "parent_entity_sq", sequenceName = "parent_entity_sq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parent_entity_sq")
    var id: Long? = null

    @OneToMany(mappedBy = "parentEntity", cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    val entities: MutableSet<ChildEntity> = mutableSetOf()

    fun addEntity(entity: ChildEntity) {
        entities.add(entity)
        entity.parentEntity = this
    }

    fun removeEntity(entity: ChildEntity) {
        entities.remove(entity)
        entity.parentEntity = null
    }
}