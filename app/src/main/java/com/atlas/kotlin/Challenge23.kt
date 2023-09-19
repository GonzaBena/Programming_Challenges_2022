package com.atlas.kotlin

/*
 * Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra
 * que calcule el mínimo común múltiplo (mcm) de dos números enteros.
 * - No se pueden utilizar operaciones del lenguaje que
 *   lo resuelvan directamente.
 */

fun mcd(firstNumber: Int, secondNumber: Int): Int {
	
	var a = firstNumber
	var b = secondNumber
	
	while (a != 0 && b != 0) {
		val temp = b
		b = a % b
		a = temp
	}
	
	return a + b
}

fun mcm(firstNumber: Int, secondNumber: Int): Int {
	return (firstNumber * secondNumber) / mcd(firstNumber, secondNumber)
}

fun mcdRecursive(firstNumber: Int, secondNumber: Int): Int {
	return if (firstNumber == 0 || secondNumber == 0) (firstNumber + secondNumber)
	else mcdRecursive(secondNumber, firstNumber % secondNumber)
}

fun main() {
	println(mcd(56, 180))
	println(mcdRecursive(56, 180))
	println(mcm(56, 180))
}