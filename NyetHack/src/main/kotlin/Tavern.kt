import java.io.File
import kotlin.math.max
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

//val patronList: List<String> = listOf("Eli", "Mordoc", "Sophie")
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
// set
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
// read file into a list
val menuList = File("data/tavern-menu-data.txt").readText().split("\n")
// map
val patronGold = mutableMapOf<String, Double>()

fun main() {

    // display the menu
    displayTavernMenu()

    // Check whether a specific patron is here or already leaving
    checkPatronsHere()

    createUniquePatrons()

    // Gold
    uniquePatrons.forEach { patronGold[it] = 6.0 }

    printAllOrders()


}

private fun printAllOrders() {
    // while loop
    var orderCount = 0
    while (orderCount <= 5) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }

    displayPatronBalances()
}

private fun displayPatronBalances() {
    patronGold.forEach { (name, gold) -> println("$name,balance: ${"%.2f".format(gold)}") }
}

private fun createUniquePatrons() {
    (0..5).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)
}

private fun checkPatronsHere() {
    // list contains single item?
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards")
    }
    else {
        println("The tavern master says: Eli isn't here")
    }

    // list contains multiple items?
    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    }
    else {
        println("The tavern master says: Nay, they departed hours ago.")
    }
}


fun placeOrder(patronName: String, menuData : String) {
    // build the scene
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their orders.")

    // Get data from menu
    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price"
    println(message)

    // purchase
    performPurchase(patronName, price.toDouble())

    // result
    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name")}!"
    } else {
        "$patronName says : Thanks for th $name."
    }
    println(phrase)
    println()
}

private fun performPurchase(patronName:String, price: Double) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun toDragonSpeak(phrase : String) : String =
    phrase.replace(Regex("[aeiou]")) {
        when(it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

// Challenge 1
fun displayTavernMenu() {
    var maxLength = menuList.maxOf { it.length }
    val banner = "Welcome to Taernyl's Folly"
    maxLength = max(maxLength, banner.length)
    // println(maxLength)

    val total = maxLength + 10

    // print banner
    banner.apply {
        val number = (total - (this.length + 2)) / 2
        printMultipleSignal("*", number)
        print(" $this ")
        printMultipleSignal("*", number)
        println()
    }

    // print menuList
    menuList.forEach {
        it.apply {
            val (_, name, price) = this.split(",")
            val number = (total - (name.length + price.length + 2))
            print("$name ")
            printMultipleSignal(".", number)
            print(" $price")
            println()
        }
    }
    println()
}

fun printMultipleSignal(signal : String, number : Int) {
    (0 until number).forEach { _ ->
        print(signal)
    }
}

// Challenge 2 : could not figure out the most efficient solution using list
// maybe complete it with map


