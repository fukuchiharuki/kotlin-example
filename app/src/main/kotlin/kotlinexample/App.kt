package kotlinexample

class App {
  val greeting: String
    get() { return "Hello World!" }

  operator fun invoke() {
    println(greeting)
  }
}
