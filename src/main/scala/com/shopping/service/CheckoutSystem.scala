package com.shopping.service

import com.shopping.model.{Apple, Item, Orange}

class CheckoutSystem(discountStrategies: Seq[DiscountStrategy]) {

  private val appleStrategy: DiscountStrategy = CompositeDiscountStrategy(discountStrategies.collect { case ds: AppleDiscountStrategy => ds }: _*)
  private val orangeStrategy: DiscountStrategy = CompositeDiscountStrategy(discountStrategies.collect { case ds: OrangeDiscountStrategy => ds }: _*)

  def calculateTotalCost(items: List[Item]): Double = {
    val (appleCount, orangeCount) = countItems(items)

    val appleTotal = appleStrategy.calculatePrice(appleCount, 0.60)
    val orangeTotal = orangeStrategy.calculatePrice(orangeCount, 0.25)

    (BigDecimal(appleTotal) + BigDecimal(orangeTotal)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  private def countItems(items: List[Item]): (Int, Int) = {
    items.foldLeft((0, 0)) {
      case ((appleCount, orangeCount), item) => item match {
        case _: Apple  => (appleCount + 1, orangeCount)
        case _: Orange => (appleCount, orangeCount + 1)
      }
    }
  }
}
