package com.atlas.kotlin

import java.io.File

/*
 * Lee el fichero "Challenge21.txt" incluido en el proyecto, calcula su resultado e imprímelo.
 * - El .txt se corresponde con las entradas de una calculadora.
 * - Cada línea tendrá un número o una operación representada por un símbolo (alternando ambos).
 * - Soporta números enteros y decimales.
 * - Soporta las operaciones suma "+", resta "-", multiplicación "*" y división "/".
 * - El resultado se muestra al finalizar la lectura de la última línea (si el .txt es correcto).
 * - Si el formato del .txt no es correcto, se indicará que no se han podido resolver las operaciones.
 */

fun operand(num1: Double, oper: String, num2: Double): Double {
	return when (oper) {
		"+" -> num1 + num2
		"-" -> num1 - num2
		"*" -> num1 * num2
		"/" -> num1 / num2
		else -> throw Error("Operación no soportada.")
	}
}

fun calculate(file: String): Double {
	
	var num2: Double
	var operand = ""
	var result = 0.0
	
	try {
		File(file).forEachLine {
			val char = it.trim()
			if (char.isEmpty()) throw Error("El archivo esta vacio.")
			
			when (char) {
				"+", "-", "*", "/" -> operand = char.trim()
				
				else -> {
					
					if (char.toDouble().isFinite() && operand.isEmpty()) {
						result = char.toDouble()
					} else {
						num2 = char.toDouble()
						result = operand(result, operand, num2)
					}
				}
			}
		}
	} catch (e: Exception) {
		println("El archivo no puso ser leído o no existe.")
	}
	
	return result
}

fun main() {
	println(calculate("app/src/main/java/com/atlas/kotlin/Challenge21.txt"))
}