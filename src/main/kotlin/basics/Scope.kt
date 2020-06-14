package basics

import kotlinx.coroutines.*

fun main() {

    println("Execution will now block!!")

    runBlocking {
        launch {
            delay(1000)
            println("Task from runBlocking")
        }

        GlobalScope.launch(Dispatchers.Main) {
            delay(500)
            println("Task from GlobalScope")
        }

        coroutineScope {
            launch {
                delay(1500)
                println("Task from coroutineScope")
            }
        }
    }

    println("Program execution will now continue!!")
}