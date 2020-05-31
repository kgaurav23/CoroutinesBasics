package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
//        for(y in produceSquares())
//            println(y)

        produceSquares().consumeEach { println(it) }
    }
}

fun CoroutineScope.produceSquares() = produce {
    for (x in 1..5) {
        send(x * x)
    }
}

