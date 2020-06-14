package basics

import kotlin.concurrent.thread

fun main() {

    val startTime = System.currentTimeMillis()

    // create 1_000_000 threads and print "."
    repeat(1_000_000) {
        thread {
            print(".")
        }
    }

    val endTime = System.currentTimeMillis()

    println()
    println("Total time taken: ${endTime - startTime} ms")
}