fun main(args: Array<String>) {
    println("Hello ${args[0]}")
    feedTheFish()
//    println(canAddFish(10.0, listOf(3,3,3)))
//    println(canAddFish(8.0, listOf(2,2,2), hasDecorations = false))
//    println(canAddFish(9.0, listOf(1,1,3), 3))
//    println(canAddFish(10.0, listOf(), 7, true))
}

fun getDirtySensorReading() = 20
fun getTemperature() = 22

fun shouldChangeWater(
    day: String = randomDay(),
    temperature: Int = getTemperature(),
    dirty: Int = getDirtySensorReading()
): Boolean {
    return when {
        isTooHot(temperature) || isDirty(dirty) || isSunday(day) -> true
        else -> false
    }
}

var dirty = 20

val waterFilter: (Int) -> Int = {dirty -> dirty / 2}
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty, { dirty -> dirty + 50 })
}


fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")

    swim(50, "slow")

    if (shouldChangeWater(day)) {
        println("Change the water today")
    }

    dirtyProcessor()
}

fun swim(time: Int, speed: String = "fast") {
    println("swimming $speed")
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
//        "Tuesday" -> "pellets"
        "Wednesday" -> "red worms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
//        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[(week.indices).random()]
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    val size = if (hasDecorations) tankSize * 0.8 else tankSize
    return size >= currentFish.sum() + fishSize
}