package lectures.part1_basics

object DefaultArgs extends App {

  def tailRecFactorial(n: Int, acc: Int = 1): Int = {
    if(n<=1) acc
    else tailRecFactorial(n-1, n*acc)
  }

  val fact10 = tailRecFactorial(10)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture")
  savePicture(width = 800)

  /*
  1. pass in every leading argument
  2. name the arguments
   */

  savePicture(height = 600, width = 800, format = "bmp")
}
