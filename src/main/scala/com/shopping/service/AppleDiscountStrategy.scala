package com.shopping.service

class AppleDiscountStrategy extends DiscountStrategy {
  override def calculatePrice(count: Int, price: Double): Double = {
    val effectiveCount = count / 2 + count % 2
    (BigDecimal(effectiveCount) * BigDecimal(price)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }
}
