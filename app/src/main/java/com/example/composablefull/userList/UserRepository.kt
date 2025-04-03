package com.example.composablefull.userList

class UserRepository(private val apiService: ApiService) {

    suspend fun getUsers() : List<User>{
        return apiService.getUsers()
    }
}