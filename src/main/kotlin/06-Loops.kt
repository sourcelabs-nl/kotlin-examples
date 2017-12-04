fun main(args: Array<String>) {
    /**
     * Consider this list of numbers, similar to: Arrays.asList(1,2,3...);
     * Type is inferred here, the strong type inference Kotlin offers, will yield a
     * list of type Int, so the type would be 'List<Int>'
     */
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    /**
     * If we want/need to iterate over them, we can do that as listede below. The 'number' variable
     * is inferred, in this case it is of type Int, because the numbers list has generic type Int too.
     * We define we are looping over all values in the list of numbers, using the in-keyword.
     */
    for (number in numbers) {
    }

    /**
     * If we want to iterate over the list, but by index, we can define what kotlin
     * calls a progression. Kotlin does not define for(int i - 0; i < 10; i ++) type for loops.
     * We can use progressions and ranges for that.
     * A range is defined as <start>..<end>
     */
    for (number in 0..numbers.size) {
    }

    /**
     * We can also hardcode them
     */
    for (number in 0..10) {
    }

    /**
     * Define the step size (i+=2)
     */
    for (number in 0..10 step 2) {
    }

    /**
     * These are inclusive of the last value but we can also go 'until' the last value
     */
    for (number in 0 until 10) {
    }

    /**
     * Iterating backwards, also no problem. Also allows defining step sizes.
     */
    for (number in 10 downTo 1 step 3) {
    }
}