fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoint = 89
    val isBlessed = true
    val isImmortal = false;
    val auraVisible = isBlessed && healthPoint >= 50 || isImmortal

    // 三段式
    val auraColor = if (auraVisible) "GREEN" else "NONE"

    val healthStatus = if (healthPoint == 100) {
        "is in excellent condition!"
    } else if (healthPoint >= 90) {
        "has a few scratches."
    } else if (healthPoint >= 75) {
        if (isBlessed) {
            "has some minor wounds but is healing quite quickly."
        } else {
            "has some minor wounds."
        }
    } else if (healthPoint >= 15) {
        "looks pretty hurt."
    } else {
        "is in awful condition!"
    }

    println(auraColor)
    println("$name $healthStatus");
}
