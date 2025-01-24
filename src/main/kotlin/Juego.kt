package es.iesra.prog2425_ahorcado

class Juego(val palabra: Palabra, val jugador: Jugador) {

    fun iniciar() {

    }

    fun preguntar() {
        println("¡Bienvenido al juego del Ahorcado!\n" +
                "La palabra tiene ${palabra.palabraOculta.length} letras.")
        do {
            println("Palabra: ${palabra.progreso}\n" +
                    "Intentos restantes: ${jugador.intentos}\n" +
                    "Letras usadas: ${jugador.obtenerLetrasUsadas()}\n" +
                    "Introduce una letra: ")

            var letra: Char? = ' '
            var letraCorrecta = false
            while (!letraCorrecta) {
                letra = readln().lowercase().firstOrNull()
                if (letra != null && !jugador.intentarLetra(letra)) {
                    letraCorrecta = true
                } else println("ERROR: Letra no válida o ya utilizada. Intenta otra vez.\n")
            }

            if (palabra.revelarLetra(letra)) {
                print("¡Bien hecho! La letra '$letra' está en la palabra.")
            } else {
                println("La letra '$letra' no está en la palabra.")
                jugador.fallarIntento()
            }
        } while ((jugador.intentos > 0) && !palabra.esCompleta())

        if (palabra.esCompleta()) {
            println("\n¡Felicidades! Has adivinado la palabra: ${palabra.obtenerProgreso()}")
        } else {
            println("\nLo siento, te has quedado sin intentos. La palabra era: ${palabra.palabraOculta}")
        }
    }
}