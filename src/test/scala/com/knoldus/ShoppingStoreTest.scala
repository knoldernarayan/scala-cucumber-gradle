package com.knoldus

import org.scalatest.FunSuite

class ShoppingStoreTest extends FunSuite {

  val shoppingStore = new ShoppingStore
  val items = List(Food(23.5), Book(23), Chocolates(45.23))

  test("Get total sales tax "){
    val result = shoppingStore.totalSalesTax(items).toInt
    assert(result == 7)

  }

  test("Get total gross amount "){
    val result = shoppingStore.grossAmount(items).toInt
    assert(result == 101)

  }
}
