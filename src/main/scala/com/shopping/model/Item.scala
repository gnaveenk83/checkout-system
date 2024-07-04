package com.shopping.model

trait Item {
  def name: String
  def price: Double
}

class Apple extends Item {
  val name: String = "Apple"
  val price: Double = 0.60
}

class Orange extends Item {
  val name: String = "Orange"
  val price: Double = 0.25
}
