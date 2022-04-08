package org.cscie88c.week4

object FunctionUtils {
  
  // complete the implementation of the higher order functions below
  def applyNtimes(n: Int)(x: Int)(f: Int => Int): Int = {
    //(1 to n) foreach (x => f)
    (1 to n).foldLeft(0)((x, _) => f(x))
  }

  def myPositivePower(x: Int, n: Int): Int = {
    applyNtimes(n)(x)(_ * x)
  }

  def deferredExecutor(name: String)(f: Int => Int): Int => Int = {
    x =>
    println(f"running on deferred executor $name with value $x")
    f(x)
  }
}
