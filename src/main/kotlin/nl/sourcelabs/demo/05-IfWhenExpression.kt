package nl.sourcelabs.demo

/**
 * Consider this function as a basis for some solid refactoring. It takes a boolean
 * as a parameter and returns a string value for it, "Yes" if it is true, "No" if it isn't.
 * Pretty straightforward!
 */
fun convertToYesNoFull(boolean: Boolean): String {
    if (boolean) {
        return "Yes"
    } else {
        return "No"
    }
}

/**
 * Pretty decent start, this will work. Luckily the if, when and try statements are not actually
 * statements in Kotlin; they are expressions. Which means you can rewrite is as below, pulling up
 * the return statement. The last statement in the block will be used as the return value. Already
 * a bit better, we are no longer repeating ourselves with the return statements.
 */
fun convertToYesNoIfExpression(boolean: Boolean): String {
    return if (boolean) {
        "Yes"
    } else {
        "No"
    }
}

/**
 * Just as if, when and try are expressions, we can also define functions as expressions. This
 * allows us to get rid of the pesky return keyword altogether.
 */
fun convertToYesNoExpression(boolean: Boolean): String = if (boolean) {
    "Yes"
} else {
    "No"
}

/**
 * When using expression syntax for functions, you can also leverage the great type inference
 * that Kotlin has to offer. This means we can rewrite the function like this:
 */
fun convertToYesNoExpressionInferred(boolean: Boolean) = if (boolean) {
    "Yes"
} else {
    "No"
}

/**
 * Kotlin does not include the ternary operator we could use in java. So, nothing like
 * if(boolean) ? "Yes" : "No";
 * But, in Kotlin, blocks for if-expressions are optional when there's just one statement:
 */
fun convertToYesNoShort(boolean: Boolean) = if (boolean) "Yes" else "No"

/**
 * This is about as short as you can get with a regular function. Kotlin also allows
 * you to write extension functions though. These are functions that you can 'attach' to
 * existing classes - even final ones! The trick is that you are not really extending them
 * but are applying some wrapper logic to them - this feature is pure syntactic sugare. This
 * has a drawback, you can only access the public members of the class you are extending with
 * an extension function. Let's look at an example:
 */
fun Boolean.toYesNo() = if(this) "Yes" else "No"

/**
 * The above is usable by calling true.toYesNo(). Take a look at how this compiles to see
 * what the 'magic' behind this is. Alternatively you could also define this as an extension
 * property for the Boolean class.
 */
val Boolean.yesNo
    get() = if (this) "Yes" else "No"

/**
 * Now you can do the conversion by calling 'true.yesNo' - That's it!
 * 
 * Finally, another nice feature of extension functions: they can deal with nulls! Because
 * they are compiled as static functions taking the instance they are called on as the first 
 * parameter we can actually employ null-checks inside the extension functions! Let's say
 * we are okay with null booleans resolving to "No", implement it as follows. You can then do this:
 * 
 * val nullBool: Boolean? = null
 * println(nullBool.toYesNo()) // prints "No"
 */
fun Boolean?.toYesNo() = if (this != null && this) "Yes" else "No"