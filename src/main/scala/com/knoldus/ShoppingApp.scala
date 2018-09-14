package com.knoldus

object ShoppingApp extends App {

  val c = Chocolates(1.2)
  val b = Book(1.2)
  val f = Food(1.2)
  val st = new ShoppingStore
  println(s"::::::::: total sales tax ${st.totalSalesTax(List(c, b, f))}")
  println(s"::::::::: gross total ${st.grossAmount(List(c, b, f))}")

}
