package com.shopping.service

import scala.language.postfixOps

class CompositeDiscountStrategy(strategies: Seq[DiscountStrategy]) extends DiscountStrategy {
  override def calculatePrice(count: Int, price: Double): Double = {
    strategies.foldLeft(BigDecimal(count) * BigDecimal(price)) { (total, strategy) =>
      BigDecimal(strategy.calculatePrice(count, price))
    }.setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }
}

object CompositeDiscountStrategy {
  def apply(strategies: DiscountStrategy*): DiscountStrategy = {
    if (strategies.isEmpty) new NoDiscountStrategy
    else new CompositeDiscountStrategy(strategies)
  }
}
