package com.dbase.dsl.pipeline

trait Pipeline[F[_], A] {
  def next(): F[A]
}