package nl.sourcelabs.demo

/**
 * Higher order functions in Kotlin, or: functions that take a function as a
 * parameter or return a function. Let's look at a function that takes a function
 * as a parameter and executes it.
 *
 * This function takes a function with no parameters and a void return type
 * as a parameter.
 */
fun execute(function: () -> Unit) {
    function() // Execute the function we got passed to us
}

/**
 * Nice, but doesn't really add anything useful. So what if we wanted to build
 * a repeater? A function that takes a parameter specifying the number of times to
 * repeat and a function with the context to repeat?
 */
fun repeat(times: Int = 1, function: () -> Unit) {
    for (num in 1..times) { // Loop from 1 to the specified number of times
        function() // Execute the function
    }
}

/**
 * So if we want to print a string 10 times, we can call it as follows. The syntax follows
 * the rules we previously mentioned, if the last parameter of the function is a lambda
 * it can be moved out of the parenthesis. Looks quite clean that way!
 */
fun useRepeat() {
    repeat(10) {
        println("Repeat")
    }
}

/**
 * A final, nice feature that Kotlin offers when dealing with higher order functions
 * is the ability to inline them. There's runtime overhead in specifying these dynamic functions
 * but there are many variants that will allow the developer to inline the functionality.
 *
 * What this does, is that it doesn't execute the function dynamically with the lambda passed to it,
 * but rather compiles it in at the call site. This will increase execution speed as no dynamic
 * calls will be required.
 */
inline fun inlineRepeat(times: Int = 1, function: () -> Unit) {
    for (num in 1..times) { // Loop from 1 to the specified number of times
        function() // Execute the function
    }
}

/**
 * The code above can be used the same as the other function.
 */
fun useInlineRepeat() {
    inlineRepeat(10) {
        println("Repeat")
    }
}

/**
 * Looking at it in the decompiler will show the inlining magic happening.
 * 
 * Basic usage with dynamic calls:
 * 
 *    public static final void useRepeat() {
 *      repeat(10, (Function0)null.INSTANCE);
 *    }
 *    
 * or inlined. Notice how the code for both functions is combined to escape from the
 * dynamic function call. Nice!
 * 
 *    public static final void useInlineRepeat() {
 *      int times$iv = 10;
 *      int num$iv = 1;
 *      byte var2 = times$iv;
 *      
 *      while(true) {
 *          String var3 = "Repeat";
 *          System.out.println(var3);
 *          if (num$iv == var2) {
 *              return;
 *          }
 *          ++num$iv;
 *      }
 *    }
 */
