package com.example.kotlin.repository

import com.example.kotlin.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import javax.security.auth.callback.Callback

interface UserRepo {

    fun login(email: String, password: String,
              callback: (Boolean, String?) -> Unit)

    fun register(email: String, password: String,
                 callback: (Boolean, String, String) -> Unit)

    fun addUserToDatabase(userId : String,
                    callback: (Boolean , String) -> Unit)

    fun getUserById(userId: String,
                    callback: (Boolean, UserModel) -> Unit)

    fun getCurrentUser() : FirebaseUser ?

    fun deleteUser(userId: String,
                   callback: (Boolean, String) -> Unit)

    fun updateProfile(userId: String, model: UserModel,
                      callback: (Boolean, String) -> Unit)
}