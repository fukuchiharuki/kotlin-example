package kotlinexample

val app = App()

fun main(args: Array<String>) {
  ConsoleArguments(args).also { app(it) }
}
