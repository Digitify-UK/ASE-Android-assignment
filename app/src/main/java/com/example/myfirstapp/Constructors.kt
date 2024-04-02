//package com.example.myfirstapp

//primary constructors

class Person{
    var name:String
    var age:Int
    var id:Int
    init {
        this.name="Ali"
        this.id=0
        this.age=0
    }
    constructor( name:String,age:Int, id:Int ) {
        this.name = name
        this.age=age
        this.id=id
    }
    constructor(){
        println("Secondary constructor is called")
    }
    fun display(){

        println("${this.name} ${this.age}")
    }
//    secondary constructor

}

fun main(){
    var person =Person(name = "Asif", age= 23, id = 1234)
    var person2 =Person()
    person2.display()
    person.display()

}