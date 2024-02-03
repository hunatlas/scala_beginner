package lectures.part1_basics

object Expressions extends App {

  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)
  println(1 == x)
  println(!(1 == x))

  var aVariable = 2
  aVariable += 3
  println(aVariable)

  // instructions vs expressions
  /*
  instructions do something
  expressions compute a value
   */

  // if expression
  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3
  println(aConditionValue)
  println(if(aCondition) 5 else 3)

  // loop
  var i = 0
  while(i < 10){
    println(i)
    i += 1
  }
  // while loops are not suggested in Scala, because it is imperative programming
  // code should be written in Scala based on the idea that everything is an expression

  val aWeirdValue = (aVariable = 3) // unit = void
  println(aWeirdValue)
  // side effects are expressions returning unit type
  // for example, println(), while loops, reassigning

  // code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if(z > 2) "hello" else "goodbye"
  }
  // code blocks are expressions
  // the value of the code block is the value of the last expression in the code block
  // values inside a code block cannot be seen outside the code block

  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  println(someOtherValue)
}
