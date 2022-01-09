package com.kotlinprogramming.nyethack

fun main(args: Array<String>) {


    val player = Player()
    player.castFireball()

    // Aura
    val auraColor = player.auraColor()

    val healthStatus = player.formatHealthStatus()

    printPlayerStatus(auraColor, player.name, healthStatus)

//    val inebriationLevel = castFireBall(5)
//    com.kotlinprogramming.nyethack.printInebriationStatus(inebriationLevel)
}

private fun printInebriationStatus(inebriationLevel: Int) {
    val inebirationStatus = when (inebriationLevel) {
        in 1..10 -> "tipsy"
        in 11..20 -> "sloshed"
        in 21..30 -> "soused"
        in 31..40 -> "stewed"
        else -> "..t01St3d"
    }
    println(inebirationStatus)
}

private fun printPlayerStatus(
    auraColor: String,
    name: String,
    healthStatus: String
) {
    println(auraColor)
    println("$name $healthStatus")
}








