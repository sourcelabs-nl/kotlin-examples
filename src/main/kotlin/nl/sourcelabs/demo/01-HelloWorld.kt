package nl.sourcelabs.demo

/**
 * Typical main function. Top-level, not in a class, which is just simply less typing. 
 * 
 * Kotlin compiles this into a class anyway, which you can see by decompuling the code. The class file name will be
 * the filename for this file, postfixed with 'Kt'. In this case: '_01_HelloWorldKt'
 * 
 * In Intellij menu, select tools -> Kotlin -> show kotlin bytecode. In the snap-in that opens, press the decompile button
 * to check what the Java equivalent would be to your java code.
 * 
 * Conversely, if you want/need to convert some code from Java to Kotlin, there's a convenient option too.
 * In Intellij menu, select code -> Convert java file to kotlin file
 */
fun main(args: Array<String>) {
    println("Hello World")
}