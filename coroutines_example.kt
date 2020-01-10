// * 60 fps - refresh every 16ms
// * Network/Database calls, CPU intensive heavy operations take more than 16ms
// * We need to load these jobs off the main thread since we don't want to block the main thread from handling UI rendering/interactions. (Bad UX)

// Kotlin Coroutines
// - Replaces callbacks
// - Main (thread) safety

// # 1 - On the Main thread
// 'blocking style' - will block the main thread
fun onDataNeeded() {
  val result = networkRequest()
  show()
}

// # 2 - With callbacks
// 'non-blocking style' - will not block the main thread
fun onDataNeeded() {
  networkRequest() { result ->
    show(result)
  }
}

// * Problems
// - "callback hell"
// - error handling is hard

// # 3 - Using coroutines
// 'suspend' coroutines 'instead of blocking' and when it's ready it will 'resume'
// synchronous style code.
suspend fun onDataNeeded() {
  val result = networkRequest()
  show(result)
}

suspend fun networkRequest() {
  // ...
}
