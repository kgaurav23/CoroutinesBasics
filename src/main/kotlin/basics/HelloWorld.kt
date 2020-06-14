package basics

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

runBlocking {
    CoroutineScope(Dispatchers.IO).launch {
        println("Thread1: ${Thread.currentThread().name}")
        launch {
            println("Thread2: ${Thread.currentThread().name}")

            launch {
                println("Thread3: ${Thread.currentThread().name}")

            }
        }
    }
}

}