package es.iesra.prog2425_ahorcado

class Jugador(intentos: Int,
              private val letrasUsadas: MutableSet<Char>) {

    init {
        require(intentos >= 0) {"El número de intentos debe ser superior a 0."}
    }
    var intentos: Int = intentos
        private set

    fun intentarLetra(letra: Char): Boolean {
        if (letra !in letrasUsadas) {
            letrasUsadas.add(letra)
            return true
        } else {
            println("ERROR: Letra no válida o ya utilizada. Intenta otra vez.\n")
            return false

        }
    }

     fun fallarIntento() {
        intentos -= 1
    }

    fun obtenerLetrasUsadas(): String {
        return letrasUsadas.joinToString(" ")
    }

}