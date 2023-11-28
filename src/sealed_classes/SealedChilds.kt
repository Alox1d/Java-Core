package sealed_classes

sealed class IOError() : Error // extended only in same package and module
open class CustomError() : Error // can be extended wherever it's visible

fun main() {
    println()
}

abstract class ABC {
    abstract class ABCD
}