package com.atlas.kotlin

/*
 * Crea un programa se encargue de transformar un número
 * decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 */

fun decimalToBinary(num: Int): Int {
	var binaryNum = ""
	var divisor = num
	if (num == 1) {
		return 1
	}
	
	while (divisor != 0) {
		val reminder = divisor % 2
		divisor /= 2
		binaryNum = reminder.toString() + binaryNum
	}
	
	
	return if (binaryNum.isEmpty()) 0 else binaryNum.toInt()
}

fun main() {
	println(decimalToBinary(10))
}