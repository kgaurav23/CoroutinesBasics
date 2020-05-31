package flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        sendNumbers().collect {
            println("Received $it")
        }
    }
}

// Multiple ways to create flow mentioned below!

/*fun sendNumbers() = flow {
    for (i in 1..10)
        emit(i)
}*/

// fun sendNumbers() = listOf(1,2,3).asFlow()

fun sendNumbers() = flowOf("One", "Two", "Three", 4, 5, false)