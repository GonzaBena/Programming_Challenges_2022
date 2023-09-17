package com.atlas.kotlin

/*
 * Crea un programa que invierta el orden de una cadena de texto
 * sin usar funciones propias del lenguaje que lo hagan de forma automática.
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 */

fun reverse(word: String): String {
	var newWord = ""
	for (i in 0..word.length - 1) {
		newWord += word[word.length - 1 - i]
	}
	println(word.length)
	println(word.count())
	return newWord
}

fun main() {
	println(reverse("hola mundo"))
}