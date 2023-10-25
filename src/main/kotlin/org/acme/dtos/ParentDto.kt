package org.acme.dtos

data class ParentDto(
    val parentId: Long?,
    val list: List<ChildDto>
)