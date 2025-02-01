package com.example.todoapp

import java.time.Instant
import java.util.Date

data class ToDo(
    var id: Int,
    var title: String,
    var createdAt: Date,
)

fun getFakeTodo(): List<ToDo> {
    return listOf<ToDo>(
        ToDo(1, "Todo 1", Date.from(Instant.now())),
        ToDo(2, "Todo 2", Date.from(Instant.now())),
        ToDo(3, "Todo 3", Date.from(Instant.now())),
        ToDo(4, "Todo 4", Date.from(Instant.now())),
    )
}
