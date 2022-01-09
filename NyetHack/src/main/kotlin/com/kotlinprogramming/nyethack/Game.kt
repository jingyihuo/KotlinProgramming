package com.kotlinprogramming.nyethack

fun main(args: Array<String>) {
    // create an instance of Player
    val player = Player("Madrigal")
    player.castFireball()

    var currentRoom : Room = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    // player status
    printPlayerStatus(player)
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

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) (isBlessed: ${if(player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}








