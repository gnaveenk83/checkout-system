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
    val checkout = new CheckoutSystem
    val totalCost = checkout.calculateTotalCost(cart.getItems)
    totalCost shouldEqual 2.05
  }

  it should "return 0 for an empty cart" in {
    val cart = new ShoppingCart
    val checkout = new CheckoutSystem
    val totalCost = checkout.calculateTotalCost(cart.getItems)
    totalCost shouldEqual 0.0
  }

  it should "handle a cart with only apples" in {
    val cart = new ShoppingCart
    cart.addItem(new Apple)
    cart.addItem(new Apple)
    cart.addItem(new Apple)
    val checkout = new CheckoutSystem
    val totalCost = checkout.calculateTotalCost(cart.getItems)
    totalCost shouldEqual 1.80
  }

  it should "handle a cart with only oranges" in {
    val cart = new ShoppingCart
    cart.addItem(new Orange)
    cart.addItem(new Orange)
    cart.addItem(new Orange)
    val checkout = new CheckoutSystem
    val totalCost = checkout.calculateTotalCost(cart.getItems)
    totalCost shouldEqual 0.75
  }

  it should "handle mixed items" in {
    val cart = new ShoppingCart
    cart.addItem(new Apple)
    cart.addItem(new Apple)
    cart.addItem(new Orange)
    cart.addItem(new Apple)
    cart.addItem(new Orange)
    cart.addItem(new Orange)
    val checkout = new CheckoutSystem
    val totalCost = checkout.calculateTotalCost(cart.getItems)
    totalCost shouldEqual 2.55
  }
}
