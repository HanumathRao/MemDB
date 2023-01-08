package com.dbase.dsl.expression

trait ExpressionEvaluator {
  def evaluate[A](expr: Expression[A]): A
}
