package com.atlas.kotlin

/*
 * Crea un programa que comprueba si los paréntesis, llaves y corchetes
 * de una expresión están equilibrados.
 * - Equilibrado significa que estos delimitadores se abren y cieran
 *   en orden y de forma correcta.
 * - Paréntesis, llaves y corchetes son igual de prioritarios.
 *   No hay uno más importante que otro.
 * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
 * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
 */

fun isBalanced(expression: String): Boolean {
	val stack = mutableListOf<String>()
	for (i in expression.replace(" ", "")) {
		when (i.toString()) {
			"(", "{", "[" -> stack.add(i.toString())
			")" -> if (stack.removeLast() != "(") return false
			"]" -> if (stack.removeLast() != "[") return false
			"}" -> if (stack.removeLast() != "{") return false
			
		}
	}
	return true
}

fun main() {
	println("{ [ a * ( c + d ) ] - 5 }, ${isBalanced("{ [ a * ( c + d ) ] - 5 }")}")
	println("{ a * ( c + d ) ] - 5 }, ${isBalanced("{ a * ( c + d ) ] - 5 }")}")
}