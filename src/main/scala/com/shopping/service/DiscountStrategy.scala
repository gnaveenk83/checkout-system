package com.shopping.service

trait DiscountStrategy {
  def calculatePrice(count: Int, price: Double): Double
}
