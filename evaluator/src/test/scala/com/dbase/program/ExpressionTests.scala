package com.dbase.program

import com.dbase.dsl.expression.{Addition, ExprType, Expression, LongLiteral, LongType}
import com.dbase.evaluator.evaluators.ExpressionEvaluator
import org.scalatest.FunSuite

class ExpressionSuite extends FunSuite {

  test("expression addition test") {
    def program(): Expression[LongType] = {
      val expr: Expression[LongType] = Addition[LongType](
        new LongLiteral(1L),
        new LongLiteral(0L)
      )
      expr
    }
    ExpressionEvaluator().evaluate(Some(program))
  }

  test("dividing by 0 should throw a math error") {

  }
}