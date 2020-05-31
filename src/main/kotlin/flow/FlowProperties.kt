package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/* Flow properties:
 1. Flows are cold: The code does not run until the 'collect' function is called!
 2. A flow can't be cancelled by itself, it can only be cancelled when encompassing coroutine is cancelled!



 */

fun main() {

    runBlocking {
        val numbers = sendNewNumbers()
        println("Flow hasn't started yet")
        println("Starting flow now")

        withTimeoutOrNull(1000L) {
            numbers.collect { println("Received $it") }
        }
    }


}

//fun sendNewNumbers() = listOf(1,2,3).asFlow()

fun sendNewNumbers() = flow {
    listOf(1,2,3).forEach {
        delay(400L)
        emit(it)
    }
}