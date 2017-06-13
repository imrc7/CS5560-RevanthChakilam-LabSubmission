package demo

import org.scalatest.FunSuite

/**
  * Created by revan on 6/13/2017.
  */
class HelloTest extends FunSuite {

  test("sayHello method created successfully ! Hurray")
  {
      val hello= new Hello
    assert(hello.sayHello("Scala")=="Hello, Scala! ")
  }

}
