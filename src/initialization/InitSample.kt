package initialization

class InitSample(private val s1: String = "s1") {

    // s2 и init вызовутся в порядке написания кода
    private val s2 = run {
        println(s1)
        println("S2")
    }
    init {
        println("init")
    }

    constructor(s3: String, s4: String) : this(s3) {
        println("constructor")
    }
}

fun main() {
    InitSample("s1")
    println()
    InitSample("s1", "ss4")
}