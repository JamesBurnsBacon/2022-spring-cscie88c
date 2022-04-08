package org.cscie88c.week6

// Write a generic trait AddableTypeclass parameterized by type A 
trait AddableTypeclass[A] {
  def addTwoValues(a: A, b: A): A
}

object AddableTypeclass {
  implicit val intAddableTypeclass: AddableTypeclass[Int] = new AddableTypeclass[Int] {
    def addTwoValues(a: Int, b: Int): Int = a + b
  }
  //https://www.baeldung.com/scala/type-classes
  implicit val boolAddableTypeclass: AddableTypeclass[Boolean] = new AddableTypeclass[Boolean] {
    def addTwoValues(a: Boolean, b: Boolean): Boolean = a || b
  }
}

object AddableAggregator {
  def sumWithAddable[A](list: List[A])(implicit addable: AddableTypeclass[A]): A = {
    //I look forward to seeing other solutions to this :)
    def add(a: A, b: A) = addable.addTwoValues(a,b)
    list.length match {
      case 1 => list(0)
      case 2 => add(list(0), list(1))
      case 3 => add(list(0), add(list(1), list(2)))
      case 4 => add(add(list(0), list(1)),add(list(2), list(3)))
    }
  }
//https://alvinalexander.com/scala/how-to-use-scala-match-expression-like-switch-case-statement/
}

//Bonus 1 // Type classes help to reduce the overall code required to meet functional requirements, but when they are stacked repeatedly, I find the code less readily readable.
