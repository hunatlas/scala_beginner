package lectures.part2_oop

import scala.annotation.targetName
import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(this.name + " (" + nickname + ")", this.favoriteMovie)
    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)
    def isAlive: Boolean = true
    def learns(subject: String): String = s"${this.name} learns $subject."
    def learnsScala: String = this learns "Scala"
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie."
    def apply(occasion: Int): String = s"${this.name} watched ${this.favoriteMovie} $occasion times."
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // infix notation, operator notation (syntactic sugar)
  // works only with methods that have one parameter

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println( 1 + 3)
  println(1.+(2)) // all operators are methods

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only work with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())

  /*
    1. Overload the + operator
       mary + "the rockstar" => new person "Mary (the rockstar)"
    2. Add an age to the Person class (default zero)
       Add a unary + operator => new person with the age + 1
       +mary => mary with the age incrementer
    3. Add a "learns" method to the Person class => "Mary learns Scala"
       Add a learnsScala method, calls learns method with "Scala"
       Use it in postfix notation
    4. Overload the apply method
       mar.apply(2) => "Mary watched Inception 2 times"
   */

  val maryRockstar = mary + "the rockstar"
  println(maryRockstar.name)

  val olderMary = +mary
  println(olderMary.age)

  println(mary learns "Python")
  println(mary learnsScala)

  println(mary(2))
}
