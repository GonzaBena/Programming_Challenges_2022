package com.atlas.kotlin

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

/*
 * Crea una función que sume 2 números y retorne su resultado pasados
 * unos segundos.
 * - Recibirá por parámetros los 2 números a sumar y los segundos que
 *   debe tardar en finalizar su ejecución.
 * - Si el lenguaje lo soporta, deberá retornar el resultado de forma
 *   asíncrona, es decir, sin detener la ejecución del programa principal.
 *   Se podría ejecutar varias veces al mismo tiempo.
 */

@OptIn(DelicateCoroutinesApi::class)
fun sumAsync(a: Int, b: Int, seconds: Int): Deferred<Int> = GlobalScope.async {
	withContext(Dispatchers.IO) {
		Thread.sleep(seconds * 1000L)
	}
	return@async a + b
}

suspend fun main() {
	sumAsync(1, 2, 3).invokeOnCompletion { println("Terminado") }
	println("Despues de la primera suma")
	println(sumAsync(1, 2, 5).await())
}