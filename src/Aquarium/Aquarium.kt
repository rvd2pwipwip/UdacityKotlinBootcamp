package Aquarium

import kotlin.math.PI

open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {height = (value * 1000) / (width * length)}

    open var water = volume * 0.9

    constructor(numberOfFish: Int): this() {
        val water: Int = numberOfFish * 2000 //cm3
        val tank: Double = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }
}

class TowerTank(): Aquarium() {
    override var water = volume * 0.8

    override var volume: Int
        get() = (width * height * length / 1000 * PI).toInt()
        set(value) {height = (value * 1000) / (width * length)}
}









class SimpleSpice {
    val name = "curry"
    val spiciness = "mild"
    val heat: Int
     get() = 5
}

class Spice(val name: String, val spiciness: String = "mild") {
    val heat: Int
        get() {
            return when(spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extra spicy" -> 10
                else -> 0
            }
        }
    init {
        println("$name has a spice level of $spiciness (level $heat)")
    }
}

val spices1 = listOf(
    Spice("curry", "mild"),
    Spice("pepper", "medium"),
    Spice("cayenne", "spicy"),
    Spice("ginger", "mild"),
    Spice("red curry", "medium"),
    Spice("green curry", "mild"),
    Spice("hot pepper", "extremely spicy")
)

val spiceList = spices1.filter { it.heat < 5 }

fun makeSalt() = Spice("Salt")