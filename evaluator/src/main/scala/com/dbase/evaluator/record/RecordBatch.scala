package com.dbase.evaluator.record

import com.dbase.dsl.record.{Batch, Record}

trait RecordBatch extends Batch[List, Record] {
  override def next(): List[Record]
}
