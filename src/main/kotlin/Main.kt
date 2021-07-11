fun main() {
    val previousPurchase = 10001_00
    val currentPurchase = 1000_00
    val isMelomaniac = true
    val generalDiscount: Int
    val discountForMelomaniac = 0.01

    generalDiscount = if (previousPurchase > 0 && previousPurchase <= 1000_00) {
        0
    } else if (previousPurchase > 1_000_00 && previousPurchase <= 10_000_00) {
        100_00
    } else if (previousPurchase > 10_000) {
        (currentPurchase * 0.05).toInt()
    } else {
        throw Exception("переменная previousPurchase должна быть положительным числом")
    }

    val discountInRubles = (currentPurchase - generalDiscount) / 100
    val totalWithDiscount =
        if (!isMelomaniac) discountInRubles
        else discountInRubles - (discountInRubles * discountForMelomaniac)

    if (generalDiscount == 0) {
        if (isMelomaniac) {
            println(
                """
покупка - ${currentPurchase / 100} рублей -> 
                    
после применения 1% скидки - $totalWithDiscount рублей
""".trimMargin()
            )
        } else {
            println("покупка - ${currentPurchase / 100} рублей")
        }
    } else if (generalDiscount == 100_00) {
        if (isMelomaniac) {
            println(
                """
покупка - ${currentPurchase / 100} рублей -> 
                    
после применения скидки 100 рублей - $discountInRubles рублей

после применения 1% скидки - $totalWithDiscount рублей
""".trimMargin()
            )
        } else {
            println(
                """
покупка - ${currentPurchase / 100} рублей -> 
                    
после применения скидки 100 рублей - $discountInRubles рублей
""".trimMargin()
            )
        }
    } else
        if (isMelomaniac) {
            println(
                """
покупка - ${currentPurchase / 100} рублей -> 
                    
после применения 5% скидки - $discountInRubles рублей

после применения 1% скидки - $totalWithDiscount рублей
""".trimMargin()
            )
        } else {
            println(
                """
покупка - ${currentPurchase / 100} рублей -> 
                    
после применения 5% скидки - $discountInRubles рублей
""".trimMargin()
            )
        }
}