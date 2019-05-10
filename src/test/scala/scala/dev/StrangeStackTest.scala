package scala.dev

import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers}

class StrangeStackTest extends FunSuite with Matchers with BeforeAndAfterEach {
  private var stack = new StrangeStack()

  override def beforeEach(): Unit = {
    stack = new StrangeStack()
  }

  test("push will add element into the stack") {
    stack.push(1)

    stack.getStack() shouldEqual List(1)
  }

  test("push will prepend element into the stack") {
    stack.push(1)
    stack.push(2)

    stack.getStack() shouldEqual List(2, 1)
  }

  test("push will not add element if it's less than or equal to 0") {
    stack.push(1)
    stack.push(0)
    stack.push(-1)

    stack.getStack() shouldEqual List(1)
  }

  test("push will not add element if it exists in the stack") {
    stack.push(1)
    stack.push(0)
    stack.push(1)

    stack.getStack() shouldEqual List(1)
  }

  test("isAllowPush will return true if element is greater than 0") {
    stack.isAllowPush(1) shouldEqual true
  }

  test("isAllowPush will return false if element is less than or equal to 0") {
    stack.isAllowPush(0) shouldEqual false
    stack.isAllowPush(-1) shouldEqual false
  }

  test("isAllowPush will return false if element exists in the stack") {
    stack.push(1)

    stack.isAllowPush(1) shouldEqual false
    stack.isAllowPush(2) shouldEqual true
  }

  test("pop will remove the first element of the stack") {
    stack.push(1)
    stack.push(2)
    stack.pop()

    stack.getStack() shouldEqual List(1)
  }
}
