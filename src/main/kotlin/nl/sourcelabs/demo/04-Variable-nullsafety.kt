package nl.sourcelabs.demo

fun main(args: Array<String>) {
    // Strong type inference, meaning that this
    val aString: String = "string"
    // Is the same as this. Kotlin can infer the type from the assignment. If it is
    // clear what the type is, you can omit it in the declaration.
    val aStringToo = "string"
    
    // Variables are mutable and declared with the keyword 'var'
    var mutable = "x"
    // Values are immutable and declared with the keyword 'val' 
    val immutable = "y"
    // Values cannot be reassigned, where variables can.

    // In Kotlin there are no primitives. Everything is an object. Kotlin does
    // compile back to Java primitives based on the nullability of the types. 
    // For instance: a nullable Boolean in Kotlin == Boolean 
    // and the non-nullable equivalent == boolean
    
    // By default, Kotlin will infer types to be non-nullable.
    val notNullable: String = "notnull"
    // Which makes sense, because assigning null as below gives no insight in the type.
    // The declaration below without explicit typing would resolve to Any? - a nullable Any.
    // Any is the root of the type hierarchy for Kotlin -- not the same as Object!
    val nullable: String? = null
    
    // Nullsafe call, will not throw an NPE BUT will return null when nullable == null
    val x = nullable?.toUpperCase()
    // Nullsafe call with elvis operator. When the lefthand side of the elvis operator
    // resolves to null, the default will be returned
    val y = nullable?.toUpperCase() ?: "DEFAULT"
    // Null asserted call, will throw NPE at runtime when nullable == null
    val z = nullable!!.toUpperCase()
}