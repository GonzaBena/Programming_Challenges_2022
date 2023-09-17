package com.atlas.kotlin

/*
 * Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 */

fun isPrime(num: Int): Boolean {
	if (num <= 1) {
		return false
	}
	
	(2..num / 2 + 1).forEach { i ->
		if (num % i == 0) {
			return false
		}
	}
	
	return true
}

fun main() {
	for (i in 1..100) {
		println("$i " + isPrime(i))
	}
}