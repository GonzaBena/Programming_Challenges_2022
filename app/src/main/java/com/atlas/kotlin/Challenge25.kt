package com.atlas.kotlin

/*
 * Crea un programa que calcule quien gana más partidas al piedra, papel, tijera.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La función recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "R" (piedra), "P" (papel) o "S" (tijera).
 * - Ejemplo. Entrada: [("R","S"), ("S","R"), ("P","S")]. Resultado: "Player 2".
 */
enum class Types {
  PIEDRA {
    fun isWinner(oponent: Types): Boolean {
      if (oponent == PAPEL) {
        return true
      }
      return false
    }
  },
  PAPEL {
    fun isWinner(oponent: Types): Boolean {
      if (oponent == PIEDRA) {
        return true
      }
      return false
    }
  },
  TIJERA {
    fun isWinner(oponent: Types): Boolean {
      if (oponent == PIEDRA) {
        return true
      }
      return false
    }
  };
}

enum class Result {
  PLAYER_1,
  PLAYER_2, TIE
}
typealias Element = Pair<String, String>

fun Game(operations: Array<Element>): Result {
  
  var player1 = 0
  var player2 = 0
  
  operations.forEach {
    val player1Type = Types.valueOf(it.first.uppercase())
    val player2Type = Types.valueOf(it.second.uppercase())
    
    Types.valueOf(it.first)
    
    if (player1Type.isWinner(player2Type)) {
      player1++
    } else if (player2Type.isWinner(player1Type)) {
      player2++
    }
  }
  
  return Result.TIE
  
}

fun main() {

}