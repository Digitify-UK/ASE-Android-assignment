
open class Employee(var name: String, var age: Int) {
    open fun display(){
        println(this.name)
        println(this.age)
    }

}

class Doctor(name: String, age: Int, var specialization :String ) : Employee(name,age) {
    override fun display() {
        super.display()
        println(specialization)
    }
}


fun main(){
    val d = Doctor(name = "Asif", age = 25, specialization = "Operation ward")
    d.display()
}