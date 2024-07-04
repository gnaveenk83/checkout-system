package com.shopping.service

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DiscountStrategySpec extends AnyFlatSpec with Matchers {

  "NoDiscountStrategy" should "calculate the total price without any discount" in {
    val strategy = new NoDiscountStrategy
    strategy.calculatePrice(3, 0.60) shouldEqual 1.80
  }

  "AppleDiscountStrategy" should "apply buy one get one free offer" in {
    val strategy = new AppleDiscountStrategy
    strategy.calculatePrice(3, 0.60) shouldEqual 1.20
  }

  "OrangeDiscountStrategy" should "apply 3 for 2 offer" in {
    val strategy = new OrangeDiscountStrategy
    strategy.calculatePrice(4, 0.25) shouldEqual 0.75
  }

}
