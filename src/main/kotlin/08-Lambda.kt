import java.util.stream.Collectors

fun main(args: Array<String>) {
    // Consider another list of numbers
    val numbers = (1..20).toList()

    // This is the java equivalent of filtering a collection
    val evens = numbers.stream()
            .filter({ num -> num % 2 == 0 })
            .collect(Collectors.toList())

    // When using pure kotlin, filtering evens is as easy as this
    val kotlinEvens = numbers
            .filter { it % 2 == 0 }

    // Notice the syntax for lambda's. All below have the same result!
    // long syntax, lambda as parameter and variable declaration
    numbers.filter({ num -> num % 2 == 0 }) 
    // Lambda's with one variable can omit the variable declaration, and use 'it' to access it  
    numbers.filter({ it % 2 == 0 }) 
    // When the last (or only) parameter of a function is a lambda, you can move it out of the parenthesis
    numbers.filter() { it % 2 == 0 }
    // When the above case is true and the parenthesis are empty, you can delete them altogether
    numbers.filter { it % 2 == 0 }
    
    // Compact lambdas!
}