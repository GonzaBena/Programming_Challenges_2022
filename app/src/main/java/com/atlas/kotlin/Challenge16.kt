package com.atlas.kotlin

/*
 * Crea una función que reciba un String de cualquier tipo y se encargue de
 * poner en mayúscula la primera letra de cada palabra.
 * - No se pueden utilizar operaciones del lenguaje que
 *   lo resuelvan directamente.
 */

fun capitalize(words: String): String {
	return words.split(" ").joinToString(" ") { word ->
		word.replaceFirst(word[0], word[0].uppercaseChar())
	}
}

fun main() {
	println(capitalize("hola mundo desde kotlin"))
}