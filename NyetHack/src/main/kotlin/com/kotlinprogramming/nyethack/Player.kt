package com.kotlinprogramming.nyethack

class Player {
    var name = "madrigal"
        get() = field.capitalize()
        private set(value) { field = value.trim() }

    var healthPoint = 89
    val isBlessed = true
    private val isImmortal = false

    // define class functions
    fun castFireball(numFireballs : Int = 2) {
        println("A glass of Fireball springs into existence. (*$numFireballs)")
    }

    fun formatHealthStatus(): String {
        val healthStatus = when (healthPoint) {
            100 -> "is in excellent condition!"
            in 90..99 -> "has a few scratches."
            in 75..89 -> if (isBlessed) {
                "has some minor wounds but is healing quite quickly."
            } else {
                "has some minor wounds."
            }
            in 15..74 -> "looks pretty hurt."
            else -> "is in awful condition!"  // must has else
        }
        return healthStatus
    }

    fun auraColor(): String =
            if (isBlessed && healthPoint >= 50 || isImmortal) "GREEN" else "NONE"
}
