package com.example.myfirstapp.networkingAndApiIntegrations

import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {
    @GET("/todos")
    suspend fun getTodosRequest(): Response<List<TodoModel>>

//    @POST("/createTodo")
//    fun createTodoRequest(@Body todoModel: TodoModel) : Response<createTodoResponse>
}