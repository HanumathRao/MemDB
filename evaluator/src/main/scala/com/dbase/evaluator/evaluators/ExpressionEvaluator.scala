package com.dbase.evaluator.evaluators

import com.dbase.dsl.expression._
import com.dbase.dsl.record.Record
import com.dbase.evaluator.column.LongArray

class ExpressionEvaluator {
  def evaluate(expr: Option[Expression[_]], r1: Record, r2: Record) : List[ExecutableExpression[_]] = ???

  private def initialize[A, B](expression: Option[Expression[A]]): List[ExecutableExpression[_]] = {
    val expr = expression.get
    val transformedExprs = expr match {
      case expression: LongLiteral =>
        val exprs = List(new Literal[LongArray] {
          override def execute(): LongArray = LongArray(expression.value)
        })
        exprs
      case addExpr: Addition[LongType] => {
        val firstExprs = initialize(addExpr.getChild(0))
        val secondExprs = initialize(addExpr.getChild(1))
        firstExprs ++ secondExprs ++ List(new Add[LongArray] {
          override def execute(): LongArray = execute()
        })
      }
    }
    transformedExprs
  }

  def evaluate[A, B](expr: Option[Expression[A]]) : Expression[A] = {
    val exprsToEvaluate = initialize(expr)

    expr.get
  }
}

object ExpressionEvaluator {
  def apply() : ExpressionEvaluator = new ExpressionEvaluator()
}
