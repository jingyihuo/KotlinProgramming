const val TAVERN_NAME = "Taernyl's Folly"

fun main() {
    // type of drink, drink name, price
    placeOrder("shandy,Dragon's Breath,5.91") // no space between

    placeOrder("elixir,Shirley's Temple,4.12")
}

fun placeOrder(menuData : String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their orders.")

    // menu
//    val data = menuData.split(',')
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]
    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

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


