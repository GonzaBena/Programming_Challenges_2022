package com.atlas.kotlin

/*
 * Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
 * - La serie Fibonacci se compone por una sucesión de números en
 *   la que el siguiente siempre es la suma de los dos anteriores.
 *   0, 1, 1, 2, 3, 5, 8, 13...
 */

fun main() {
	var num0: Long = 0
	var num1: Long = 1
	
	(1..50).forEach { _ ->
		println(num0)
		
		val fib = num0 + num1
		num0 = num1
		num1 = fib
	}
}