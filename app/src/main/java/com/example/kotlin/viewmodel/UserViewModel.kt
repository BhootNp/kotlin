package com.example.kotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin.model.UserModel
import com.example.kotlin.repository.UserRepo
import com.google.firebase.auth.FirebaseUser

class UserViewModel (val repo: UserRepo) : ViewModel(){

    fun login(email: String, password: String,
              callback: (Boolean, String?) -> Unit)
    {
    repo.login(email, password, callback)
    }

    fun register(email: String, password: String,
                 callback: (Boolean, String, String) -> Unit)
    {
    repo.register(email, password, callback)
    }

    fun addUserToDatabase(userId : String,
                          callback: (Boolean , String) -> Unit)
    {
        repo.addUserToDatabase(userId, callback)
    }

    private val _user = MutableLiveData<UserModel>()
    val users : MutableLiveData<UserModel>
    get() = _user

    private val _allUsers = MutableLiveData<UserModel>()
    val allUsers : MutableLiveData<UserModel>
        get() = _allUsers

    fun getUserById(userId: String)
    {

    }

    fun getAllUser()
    {

    }

    fun getCurrentUser() : FirebaseUser ?
    {
    return repo.getCurrentUser()
    }

    fun deleteUser(userId: String,
                   callback: (Boolean, String) -> Unit)
    {
    repo.deleteUser(userId, callback)
    }

    fun updateProfile(userId: String, model: UserModel,
                      callback: (Boolean, String) -> Unit)
    {
    repo.updateProfile(userId, model, callback)
    }
}
