package com.atlas.kotlin

import kotlin.math.pow

/*
 * Escribe una función que calcule si un número dado es un número de Armstrong
 * (o también llamado narcisista).
 * Si no conoces qué es un número de Armstrong, debes buscar información
 * al respecto.
 */

fun isArmstrong(num: Int): Boolean {
	var result = 0
	val length = num.toString().length
	val newNum = num.toString()
	
	newNum.forEach {
		result += (it.toString().toDouble()).pow(length).toInt()
	}
	return result == num
}

fun main() {
	println(isArmstrong(153))
	println(isArmstrong(154))
}