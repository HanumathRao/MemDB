package com.dbase.evaluator.column

import com.dbase.dsl.expression.ExecutionType


class LongArray(val values: Array[Long]) extends ExecutionType

object LongArray {
  def apply(value: Long) : LongArray = {
    val values = new Array[Long](1)
    values(0) = value
    new LongArray(values)
  }

  class LongArrayBuilder(val size: Int) {

    private lazy val elems: Array[Long] = new Array[Long](size)
    private var index = 0

    def addColValue(value: Long): Unit = {
      elems(index) = value
      index = index + 1
    }

    def build(): LongArray = {
      new LongArray(elems)
    }
  }

  def builder(size: Int): LongArrayBuilder = {
    new LongArrayBuilder(size)
  }
}


class IntArray(val values: Array[Int]) extends ExecutionType

object IntArray {
  def apply(value: Long): LongArray = {
    val values = new Array[Long](1)
    values(0) = value
    new LongArray(values)
  }

  class IntArrayBuilder(val size: Int) {

    private lazy val elems: Array[Int] = new Array[Int](size)
    private var index = 0

    def addColValue(value: Int): Unit = {
      elems(index) = value
      index = index + 1
    }

    def build(): IntArray = {
      new IntArray(elems)
    }
  }
}

