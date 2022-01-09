import java.util.*

fun main() {
    var beverage = readLine()
    beverage = null
    beverage?.let {
        beverage = it.capitalize() } ?: println("I can't do that without crashing - beverage was null!")

//    if (beverage != null) {
//        beverage = beverage.capitalize()
//        println(" not null")
//    } else {
//        println("I can't do that without crashing - beverage was null!")
//    }
}

