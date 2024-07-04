package com.shopping.service

class OrangeDiscountStrategy extends DiscountStrategy {
  override def calculatePrice(count: Int, price: Double): Double = {
    val effectiveCount = count / 3 * 2 + count % 3
    (BigDecimal(effectiveCount) * BigDecimal(price)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }
}
