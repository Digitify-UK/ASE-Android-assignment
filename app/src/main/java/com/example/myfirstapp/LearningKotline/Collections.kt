package com.example.myfirstapp.LearningKotline

fun main(){
    //arrays
    var arrayOfNums = arrayOf(1,2,3,4,5,6,7,8)

    arrayOfNums.forEach{
        println(it)
    }
    arrayOfNums[0]=40
//    you cannot insert element at out of range index
//    arrayOfNums[10]=60



    //Lists
//    Kotlin has 2 Types of lists actually
    /*
    Mutable = which can change
    Immutable : which cannot change for example listOf

    * */
//    immutable list
    var listOfNums = listOf(1,2,3,4,5,6,7,8)
    //you cannot set any value in mutable list
//    listOfNums[3]=60

    var a = mutableListOf<String>()
    var filterdata = listOfNums.filter{it %2 ==0}
    for( num in arrayOfNums){
        print("$num ")
    }
    listOfNums.forEach{
        println(it)
    }

// Maps
//Mutable maps
    var map = mutableMapOf<Int, String>(
        1 to "asif",
        2 to "ali"
    )

    map.put(3,"Imran")
    map.putIfAbsent(2,"Asif")

    for( (key,value)  in map){
        println("$key = $value")
    }
//Imutable Map
    var imutablemap= mapOf<Int, Int>(
        1 to 3,
        4 to 5,

    )
    for( (key,value)  in imutablemap){
        println("$key = $value")
    }
}