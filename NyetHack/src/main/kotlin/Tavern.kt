import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
//val patronList: List<String> = listOf("Eli", "Mordoc", "Sophie")
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
// read file into a list
val menuList = File("data/tavern-menu-data.txt").readText().split("\n")

fun main() {
    // list contains single item?
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards")
    } else {
        println("The tavern master says: Eli isn't here")
    }

    // list contains multiple items?
    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }

    // println(menuList.size)

    patronList.forEachIndexed { index, patron ->
        println("Good evening, $patron, you're #${index + 1} inline")
        val k = menuList.shuffled().first()
        // println(k)
        placeOrder(patron, k) }

    menuList.forEachIndexed { index, data ->
        println("#$index, $data")
    }
}

fun placeOrder(patronName: String, menuData : String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their orders.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price"
    println(message)

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name")}!"
    } else {
        "$patronName says : Thanks for th $name."
    }
    println(phrase)
    println()
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

private fun performPurchase(price : Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total Purse: $totalPurse")
    println("Purchasing item for $price")

    // subtracting
    val remainingBalance = totalPurse - price
    println("Remaining Balance: ${"%.2f".format(remainingBalance)}")

    // convert double to Int
    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerSilver = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}


