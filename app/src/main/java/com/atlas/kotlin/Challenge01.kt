package com.atlas.kotlin

/*
 * Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Bool) según
 * sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
 */

fun anagrama(word1: String, word2: String): Boolean {
	if (word1.lowercase() == word2.lowercase()) {
		return false
	}
	return word1.trim().lowercase().toCharArray().sort() == word2.trim().lowercase().toCharArray()
		.sort()
}

fun main() {
	println(anagrama("amor", "roma"))
}