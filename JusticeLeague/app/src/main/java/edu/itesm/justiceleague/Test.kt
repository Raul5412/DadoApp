package edu.itesm.justiceleague

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
data class SuperHeroe(val nombre: String ){
    var mail: String = "Vision"
    var movil:  String = "@"
    var edad : Int = 56

    override fun toString(): String = "$nombre : $edad "
}



fun main() {
    println("Hello, world!!!")

    var batman = SuperHeroe("Bruce Wayne")

    val jl = mutableListOf<SuperHeroe>()
    jl.add(batman)
    jl.add(SuperHeroe("CK"))

    println(jl)

    println(batman)
}