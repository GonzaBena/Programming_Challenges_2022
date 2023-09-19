package com.atlas.kotlin

import java.util.concurrent.TimeUnit

/*
 * Crea una función que reciba días, horas, minutos y segundos (como enteros)
 * y retorne su resultado en milisegundos.
 */

fun toMiliseconds(days: Int = 0, hours: Int = 0, minutes: Int = 0, seconds: Int = 0): Long {
	return TimeUnit.DAYS.toMillis(days.toLong()) +
					TimeUnit.HOURS.toMillis(hours.toLong()) +
					TimeUnit.MINUTES.toMillis(minutes.toLong()) +
					TimeUnit.SECONDS.toMillis(seconds.toLong())
}

fun main() {
	println(toMiliseconds(1, 1, 1, 1))
	println(toMiliseconds(days = 1))
	println(toMiliseconds(hours = 1))
	println(toMiliseconds(minutes = 1))
	println(toMiliseconds(seconds = 1))
}