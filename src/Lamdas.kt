fun main(args: Array<String>) {
    val rollDice = {sides: Int -> (0..sides).random()} //lambda

    val rollDice2: (Int) -> Int = {sides -> (0..sides).random()} //function type notation

//    println(rollDice(6))
//    println(rollDice2(12))

    fun gamePlay(diceRoll: Int) {
        println(diceRoll)
    }

    gamePlay(rollDice2(4))
}

