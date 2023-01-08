package com.hanu.operators

import com.dbase.dsl.expression.Expression


trait Scan[F[_], A] {
  def scan(): F[A]
}

trait Join[F[_], A] {
  def join(expression: Expression[_], r1 : F[A], r2: F[A]): F[A]
}

trait Aggregation[F[_], A] {
  def agg(r: F[A]): F[A]
}

trait Projection[F[_], A] {
  def proj(expressions: List[Expression[_]], r: F[A]): F[A]
}

trait Filter[F[_], A] {
  def filter(expression: Expression[_], r: F[A]): F[A]
}
