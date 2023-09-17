@file:Suppress("NAME_SHADOWING")

package com.atlas.kotlin

/*
 * Crea un programa que cuente cuantas veces se repite cada palabra
 * y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que
 *   lo resuelvan automáticamente.
 */

fun countWords(words: String): Map<String, Int> {
	val wordsCounted = mutableMapOf<String, Int>()
	val words = words.split(" ")
	
	words.forEach { word ->
		val keyWord = wordsCounted.containsKey(word)
		if (keyWord) {
			wordsCounted[word] = wordsCounted[word] !! + 1
		} else {
			wordsCounted[word] = 1
		}
	}
	return wordsCounted
}

fun main() {
	println(countWords("hola mundo hola"))
}