package com.kotlinprogramming.nyethack

open class Room (val name: String) {
    protected open val dangerLevel = 5

    fun description() = "Room: $name\nDanger Level: $dangerLevel"

    open fun load() = "Nothing much to see here..."
}

open class TownSquare : Room("TownSquare") {
    // override the property
    override val dangerLevel = super.dangerLevel - 3
    // Adds a private property
    private var bellSound = "GWONG"

    // any subclass of TownSquare could not override load()
    final override fun load() = "The villagers rally and cheer as you enter!"
    // Adds a private function
    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}
