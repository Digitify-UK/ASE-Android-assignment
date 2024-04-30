package com.example.myfirstapp.LearningKotline


data class Employee(var name: String ="", var age:Int =0){

}

fun main(){
    val emp = Employee()
    emp.name="Asif"
    emp.age =18

    //apply
  var a=  emp.apply {
        name="hassan"
        age=40
    }
    println(a)
    //let
   var b= emp.let {
        it.name="Awais"
        it.age=25

    }
    println(b)

    var c = with(emp){
        emp.name ="Zaighum"
        emp.age =60
    }
    println(c)
    var d=emp.run{
        age=34
        name="umair"
    }
    print(d)

}
