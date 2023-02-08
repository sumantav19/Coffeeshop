import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import kotlin.coroutines.CoroutineContext

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    val orders : List<Order> = listOf(
        Order(coffeeBeans = CoffeeBeans.Decaf, milk = Milk.NonFat),
        Order(coffeeBeans = CoffeeBeans.Premium, milk = Milk.Breve),
        Order(coffeeBeans = CoffeeBeans.Regular, milk = Milk.Whole),
        Order(coffeeBeans = CoffeeBeans.Regular, milk = Milk.NonFat),
    )

    makeCoffee(orders)
}

fun makeCoffee(orders : List<Order>) =  runBlocking(Dispatchers.Default){
    for (order in orders){
        logger.info { "processing order $order" }
        val groundBeans =  grindCoffeeBeans(order.coffeeBeans)
        val expressoShot =  pullExpressoShot(groundBeans)
        val steamedMilk = steamMilk(order.milk)
        val cappuchino = makeCappuchino(order,expressoShot,steamedMilk)
        logger.info { "serve $cappuchino \n" }
    }
}