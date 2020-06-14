package basics

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    println("Inside Main: - START ${Thread.currentThread().name}")


    Thread {
        println("Inside Thread: - START ${Thread.currentThread().name}")

        CoroutineScope(Dispatchers.Main).launch {
            println("Inside Coroutine: - START ${Thread.currentThread().name}")
            delay(500L)
            println("Inside Coroutine: - END ${Thread.currentThread().name}")
        }

        Thread.sleep(2000L)

        println("Inside Thread: - END ${Thread.currentThread().name}")
    }.start()

    println("Inside Main: - END ${Thread.currentThread().name}")
}