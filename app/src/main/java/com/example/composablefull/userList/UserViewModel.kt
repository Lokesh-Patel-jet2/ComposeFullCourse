package com.example.composablefull.userList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository): ViewModel() {

    private val _user = MutableStateFlow<List<User>>(emptyList())
    val user = _user

    fun fetchUser(){

        viewModelScope.launch {
            try {
                val result = userRepository.getUsers()
                _user.value = result
            }
            catch (e : Exception){
                e.printStackTrace()
            }
        }
    }
}