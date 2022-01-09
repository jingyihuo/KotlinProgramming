import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

fun main() {
    // type of drink, drink name, price
    placeOrder("shandy,Dragon's Breath,5.91") // no space between

    // placeOrder("elixir,Shirley's Temple,4.12")
}

fun placeOrder(menuData : String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their orders.")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name")}!"
    } else {
        "Madrigal says : Thanks for th $name."
    }
    println(phrase)
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


