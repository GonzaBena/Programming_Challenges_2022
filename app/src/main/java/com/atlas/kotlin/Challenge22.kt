package com.atlas.kotlin

/*
 * Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 */

fun <T> commonAndUncommonElements(elems1: List<T>, elems2: List<T>, commons: Boolean): List<T> {
	val result: MutableMap<T, Int>
	
	val commonsElems1 = mutableMapOf<T, Int>()
	val commonsElems2 = mutableMapOf<T, Int>()
	
	elems1.forEach {
		if (commonsElems1.containsKey(it)) commonsElems1[it] = commonsElems1[it] !! + 1
		else commonsElems1[it] = 1
	}
	
	elems2.forEach {
		if (commonsElems2.containsKey(it)) commonsElems2[it] = commonsElems2[it] !! + 1
		else commonsElems2[it] = 1
	}
	
	result = (commonsElems2 + commonsElems1) as MutableMap<T, Int>
	
	
	return if (commons) result.filter { it.value > 1 }.map { it.key }.sortedBy { it.toString() }
	else result.filter { it.value == 1 }.map { it.key }.sortedBy { it.toString() }
	
	
}

fun main() {
	println(commonAndUncommonElements(listOf(1, 2, 3, 3, 4), listOf(2, 2, 3, 3, 3, 4, 6), true))
	println(commonAndUncommonElements(listOf(1, 2, 3, 3, 4), listOf(2, 2, 3, 3, 3, 4, 6), false))
	println(commonAndUncommonElements(listOf("a", "a", "b", "c", "d"), listOf("a", "a", "d"), false))
}

