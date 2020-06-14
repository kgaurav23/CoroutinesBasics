package basics

import java.util.concurrent.CountDownLatch

fun main() {
    val latch = CountDownLatch(1_000_000)

    val startTime = System.currentTimeMillis();
    for(num: Int in 1..1_000_000) {
        Thread {
            println(num)
            latch.countDown();
        }.start();
    }

    // Main Thread will wait for all Threads to finish
    latch.await()
    val finishTime = System.currentTimeMillis ();
    println("Time taken : ${finishTime - startTime} ms")
}