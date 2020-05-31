package basics

import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.Exception
import java.lang.IndexOutOfBoundsException

fun main() {

    runBlocking {

        val myHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception handled: ${throwable.localizedMessage}")
        }

        val job = GlobalScope.launch(myHandler) {
            println("Throwing exception from job")
            throw IndexOutOfBoundsException("Exception in Coroutine!")
        }

        job.join()

        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException("exception from arithmetic")
        }

        try {
            deferred.await()
        } catch (ex: Exception) {
            println("Caught Arithmetic Exception: ${ex.localizedMessage}")
        }
    }
}