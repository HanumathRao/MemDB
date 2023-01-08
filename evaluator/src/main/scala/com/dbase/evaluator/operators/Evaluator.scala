package com.dbase.evaluator.operators

import com.dbase.dsl.expression.Expression
import com.dbase.dsl.operator.Id
import com.dbase.evaluator.evaluators.ExpressionEvaluator
import com.dbase.evaluator.pipeline.RecordPipeline
import com.dbase.evaluator.state.OperatorsState.JoinState
import com.hanu.operators.Join

object NestedLoopJoin extends Join[Id, RecordPipeline] {
  override def join(joinExpression: Expression[_], r1: Id[RecordPipeline], r2: Id[RecordPipeline]): Id[RecordPipeline] = {
    val r1Batch = r1.next()
    r1Batch.next().foreach(r1Record => {
      val r2Batch = r2.next()
      r2Batch.next.foreach(r2Record => new ExpressionEvaluator().evaluate(Some(joinExpression), r1Record, r2Record))
    })
    r1
  }
}
