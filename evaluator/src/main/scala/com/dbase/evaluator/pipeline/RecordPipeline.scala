package com.dbase.evaluator.pipeline

import com.dbase.dsl.operator.Id
import com.dbase.dsl.pipeline.Pipeline
import com.dbase.evaluator.record.RecordBatch

trait RecordPipeline extends Pipeline[Id, RecordBatch] {
  override def next(): Id[RecordBatch]
}