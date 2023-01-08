package com.dbase.dsl.convertors

trait ConversionOpts[A, B] {
  def apply(a: A): B
}
