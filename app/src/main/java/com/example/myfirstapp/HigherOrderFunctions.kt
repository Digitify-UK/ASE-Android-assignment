package com.example.myfirstapp


//any Function that can take function as input through parameter and returns function is higher or
//order function.


class Learning() {
    var name :String ="asif imran";
    fun display(){
        print(this.name)
    }

    //testing higher order functions

    fun higherOrderfun(a:String, b:String, functionTest: (String,String) -> String){
        var result = functionTest(a,b)
        println(result)

    }

}
fun add(a: String, b: String): String{
    var sum = a + b
    return sum
}
fun main(){
   var learning = Learning()

//    learning.display()
    learning.higherOrderfun("asif","imran",::add)
}