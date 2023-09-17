package com.atlas.kotlin

import android.graphics.BitmapFactory
import java.net.URL
import kotlin.math.roundToInt

/*
 * Crea un programa que se encargue de calcular el aspect ratio de una imagen a partir de una url.
 * - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
 * - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.
 */

class Challenge05 {
	
	fun aspectRatio(url: String) {
		
		Thread {
			val aspectRationStr: String?
			
			val newUrl = URL(url)
			val bitmap = BitmapFactory.decodeStream(newUrl.openStream())
			
			val height = bitmap.height
			val width = bitmap.width
			val aspectRatio = rationalAspectRatio(height.toDouble() / width.toDouble())
			aspectRationStr = "${aspectRatio.second}:${aspectRatio.first}"
			
			println("El aspect ratio es $aspectRationStr")
		}.start()
	}
	
	data class Quadruple(val h1: Int, val k1: Int, val h: Int, val k: Int)
	
	private fun rationalAspectRatio(aspectRatio: Double): Pair<Int, Int> {
		val precision = 1.0E-6
		var x = aspectRatio
		var a = x.roundToInt()
		var q = Quadruple(1, 0, a, 1)
		
		while (x - a > precision * q.k.toDouble() * q.k.toDouble()) {
			x = 1.0 / (x - a)
			a = x.roundToInt()
			q = Quadruple(q.h, q.k, q.h1 + a * q.h, q.k1 + a * q.k)
		}
		return Pair(q.h, q.k)
	}
	
}
