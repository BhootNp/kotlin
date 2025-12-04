package com.example.kotlin.repository

import javax.security.auth.callback.Callback

interface UserRepo {

    fun login(email: String, password: String,
              callback: (Boolean, String?) -> Unit)

    fun register()

    fun getUserById()

    fun getCurrentUser()

    fun deleteUser()

    fun updateProfile()
}