package com.shopping.service

import com.shopping.model.{Apple, Item, Orange}

class CheckoutSystem {
  def calculateTotalCost(items: List[Item]): Double = {
    val appleCount = items.count(_.isInstanceOf[Apple])
    val orangeCount = items.count(_.isInstanceOf[Orange])

    val appleTotal = calculateAppleCost(appleCount)
    val orangeTotal = calculateOrangeCost(orangeCount)

    (BigDecimal(appleTotal) + BigDecimal(orangeTotal)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  private def calculateAppleCost(count: Int): Double = {
    count * 0.60
  }

  private def calculateOrangeCost(count: Int): Double = {
    count * 0.25
  }
}
