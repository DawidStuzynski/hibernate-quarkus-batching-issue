package org.acme.dtos

data class ParentDto(
    val stringFiled: String,
    val parentId: Long?,
    val list: List<ChildDto>
)