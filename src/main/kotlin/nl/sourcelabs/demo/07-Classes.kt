package nl.sourcelabs.demo

/**
 * Consider this class, money. It has two parameters, one that has a default value, defaulting
 * to dollars. 
 */
class Money(val currency: String = "$", val value: Double)

/**
 * Create instances like this. Kotlin allows named parameters, which is useful when
 *  - Classes can have a lot of confusing arguments of the same type -> Bla(String, String, String);
 *  - Can be declared out of order, so when the constructor is re-ordered, code will not break;
 *  - When constructor arguments are added with default values, the code will also not break;
 */
val m1 = Money(value = 10.0) // $ 10.0
val m2 = Money(currency = "€", value = 10.0) // € 10.0

/**
 * Money being a class means that we might want to compare instances. Consider the code below. Please
 * not that kotlin only deals with objects, and that because of that we can use == to compare equality.
 * == is an operator overloaded function that is the equivalent to equals(). So, in Kotlin, 
 * instance == otherInstance is the exact same as instance.equals(otherInstance)
 */
val m3 = Money(value = 10.0) // $ 10.0
val m4 = Money(value = 10.0) // $ 10.0
val sameMoney = m3 == m4 // false. It returns false. What gives?!

/**
 * So, to fix this we'd need to implement equals and hashcode. Also, if we wanted to 
 * print a readable representation of this class, it would also help to override toString()
 */
class MoneyEquals(val currency: String = "$", val value: Double) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MoneyEquals

        if (currency != other.currency) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        var result = currency.hashCode()
        result = 31 * result + value.hashCode()
        return result
    }

    override fun toString(): String {
        return "MoneyEquals(currency='$currency', value=$value)"
    }
}

/**
 * So we can now do this:
 */
val me1 = MoneyEquals(value = 10.0) // $ 10.0
val me2 = MoneyEquals(value = 10.0) // $ 10.0
val sameMoneyEquals = me1 == me2 // true!! yay
val sameMoneyReferenceEquals = me1 === me2 // false (as it should be) 
// We can check reference equality by using triple equals, ===

/**
 * This is quite some code to maintain, so we could do something about that. Luckily we have
 * data classes, regular classes that define equals, hashcode and toString implementations, all
 * part of the Any class at the type of the root hierarchy. This will yield less code to maintain
 * but also allows you to override this behaviour if required. This is roughly the same as the class 
 * depicted above, with one difference, it also includes an copy method!
 */
data class MoneyData(val currency: String = "$", val value: Double)

/**
 * We can use this like below
 */
val md1 = MoneyData(value = 10.0) // $ 10.0
val md2 = MoneyData(value = 10.0) // $ 10.0
val mdEquals = md1 == md2 // true
val mdReferenceEquals = md1 === md2 // false

/**
 * Now, this behaves the same as that big class we have to maintain. Very nice to
 * fit this in a one-liner! But we also have a copy method, which allows you to create
 * a copy of any instance, and modify selected values by leveraging named parameters. You
 * take some of the values of an existing instance and change some specific ones. Brilliant
 * for immutable objects, and it comes for free with the data class.
 */
val md3 = md1.copy(value = 20.0) // $ 20.0
val md4 = md1.copy(currency = "€") // € 10.0

/**
 * Now, what if we want to use this money in some calculations? What if we want
 * to be able to add money together?
 */
data class CalcMoney(val currency: String = "$", val value: Double) {
    fun plus(that: CalcMoney) = if(this.currency == that.currency) {
        Money(this.currency, this.value + that.value)
    } else {
        throw IllegalArgumentException("Currency doesn't match.")
    }
}

val cm = CalcMoney(value = 10.0)
val addcm = cm.plus(cm) // $ 20.0

/**
* We can do better, by adding the infix keyword. This will allow you to use a more
* 'dsl' type style when defining your functions. This will work for functions with
* one and exactly one parameter only.
*/
data class CalcMoneyInfix(val currency: String = "$", val value: Double) {
    infix fun plus(that: CalcMoneyInfix) = if (this.currency == that.currency) {
        Money(this.currency, this.value + that.value)
    } else {
        throw IllegalArgumentException("Currency doesn't match.")
    }
}

val cmi = CalcMoneyInfix(value = 10.0)
val addcmi = cmi plus cmi // $ 20.0 -> Fancy infix notation

/**
 * What might be even nicer? Implementing the same with operator overloading!
 * We can use the same signature for the method, but use the keyword 'operator' before
 * the function. The following function name must be in a reserved domain:
 * plus() -> x + y, minus() -> x - y, div() -> x / y, times() -> x * y, rangeTo() -> x..y
 * to name a few, there are more in the kotlin docs.
 */
data class CalcMoneyOperator(val currency: String = "$", val value: Double) {
    operator fun plus(that: CalcMoneyOperator) = if (this.currency == that.currency) {
        Money(this.currency, this.value + that.value)
    } else {
        throw IllegalArgumentException("Currency doesn't match.")
    }
}

val cmo = CalcMoneyOperator(value = 10.0)
val addcmo = cmo + cmo // $ 20.0 -> Operator overloaded function. Fancy!