package com.kotlinprogramming.nyethack

import java.io.File
import java.util.*

class Player(_name: String,
             var healthPoints: Int,
             val isBlessed: Boolean,
             private val isImmortal: Boolean) {

    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) { field = value.trim() }

    val hometown by lazy { selectHometown() }

    private fun selectHometown() = File("data/towns.txt")
            .readText()
            .split("\n").shuffled().first()

    init {
        require(healthPoints > 0) { "Health points must be greater than zero" }
        require(name.isNotBlank()) { "Player must have a name" }
    }

    // secondary constructor
    constructor(name: String) : this(name,
                                healthPoints = 100,
                                isBlessed = true,
                                isImmortal = false) {
        // adding logic
        if (name.lowercase(Locale.getDefault()) == "kar") healthPoints = 40
    }

    // define class functions
    fun castFireball(numFireballs : Int = 2) {
        println("A glass of Fireball springs into existence. (*$numFireballs)")
    }

    fun formatHealthStatus(): String {
        val healthStatus = when (healthPoints) {
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
            if (isBlessed && healthPoints >= 50 || isImmortal) "GREEN" else "NONE"
}
