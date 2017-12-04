/**
 * Top level constants follow the same convention as previously shown for the hello world example, they
 * will be compiled into a class with the <source-file-name>Kt, in this case 02-TopLevelKt
 */

// Top level constant -> public static final String
const val HELLO = "Hello World"

// Top level value -> private static final String hello. 
// You also get public static String getHello() for this, as the
// property is 'public' for Kotlin in this instance; so kotlin defines an accessor.
val hello = HELLO

// Top level function -> public static final String hello()
fun hello() = hello

// Main function.
fun main(args: Array<String>) {
    println(hello())
}