fun main() {
    runSimulation()
}

// not very clear with the inline keyword
fun runSimulation() {
    val greetingsFunction = configureGreetingFunctions()
    print(greetingsFunction("Jenny"))
}

fun printConstructionCost(numBuildings : Int) {
    val cost = 500
    println("construction cost : ${numBuildings * cost}")
}

// input: no arguments
// output: function (input String, output String)
fun configureGreetingFunctions() : (String) -> String {
    val constructionType = "hospital"
    var numBuildings = (1..5).random()
    return {
        playerName : String ->
        val currentYear = 2022
        numBuildings += 1
        println("Adding $numBuildings $constructionType!")
        "Welcome to SimVillage, $playerName! (copyright: $currentYear)"
    }
}
