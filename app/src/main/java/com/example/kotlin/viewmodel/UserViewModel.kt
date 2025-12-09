package com.example.kotlin.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kotlin.repository.UserRepo

class UserViewModel (val repo: UserRepo) : ViewModel(){
}