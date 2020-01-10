package Aquarium

fun main(args: Array<String>) {
    buildAquarium()
    makeFish()
//    val simpleSpice = SimpleSpice()
//    println("${simpleSpice.name} ${simpleSpice.heat}")
//    fishExample()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    println("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} " +
            "Height: ${myAquarium.height} ")
    myAquarium.height = 80

    println("Height: ${myAquarium.height} cm")
    println("Volume: ${myAquarium.volume} liters")

    val smallAquarium = Aquarium(20, 15, 30)
    println("Small aquarium: ${smallAquarium.volume} liters")

    val myAquarium2 = Aquarium(numberOfFish = 9)
    println("Small aquarium 2: ${myAquarium2.volume} liters with " +
            "length ${myAquarium2.length} " +
            "width ${myAquarium2.width} " +
            "height ${myAquarium2.height}"
            )
}

fun feedFish(fish: FishAction) {
    // make some food then
    fish.eat()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color} \nPlecostomus: ${pleco.color}")

    shark.eat()
    pleco.eat()
}




fun fishExample() {
    val fish = Fish(true, 20)
    println("Is the friendly? ${fish.friendly}. It needs volume ${fish.size}")
}

fun makeDefaultFish() {
    val fish = Fish(true, 50)
}


