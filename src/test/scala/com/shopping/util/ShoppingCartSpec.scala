package com.shopping.util

import com.shopping.model.{Apple, Orange}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {
  "A ShoppingCart" should "start empty" in {
    val cart = new ShoppingCart
    cart.getItems shouldBe empty
  }

  it should "add items" in {
    val cart = new ShoppingCart
    cart.addItem(new Apple)
    cart.addItem(new Orange)
    cart.getItems should have size 2
  }
}
