package lectures.part1_basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if(n <= 1) 1
    else{
      println("Computing factorial of " + n + " I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }

  //println(factorial(10))
  //println(factorial(5000)) -> Stack overflow

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x-1, x * accumulator) // tail recursion = use recursive call as the last expression
    }

    factHelper(n, 1)
  }

  //println(anotherFactorial(5000))

  /*
  1. Concatenate a string n times
  2. IsPrime function tail recursive
  3. Fibonacci function tail recursive
   */

  def stringConcat(s: String, n: Int): String = {
    @tailrec
    def concatHelper(acc: String, s: String, x: Int): String = {
      if (x <= 0) acc
      else concatHelper(acc + s, s, x-1)
    }

    concatHelper("", s, n)
  }

  println(stringConcat("hello", 5))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def primeHelper(t: Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false
      else if (t <= 1) true
      else primeHelper(t-1, n % t != 0)
    }

    primeHelper(n/2, true)
  }

  println(isPrime(11))
  println(isPrime(9))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciHelper(x: Int, y: Int, z: Int): Int = {
      if(x <= 2) z
      else fibonacciHelper(x-1, z, y+z)
    }

    fibonacciHelper(n, 1, 1)
  }

  println(fibonacci(12))
}
