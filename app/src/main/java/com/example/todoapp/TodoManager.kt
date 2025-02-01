package com.example.todoapp

import java.time.Instant
import java.util.Date

object TodoManager {

    private val todoList = mutableListOf(
        ToDo(1, "Study english", Date.from(Instant.now())),
        ToDo(2, "Do math homework", Date.from(Instant.now())),
        ToDo(3, "Go to a chess tournament", Date.from(Instant.now())),
        ToDo(4, "Read a book", Date.from(Instant.now())),
        ToDo(5, "Meet with friends", Date.from(Instant.now())),
        ToDo(6, "Download and read an e-book", Date.from(Instant.now())),
        ToDo(7, "Clean the house", Date.from(Instant.now())),
        ToDo(8, "Go for a walk", Date.from(Instant.now())),
        ToDo(9, "Check emails", Date.from(Instant.now())),
        ToDo(10, "Go shopping", Date.from(Instant.now())),

    )



    fun getAllTodo(): List<ToDo>{
        return todoList
    }

    fun addTodo( title: String){
        todoList.add(ToDo(System.currentTimeMillis().toInt(), title, Date.from(Instant.now())))
    }

    fun deleteTodo(id: Int){
        todoList.removeIf { it.id == id}
    }


}