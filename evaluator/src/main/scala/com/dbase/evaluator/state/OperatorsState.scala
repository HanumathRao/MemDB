package com.dbase.evaluator.state

import com.dbase.dsl.expression.Expression

object OperatorsState {
  class JoinState {
    val joinExpr: Option[Expression[_]] = None
  }
}
