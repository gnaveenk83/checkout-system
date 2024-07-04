package com.shopping.service

class NoDiscountStrategy extends DiscountStrategy {
  override def calculatePrice(count: Int, price: Double): Double = {
    (BigDecimal(count) * BigDecimal(price)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }
}
