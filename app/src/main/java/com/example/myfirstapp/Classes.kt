package com.example.myfirstapp

class Person(var name: String, var age:Int){
    fun display(){
        println("Peson name is $name and age is $age")
    }
}

fun main(){
    var person = Person("Asif imran", 23)
    person.display()
}