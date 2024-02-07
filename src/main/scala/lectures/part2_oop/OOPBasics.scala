package lectures.part2_oop

object OOPBasics extends App {

  val person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print
}

// constructor
// class parameters are not fields
class Person(name: String, val age: Int) {
  val x = 2
  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am ${this.name}")

  // multiple constructors
  def this(name: String) = this(name, 0)
}

/*
  Novel and Writer
  Writer: first name, surname, year
    - fullName
  Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy(new year of release) -> new instance of Novel
 */

/*
  Counter class
    - receives an int value
    - currentCount
    - increment/decrement -> new Counter
    - overload increment/decrement with amount parameter -> new Counter
 */

class Writer(firstName: String, lastName: String, birth: Int) {
  def getFullName: String = firstName + " " + lastName
  def getBirth: Int = birth
}

class Novel(title: String, year: Int, author: Writer) {
  def authorAge:Int = year - author.getBirth
  def isWrittenBy(author: Writer): Boolean = this.author == author
  def copy(year: Int): Novel = new Novel(this.title, year, this.author)
}

class Counter(c: Int = 0) {
  def getCount: Int = c
  def increment: Counter = new Counter(c+1) // immutability
  def increment(m: Int): Counter = {
    if(m <= 0) this
    else increment.increment(m-1)
  }
  def decrement: Counter = new Counter(c-1)
  def decrement(m: Int): Counter = {
    if(m <= 0) this
    else decrement.decrement(m-1)
  }

  def print: Unit = println(c)
}