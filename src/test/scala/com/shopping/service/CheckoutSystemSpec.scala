package com.shopping.service

import com.shopping.model.{Apple, Orange}
import com.shopping.util.ShoppingCart
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CheckoutSystemSpec extends AnyFlatSpec with Matchers {

  "CheckoutSystem" should "calculate total cost without offers" in {
    val cart = new ShoppingCart
    cart.addItem(new Apple)
    cart.addItem(new Apple)
    cart.addItem(new Orange)
    cart.addItem(new Apple)
    val checkout = new CheckoutSystem(Seq(new NoDiscountStrategy))
    val totalCost = checkout.calculateTotalCost(cart.getItems)
    totalCost shouldEqual 2.05
  }

  it should "return 0 for an empty cart" in {
    val cart = new ShoppingCart
    val checkout = new CheckoutSystem(Seq(new NoDiscountStrategy))
    val totalCost = checkout.calculateTotalCost(cart.getItems)
    totalCost shouldEqual 0.0
  }

  it should "handle a cart with only apples with discount" in {
    val cart = new ShoppingCart
    cart.addItem(new Apple)
    cart.addItem(new Apple)
    cart.addItem(new Apple)
    val checkout = new CheckoutSystem(Seq(new AppleDiscountStrategy))
    val totalCost = checkout.calculateTotalCost(cart.getItems)
    totalCost shouldEqual 1.20
  }

  it should "handle a cart with only oranges with discount" in {
    val cart = new ShoppingCart
    cart.addItem(new Orange)
    cart.addItem(new Orange)
    cart.addItem(new Orange)
    val checkout = new CheckoutSystem(Seq(new OrangeDiscountStrategy))
    val totalCost = checkout.calculateTotalCost(cart.getItems)
    totalCost shouldEqual 0.50
  }

  it should "handle mixed items with offers" in {
    val cart = new ShoppingCart
    cart.addItem(new Apple)
    cart.addItem(new Apple)
    cart.addItem(new Orange)
    cart.addItem(new Apple)
    cart.addItem(new Orange)
    cart.addItem(new Orange)
    val checkout = new CheckoutSystem(Seq(new AppleDiscountStrategy, new OrangeDiscountStrategy))
    val totalCost = checkout.calculateTotalCost(cart.getItems)
    totalCost shouldEqual 1.70
  }

  it should "apply no discount if no strategies are provided" in {
    val cart = new ShoppingCart
    cart.addItem(new Apple)
    cart.addItem(new Apple)
    cart.addItem(new Orange)
    cart.addItem(new Apple)
    val checkout = new CheckoutSystem(Seq())
    val totalCost = checkout.calculateTotalCost(cart.getItems)
    totalCost shouldEqual 2.05
  }
}
