package com.dbase.evaluator

import com.dbase.dsl.convertors.ConversionOpts
import com.dbase.dsl.expression.LongType
import com.dbase.evaluator.column.LongArray

package object evaluators {
  implicit val longType_to_longArray = new ConversionOpts[LongType , LongArray] {
    override def apply(a: LongType): LongArray = ???
  }
}