import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MainKtTest : StringSpec(){
    init {
        "Test something"{
            "a" shouldBe "a"
        }
    }
}
