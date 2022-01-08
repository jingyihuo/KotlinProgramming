fun main() {
    // shorthand
    runSimulation("Jenny", ::printConstructionCost) {
        playerName, numBuildings ->
        println("Adding $numBuildings house!")
        val currentYear = 2018
        "Welcome to SimVillage, $playerName! (copyright: $currentYear)"
    }
}

// not very clear with the inline keyword
inline fun runSimulation(playerName : String,
                         costPrinter : (Int) -> Unit,
                         greetingsFunction: (String, Int) -> String) {
    val numBuildings = (1..3).random()
    costPrinter(numBuildings)
    println(greetingsFunction(playerName, numBuildings))
}

fun printConstructionCost(numBuildings : Int) {
    val cost = 500
    println("construction cost : ${numBuildings * cost}")
}
