package com.shopping.util

import com.shopping.model.Item

class ShoppingCart {
  private var items: List[Item] = List()

  def addItem(item: Item): Unit = {
    items = items :+ item
  }

  def getItems: List[Item] = items
}
