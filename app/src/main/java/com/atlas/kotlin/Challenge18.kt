package com.atlas.kotlin

/*
 * Crea una función que analice una matriz 3x3 compuesta por "X" y "O" y retorne lo siguiente:
 * - "X" si han ganado las "X"
 * - "O" si han ganado los "O"
 * - "Empate" si ha habido un empate
 * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta.
 *   O si han ganado los 2.
 * Nota: La matriz puede no estar totalmente cubierta.
 * Se podría representar con un vacío "", por ejemplo.
 */
typealias Matrix = Array<Array<String?>>

enum class Winner {
	X, O, EMPATE, NULL
}

fun Matrix.is3x3(): Boolean {
	return this.size == 3 && this[0].size == 3
}

fun result(elem: String?): Winner {
	return when (elem) {
		"X" -> Winner.X
		"O" -> Winner.O
		else -> Winner.NULL
	}
}

fun tateti(matrix: Matrix): Winner {
	var x = 0
	var o = 0
	if (! matrix.is3x3()) return Winner.NULL
	
	matrix.forEach {
		it.forEach { unit ->
			when (unit) {
				"X" -> x ++
				"O" -> o ++
			}
		}
	}
	
	if (x == o) return Winner.EMPATE
	
	// Verify rows
	if (matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2]) { // First row
		return result(matrix[0][0])
	} else if (matrix[1][0] == matrix[1][1] && matrix[1][1] == matrix[1][2]) { // Second row
		return result(matrix[1][0])
	} else if (matrix[2][0] == matrix[2][1] && matrix[2][1] == matrix[2][2]) { // Thirty row
		return result(matrix[2][0])
	}
	
	// Verify columns
	if (matrix[0][0] == matrix[1][0] && matrix[1][0] == matrix[2][0]) { // First row
		return result(matrix[0][0])
	} else if (matrix[0][1] == matrix[1][1] && matrix[1][1] == matrix[2][2]) { // Second row
		return result(matrix[0][1])
	} else if (matrix[0][2] == matrix[1][2] && matrix[1][2] == matrix[2][2]) { // Thirty row
		return result(matrix[0][2])
	}
	
	// Verify diagonals
	if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) { // First Diagonal /
		return result(matrix[0][0])
	} else if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]) { // Second Diagonal \
		return result(matrix[0][2])
	}
	return Winner.NULL
}

fun main() {
	val matrix: Matrix = arrayOf(
		arrayOf("X", "O", "X"),
		arrayOf("O", "X", ""),
		arrayOf("O", "X", "O"),
	)
	
	println(tateti(matrix).name)
}