package com.atlas.kotlin

/*
 * Escribe una función que calcule y retorne el factorial de un número dado
 * de forma recursiva.
 */

fun factorial(num: Int): Long {
	if (num <= 1) return 1
	
	return num * factorial(num - 1)
}

fun main() {
	println(factorial(5))
	println(factorial(1))
	println(factorial(0))
}