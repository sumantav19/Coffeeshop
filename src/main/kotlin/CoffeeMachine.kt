import kotlinx.coroutines.delay
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
enum class CoffeeBeans(value:String){
    Regular("regular"),
    Premium("premium"),
    Decaf("decaf")

}

enum class Milk(value:String){
    Whole("whole"),
    NonFat("nonFat"),
    Breve("breve")
}

data class Order(
    val coffeeBeans: CoffeeBeans,
    val milk: Milk
)
suspend fun grindCoffeeBeans(beans: CoffeeBeans): CoffeeBeans{
    logger.info{"before delay"}
    delay(1000)
    logger.info{"post delay"}
    logger.info{"grinding beans $beans"}
    return beans
}

suspend fun pullExpressoShot(groundedBeans :CoffeeBeans): CoffeeBeans{
    delay(1000)
    logger.info{"pulling expresson shot"}
    return groundedBeans
}

suspend fun steamMilk(milk: Milk):Milk{
    delay(1000)
    logger.info{"warming milk"}
    return milk
}

suspend fun makeCappuchino(order: Order,groundedBeans: CoffeeBeans,steamedMilk: Milk):String{
    delay(1000)
    logger.info {  "Cappuchino"}
    return "Cappuchino"
}
