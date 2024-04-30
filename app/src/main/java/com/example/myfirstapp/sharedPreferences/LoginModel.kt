package com.example.myfirstapp.sharedPreferences

data class LoginModel(private var email : String, private var password : String){
    fun getEmail() :String{
        return this.email
    }
    fun getPassword() :String{
        return this.password
    }
}
