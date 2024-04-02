package com.example.myfirstapp

//a unnamed function is called lambda
var lambda1 = {x:Int, y: Int-> x+y}

var lambda2= {a:String, b:String-> a+" " +b}

var lambda3 ={z:Double, x:Double-> z*x}

 fun calculator (a: String,b:String, x:Int,y:Int, fn:(x:Int, y:Int)->Int){
     var result = fn(x,y)
     println(result)
 }
fun calculateMul(fn:(a:Double, b:Double)->Double):Double{
    return fn(12.0,13.0)


}
fun main(){
//    if you have created lambda function instead of normal function then You don't have need to use scope resolution operator ::
//    while passing the function as parameter.
    calculator("asif","imran", x = 12, y=14, lambda1)
   val result = calculateMul({a:Double, b:Double-> a*b})
    println("Result is "+result)
}