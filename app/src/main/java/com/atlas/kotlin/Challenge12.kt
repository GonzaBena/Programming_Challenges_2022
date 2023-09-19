package com.atlas.kotlin

/*
 * Escribe una función que reciba un texto y retorne verdadero o
 * falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee
 * de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 */

fun isPalindrome(word: String): Boolean {
	val newWord = word.trim().lowercase().filter { it.isLetterOrDigit() }
	val wordReversed = newWord.reversed()
	return newWord == wordReversed
}

fun main() {
	println(isPalindrome("Ana lleva al oso la avellana."))
	println(isPalindrome("hola manola"))
}