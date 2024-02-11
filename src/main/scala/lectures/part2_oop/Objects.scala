package lectures.part2_oop

object Objects {

    // Scala does not have class-level functionality (static)
    object Person { // type + only instance
      // "static"/"class" level functionality
      val N_EYES = 2
      def canFly: Boolean = false

      // factory method
      def apply(mother: Person, father: Person): Person = new Person("Bobbie")
    }

    class Person(val name: String) {
      // instance level functionality
    }
    // companions

    def main(args: Array[String]): Unit = {
      println(Person.N_EYES)
      println(Person.canFly)

      // Scala object = singleton instance
      val mary = new Person("Mary")
      val john = new Person("John")
      println(mary == john)

      val person1 = Person
      val person2 = Person
      println(person1 == person2)

      val bobbie = Person(mary, john)
    }

    // Scala applications = Scala object with
    // def main(args: Array[String]): Unit
    // or use extends App
}
