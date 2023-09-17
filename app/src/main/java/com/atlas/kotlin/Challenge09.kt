package com.atlas.kotlin

/*
 * Crea un programa que sea capaz de transformar texto natural a código morse y viceversa.
 * - Debe detectar automáticamente de qué tipo se trata y realizar la conversión.
 * - En morse se soporta raya,"—", punto,".", un espacio,"," entre letras o símbolos y dos espacios
 *    entre palabras," ,".
 * - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Codigo_morse.
 */

val morse = mapOf(
	"A" to "·—", "N" to "—·", "0" to "—————",
	"B" to "—···", "Ñ" to "——·——", "1" to "·————",
	"C" to "—·—·", "O" to "———", "2" to "··———",
	"CH" to "————", "P" to "·——·", "3" to "···——",
	"D" to "—··", "Q" to "——·—", "4" to "····—",
	"E" to "·", "R" to "·—·", "5" to "·····",
	"F" to "··—·", "S" to "···", "6" to "—····",
	"G" to "——·", "T" to "—", "7" to "——···",
	"H" to "····", "U" to "··—", "8" to "———··",
	"I" to "··", "V" to "···—", "9" to "————·",
	"J" to "·———", "W" to "·——", "." to "·—·—·—",
	"K" to "—·—", "X" to "—··—", "," to "——··——",
	"L" to "·—··", "Y" to "—·——", "?" to "··——··",
	"M" to "——", "Z" to "——··", "\"" to "·—··—·",
	"/" to "—··—·", " " to " "
)

fun textToMorse(code: String): String {
	var translate = ""
	
	val letters = code.trim()
		.uppercase()
		.filter { char -> char.isLetterOrDigit() }
	
	for (i in letters) {
		translate += morse[i.toString()] + " "
	}
	return translate.trim().ifEmpty { "Vacio" }
}

fun morseToText(code: String): String {
	var translate = ""
	val morseCode = mutableMapOf<String, String>()
	
	morse.forEach { char ->
		morseCode[char.value] = char.key
	}
	
	val newCode = code.trim().filter { char -> ! char.isLetterOrDigit() }.split(" ")
	
	for (i in newCode) {
		translate += morseCode[i]
	}
	
	return translate.trim().ifEmpty { "Vacio" }
}

fun morseConverter(code: String): String {
	val morse = code.all { char -> ! char.isLetterOrDigit() }
	if (morse) {
		return morseToText(code)
	}
	return textToMorse(code)
}

fun main() {
	println(morseConverter("hola mundo"))
	println(morseConverter("···· ——— ·—·· ·— —— ··— —· —·· ———"))
}
