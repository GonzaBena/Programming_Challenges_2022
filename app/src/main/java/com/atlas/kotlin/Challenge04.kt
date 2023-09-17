package com.atlas.kotlin

import kotlin.math.pow

/*
 * Crea una única función (importante que sólo sea una) que sea capaz
 * de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 */

interface Polygon {
	fun area(): Double
	fun printArea()
}

class Triangle(val base: Double, val height: Double) : Polygon {
	override fun area(): Double {
		return base * height / 2
	}
	
	override fun printArea() {
		println("El area de un triangulo es: ${area()}")
	}
}

class Square(val size: Double) : Polygon {
	override fun area(): Double {
		return size.pow(2)
	}
	
	override fun printArea() {
		println("El area de un cuadrado es: ${area()}")
	}
}

class Rectangle(val base: Double, val height: Double) : Polygon {
	override fun area(): Double {
		return base * height
	}
	
	override fun printArea() {
		println("El area de un rectangulo es: ${area()}")
	}
}

fun area(polygon: Polygon): Double {
	polygon.printArea()
	return polygon.area()
}

fun main() {
	area(Triangle(10.0, 10.0))
	area(Rectangle(10.0, 10.0))
	area(Square(10.0))
}
