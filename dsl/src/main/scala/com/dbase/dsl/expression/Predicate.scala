package com.dbase.dsl.expression

trait Predicate {
  def arity: Short
  def getChild(index: Int): Expression[BoolType]
}

trait EQ[A] extends Predicate {
  def arity: Short = 2
  def apply(a: A, b: A): A
}

trait GT[A] extends Predicate {
  def arity: Short = 2
  def apply(a: A, b: A): A
}

trait GTE[A] extends Predicate {
  def arity: Short = 2
  def apply(a: A, b: A): A
}

trait LT[A] extends Predicate {
  def arity: Short = 2
  def apply(a: A, b: A): A
}

trait LTE[A] extends Predicate {
  def arity: Short = 2
  def apply(a: A, b: A): A
}