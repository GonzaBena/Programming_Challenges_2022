package com.atlas.kotlin

/*
 * Escribe un programa que muestre por consola (con un print) los números de 1 a 100 (ambos
 * incluidos y con un salto de línea entre cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
 */

fun main() {
	for (i in 1..100) {
		val multiploDeTres = i % 3 == 0
		val multiploDeCinco = i % 5 == 0
		
		if (multiploDeTres && multiploDeCinco) {
			println("fizzbuzz")
		} else if (multiploDeTres) {
			println("fizz")
		} else if (multiploDeCinco) {
			println("buzz")
		} else {
			println(i)
		}
	}
}

