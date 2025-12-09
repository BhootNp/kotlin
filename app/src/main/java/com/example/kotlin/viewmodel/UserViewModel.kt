package com.example.kotlin.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kotlin.model.UserModel
import com.example.kotlin.repository.UserRepo
import com.google.firebase.auth.FirebaseUser

class UserViewModel (val repo: UserRepo) : ViewModel(){
    fun login(email: String, password: String,
              callback: (Boolean, String?) -> Unit)
    {

    }

    fun register(email: String, password: String,
                 callback: (Boolean, String, String) -> Unit)
    {

    }
    fun addUserToDatabase(userId : String,
                          callback: (Boolean , String) -> Unit)
    {

    }
    fun getUserById(userId: String,
                    callback: (Boolean, UserModel) -> Unit)
    {

    }
    fun getAllUser(callback: (Boolean, List<UserModel>) -> Unit)
    {

    }
    fun getCurrentUser() : FirebaseUser ?
    {

    }
    fun deleteUser(userId: String,
                   callback: (Boolean, String) -> Unit)
    {

    }
    fun updateProfile(userId: String, model: UserModel,
                      callback: (Boolean, String) -> Unit)
    {

    }
}
