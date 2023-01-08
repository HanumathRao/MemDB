package com.dbase.dsl.expression

import com.dbase.dsl.expression

sealed trait ExprType[A] {
  type t = A;
}
class IntType extends ExprType[Int]
class LongType extends ExprType[Long]
class BoolType extends ExprType[Boolean]
case object FloatType extends ExprType[Float]
case object DoubleType extends ExprType[Double]

trait ExecutionType

sealed trait Expression[A] {
  def arity: Short
  def getChild(ind: Int): Option[Expression[A]]
}

abstract class BiExpression[A](first: Expression[A], second: Expression[A]) extends Expression[A] {
  def arity: Short = 2

  def getChild(ind: Int): Option[Expression[A]] = ind match {
    case 0 => Some(first)
    case 1 => Some(second)
    case _ => None
  }
}

abstract class SingleExpression[A](first: Expression[A]) extends Expression[A] {
  def arity: Short = 1

  def getChild(ind: Int): Option[Expression[A]] = ind match {
    case 0 => Some(first)
    case _ => None
  }
}

class Column[A] extends Expression[A] {
  override def arity: Short = 0
  override def getChild(ind: Int): Option[Expression[A]] = None
}

class IntLiteral(val value: Int) extends Expression[IntType] {
  def arity: Short = 0
  def getChild(ind: Int): Option[Expression[IntType]] = None
}

class LongLiteral(val value: Long) extends Expression[LongType] {
  def arity: Short = 0
  override def getChild(ind: Int): Option[Expression[expression.LongType]] = None
}

case class Addition[A](first:Expression[A], second: Expression[A]) extends BiExpression[A](first, second)

case class Subtraction[A](first: Expression[A], second: Expression[A]) extends BiExpression[A](first, second)

case class Multiplication[A](first: Expression[A], second: Expression[A]) extends BiExpression[A](first, second)

case class Division[A](first: Expression[A], second: Expression[A]) extends BiExpression[A](first, second)


trait ExecutableExpression[A] {
  def execute(): A
}

trait Add[A] extends ExecutableExpression[A] {
  def execute(): A
}

trait Subr[A] extends ExecutableExpression[A] {
  def execute(): A
}

trait Multiply[A] extends ExecutableExpression[A] {
  def execute(): A
}

trait Divide[A] extends ExecutableExpression[A] {
  def execute(): A
}

trait Literal[A] extends ExecutableExpression[A] {
  override def execute(): A
}