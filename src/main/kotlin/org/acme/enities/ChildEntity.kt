package org.acme.enities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "child_entity")
class ChildEntity(

    @Column(name = "field")
    val field: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_entity_id")
    val parentEntity: ParentEntity
) {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "child_entity_sq", sequenceName = "child_entity_sq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "child_entity_sq")
    var id: Long? = null
    override fun toString(): String {
        return "ChildEntity(field='$field', id=$id)"
    }
}