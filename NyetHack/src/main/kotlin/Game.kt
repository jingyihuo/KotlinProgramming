fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoint = 89
    val isBlessed = true
    val isImmortal = false
    // Aura
    val auraColor = auraColor(isBlessed, healthPoint, isImmortal)

    val healthStatus = formatHealthStatus(healthPoint, isBlessed)

    printPlayerStatus(auraColor, name, healthStatus)

    val inebriationLevel = castFireBall(5)
    printInebriationStatus(inebriationLevel)
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

private fun auraColor(
    isBlessed: Boolean,
    healthPoint: Int,
    isImmortal: Boolean
): String =
    if (isBlessed && healthPoint >= 50 || isImmortal) "GREEN" else "NONE"


private fun formatHealthStatus(healthPoint: Int, isBlessed: Boolean): String {
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

// single-express function
// also Unit functions :  which means no return type
private fun castFireBall(numFireBalls : Int = 2) : Int {
    println("A glass of Fireball springs into existence. (*$numFireBalls)")
    return (1..50).random()
}


