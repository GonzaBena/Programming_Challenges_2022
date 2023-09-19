package com.atlas.kotlin

/*
 * Crea una función que evalúe si un/a atleta ha superado correctamente una
 * carrera de obstáculos.
 * - La función recibirá dos parámetros:
 *      - Un array que sólo puede contener String con las palabras
 *        "run" o "jump"
 *      - Un String que represente la pista y sólo puede contener "_" (suelo)
 *        o "|" (valla)
 * - La función imprimirá cómo ha finalizado la carrera:
 *      - Si el/a atleta hace "run" en "_" (suelo) y "jump" en "|" (valla)
 *        será correcto y no variará el símbolo de esa parte de la pista.
 *      - Si hace "jump" en "_" (suelo), se variará la pista por "x".
 *      - Si hace "run" en "|" (valla), se variará la pista por "/".
 * - La función retornará un Boolean que indique si ha superado la carrera.
 * Para ello tiene que realizar la opción correcta en cada tramo de la pista.
 */
fun race(actions: List<String>, way: String): Boolean {
	val length = actions.size
	if (length > way.length)
		return false
	
	for (i in 0 until length)
		when (actions[i]) {
			"run" -> {
				if (way[i] == '_') {
					way.replaceRange(i, i + 1, "_")
				} else {
					return false
				}
			}
			
			"jump" -> {
				if (way[i] == '|') {
					way.replaceRange(i, i + 1, "|")
				} else {
					return false
				}
			}
		}
	return true
}

fun main() {
	val actions = listOf("run", "run", "jump", "run", "jump", "run")
	val correctWay = "__|_|_"
	val incorrectWay = "__|_||"
	println(race(actions, correctWay))
	println(race(actions, incorrectWay))
}