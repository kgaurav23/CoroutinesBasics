package basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Complete hierarchy of jobs will be cancelled if one of the job will be cancelled!!
fun main() {

    runBlocking {

        val job1 = launch {
            //delay(3000)
            println("Job1 launched")

            val job2 = launch {
                println("Job2 launched")
                delay(3000)
                println("Job2 is finishing")
            }

            job2.invokeOnCompletion { println("Job2 is finished!") }

            val job3 = launch {
                println("Job3 launched")
                delay(3000)
                println("Job3 is finishing")
            }

            job3.invokeOnCompletion { println("Job3 is finished!") }
        }

        job1.invokeOnCompletion { println("Job1 is finished!") }


        delay(500)
        println("Job1 will be cancelled")
        job1.cancel()
    }
}