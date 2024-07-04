package com.shopping.model

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ItemSpec extends AnyFlatSpec with Matchers {
  "An Apple" should "have a name and price" in {
    val apple = new Apple
    apple.name shouldEqual "Apple"
    apple.price shouldEqual 0.60
  }

  "An Orange" should "have a name and price" in {
    val orange = new Orange
    orange.name shouldEqual "Orange"
    orange.price shouldEqual 0.25
  }
}
