package com.atlas.kotlin

/*
 * Crea una función que reciba dos cadenas como parámetro (str1, str2)
 * e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO
 *   estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO
 *   estén presentes en str1.
 */

fun ausentLetters(str1: String, str2: String) {
	var out1 = ""
	var out2 = ""
	
	for (i in str1) {
		if (! str2.contains(i)) {
			out1 += i
		}
	}
	
	for (i in str2) {
		if (! str1.contains(i)) {
			out2 += i
		}
	}
	
	println("Out1: $out1")
	println("Out2: $out2")
}

fun main() {
	ausentLetters("hola", "chau")
}