package Spices

fun main(args: Array<String>) {
    val yellowCurry = Curry("Yellow Curry", "spicy")
    yellowCurry.prepareSpice()
}

abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) {
    val heat: Int
        get() {
            return when (spiciness) {
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

    abstract fun prepareSpice()
}

class Curry(name: String, spiciness: String, color: SpiceColor = YellowSpiceColor) : Spice(name, spiciness, color), Grinder {
    override fun prepareSpice() {
        grind()
    }

    override fun grind() {
        println("Ground preparation of $spiciness $name")
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: String
}

object YellowSpiceColor: SpiceColor {
    override val color = "Yellow"
}