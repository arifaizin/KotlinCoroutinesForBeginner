import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() = runBlocking {
    // Step 1: default process, block other process
//    println("long running process")
//    Thread.sleep(1000L)
//    println("process done")
//    println("Hello...")

    // Step 2a: using thread, can do other process
//    thread { // fire and forget
//        println("long running process")
//        Thread.sleep(1000L)
//        println("process done")
//    }
//    println("Hello...")

    // Step 2b: using coroutine, can do other process
//    launch { // fire and forget
//        println("long running process")
//        delay(1000L)
//        println("process done")
//    }
//    println("Hello...")

    // Step 3.a: using suspend function
//    launch {
//        doLongProcess()
//    }
//    println("Hello...")

    // Step 4.a: using async to get result
    val result: Deferred<String> = async {
        doLongProcess()
    }
    println("Hello...")
    println(result.await())


    // Step 5.a: using await + await
//        val result = async {
//            doLongProcess()
//        }
//        val result2 = async {
//            doOtherLongProcess()
//        }
//        println("Hello...")
//        println(result.await() + " & " + result2.await())

    // Step 6 create and cancel job
//    val newJob = launch {
//        doLongProcess()
//    }
//    delay(500)
//    newJob.cancel()
//    if (newJob.isCancelled) {
//        println("newJob isCancelled")
//    }
//    println("Hello...")

    // Step 7 switching dispatcher
//    launch(Dispatchers.IO) {
//        println("long running process in ${Thread.currentThread().name}")
//        delay(1000L)
//        withContext(Dispatchers.Default){
//            println("process done in ${Thread.currentThread().name}")
//        }
//    }
//    println("Hello...")
}

// Step 3.b
//private suspend fun doLongProcess() {
//    println("long running process")
//    delay(1000L)
//    println("process done")
//}

// Step 4.b
private suspend fun doLongProcess(): String {
    println("long running process")
    delay(1000L)
    return "process done"
}

// Step 5.b: using await + await
private suspend fun doOtherLongProcess(): String {
    println("other long running process")
    delay(2000L)
    return "other process done"
}
