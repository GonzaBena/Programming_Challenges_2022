package com.atlas.kotlin

/*
 * Quiero contar del 1 al 100 de uno en uno (imprimiendo cada uno).
 * ¿De cuántas maneras eres capaz de hacerlo?
 * Crea el código para cada una de ellas.
 */

fun repetir(num: Int = 1): Int {
	if (num == 100) {
		println("num $num")
		return num
	}
	println("num $num")
	
	return repetir(num + 1)
}

fun main() {
	for (i in 1..100) println(i) // 1
	
	println("\n")
	
	var i = 1
	while (i <= 100) println(i ++) // 2
	
	println("\n")
	
	i = 1
	do {
		println(i ++)
	} while (i <= 100) // 3
	
	println("\n")
	i = 1
	repeat(100) { println(i ++) } // 4
	
	println("\n")
	
	repetir()
}