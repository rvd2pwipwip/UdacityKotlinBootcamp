fun main(args: Array<String>) {
    println(whatShouldIDoToday())
}

//fun getMood() = "happy"
fun getWeather() = "sunny"
fun getMood(): String {
    print("Are you happy or sad?: ")
    return readLine() ?: "happy"
}

fun whatShouldIDoToday(mood: String = getMood(), weather: String = getWeather(), temperature: Int = getTemperature()): String {
    return when {
        isSadAndRainy(mood, weather) -> "Stay home and cry"
        isSadAndCold(mood, weather, temperature) -> "Stay in bed"
        isHappyAndSunny(mood, weather) -> "Skate time!"
        isHappyAndSnowy(mood, weather, temperature) -> "Ski time!"
        else -> "Stay home and watch TV"
    }
}

fun isSadAndRainy(mood: String, weather: String) = mood == "sad" && weather == "rainy"
fun isSadAndCold(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "snowy" && temperature < 0
fun isHappyAndSunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"
fun isHappyAndSnowy(mood: String, weather: String, temperature: Int) = mood == "happy" && weather == "snowy" && temperature < 0
