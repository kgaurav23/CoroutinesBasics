package basics

import kotlinx.coroutines.*

fun main() {

    runBlocking {

        /*launch(Dispatchers.Main) {
            println("Main Dispatcher: Thread: ${Thread.currentThread().name}")
        }*/

        launch(Dispatchers.Unconfined) {
            println("Unconfined1: Thread: ${Thread.currentThread().name}")
            delay(100)
            println("Unconfined2: Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default: Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO: Thread: ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("MyNewThread")) {
            println("newSingleThreadContext: Thread: ${Thread.currentThread().name}")
        }
    }


}