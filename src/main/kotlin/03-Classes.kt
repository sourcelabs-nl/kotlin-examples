/**
 * Consider class Animal. Say you want to extend it. To be able to do this,
 * classes need to be either open...
 * 
 * Classes also do not need a body, contrary to java
 */
open class OpenAnimal

/**
 * ...or abstract. By convention classes are specified as final and have to be 
 * declared 'open' to be able to extend/subclass them. Abstract classes are open by default
 * of course ;)
 */
abstract class Animal {
    open fun bla() {
    }
}

/**
 * Kotlin interfaces look and behave pretty much the same way as their java counterparts
 * 
 * As with regular classes, nog bodies required
 */
interface CanWalk

interface CanSwim {
    // Must be implemented
    fun implementThis()
    // interfaces can have implemented methods, these are open (overridable) by default
    fun hasBody() {}
}

/**
 * Class implementing and extending. The syntax is the same for both. Kotlin checks, compile time,
 * if you are not doing multiple-inheritance. As we still compile to the JVM multi-inheritance is not
 * possible, so you can only extend 1 class and implement several others.
 * 
 * Also notice how the class we are extending requires a constructor call, right in the declaration.
 */
class Dog : Animal(), CanWalk, CanSwim {
    // abstract method, must override this
    override fun bla() {}
    // This function from the interface must be implemented
    override fun implementThis() {}
}