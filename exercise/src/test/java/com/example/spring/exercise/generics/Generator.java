package com.example.spring.exercise.generics;

/**
 * 泛型接口.
 * @param <T>
 */
interface Generator<T> {
  T next();
}
