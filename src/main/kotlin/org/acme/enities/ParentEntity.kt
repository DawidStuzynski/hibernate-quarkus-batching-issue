package org.acme.enities

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "parent_entity")
class ParentEntity {
    @OneToMany(mappedBy = "parentEntity", cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    val entities: MutableSet<ChildEntity> = mutableSetOf()

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "parent_entity_sq", sequenceName = "parent_entity_sq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parent_entity_sq")
    var id: Long? = null
}