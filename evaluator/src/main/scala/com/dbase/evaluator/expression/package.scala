package com.dbase.evaluator

import com.dbase.dsl.expression
import com.dbase.dsl.expression.{Expression, LongType}
import com.dbase.evaluator.column.LongArray

package object expression {

//  implicit val add_long_array = new Expression[LongType] {
//    override def apply(first: expression.LongType, second: LongType): LongType = {
//      val builder = LongArray.builder(first.size)
//      for (i <- 0 until first.size) {
//        builder.addColValue(first.values(i) + second.values(i))
//      }
//      builder.build()
//    }
//
//    override def getChild(ind: Int): Option[Expression] = ???
//  }
//
//  implicit val subr_long_array = new Subr[LongArray] {
//    override def apply(first: LongArray, second: LongArray): LongArray = {
//      val builder = LongArray.builder(first.size)
//      for (i <- 0 until first.size) {
//        builder.addColValue(first.values(i) - second.values(i))
//      }
//      builder.build()
//    }
//  }
//
//  implicit val multiply_long_array = new Multiply[LongArray] {
//    override def apply(first: LongArray, second: LongArray): LongArray = {
//      val builder = LongArray.builder(first.size)
//      for (i <- 0 until first.size) {
//        builder.addColValue(first.values(i) * second.values(i))
//      }
//      builder.build()
//    }
//  }
//
//  implicit val divide_long_array = new Divide[LongArray] {
//    override def apply(first: LongArray, second: LongArray): LongArray = {
//      val builder = LongArray.builder(first.size)
//      for (i <- 0 until first.size) {
//        builder.addColValue(first.values(i) / second.values(i))
//      }
//      builder.build()
//    }
//  }
//
//  implicit val literal_long_array = new Literal[LongArray, Long] {
//    override def apply(v: Long): LongArray = {
//      val builder = LongArray.builder(1)
//      builder.addColValue(v)
//      builder.build()
//    }
//  }
}
