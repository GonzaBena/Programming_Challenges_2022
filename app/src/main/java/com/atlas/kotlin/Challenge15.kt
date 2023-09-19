package com.atlas.kotlin

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit
import kotlin.math.absoluteValue

/*
 * Crea una función que calcule y retorne cuántos días hay entre dos cadenas
 * de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se
 *   lanzará una excepción.
 */

private fun printDaysBetween(firstDate: String, secondDate: String) {
	try {
		println(daysBetween(firstDate, secondDate))
	} catch (e: DaysBetweenError) {
		println("Error en el formato de alguna fecha")
	} catch (e: Exception) {
		println("Error en el parse de alguna fecha")
	}
}

// Una Clase que hereda de Exception, por lo tanto, es una excepción
class DaysBetweenError : Exception()

@SuppressLint("SimpleDateFormat")
private fun daysBetween(firstDate: String, secondDate: String): Int {
	
	// SimpleDateFormat -> Es una clase que nos permite formatear y analizar fechas
	val formatter = SimpleDateFormat("dd/MM/yyyy")
	val firstParsedDate = formatter.parse(firstDate) // parse -> Convierte un String a Date
	val secondParsedDate = formatter.parse(secondDate)
	
	val regex = "^([0-9]){2}/([0-9]){2}/([0-9]){4}$".toRegex() // Expresión regular
	
	if (firstParsedDate != null
		&& secondParsedDate != null
		&& firstDate.contains(regex)
		&& secondDate.contains(regex)
	) {
		
		// convert -> Convierte una cantidad de tiempo de una unidad a otra
		// TimeUnit.DAYS -> Es una enumeración que representa los días
		return TimeUnit.DAYS.convert(
			firstParsedDate.time - secondParsedDate.time,
			TimeUnit.MILLISECONDS
		).toInt().absoluteValue
	}
	throw DaysBetweenError() // Lanzamos una excepción
}

fun main() {
	printDaysBetween("18/05/2022", "29/05/2022")
	printDaysBetween("mouredev", "29/04/2022")
	printDaysBetween("18/5/2022", "29/04/2022")
}