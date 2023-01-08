package com.dbase.dsl.record


trait Batch[F[_], A] {
  def next(): F[A]
}
