package scala.dev

import scala.collection.mutable.MutableList

class StrangeStack {
  private var stack: MutableList[Int] = MutableList()

  def getStack(): MutableList[Int] = {
    stack
  }

  def push(element: Int): Unit = {
    if (isAllowPush(element)) {
      stack.+=:(element)
    }
  }

  def isAllowPush(element: Int): Boolean = {
    element > 0 && !stack.contains(element)
  }

  def pop(): Unit = {
    stack = stack.tail
  }
}
