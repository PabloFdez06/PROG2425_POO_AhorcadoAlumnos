package es.iesra.prog2425_ahorcado

class Juego(val palabra: Palabra, val jugador: Jugador) {

    fun iniciar() {
        println("¡Bienvenido al juego del Ahorcado!\n" +
                "La palabra tiene ${palabra.palabraOculta.length} letras.")
        do {
            println(palabra.palabraOculta)
            println("\nPalabra: ${palabra.obtenerProgreso()}\n" +
                    "Intentos restantes: ${jugador.intentos}\n" +
                    "Letras usadas: ${jugador.obtenerLetrasUsadas()}\n" +
                    "Introduce una letra: ")

            var letra: Char? = ' '
            var letraCorrecta = false
            while (!letraCorrecta) {
                letra = readln().lowercase().firstOrNull()
                if (letra != null && jugador.intentarLetra(letra)) {
                    letraCorrecta = true
                } else println("ERROR: Letra no válida o ya utilizada. Intenta otra vez.\n")
            }

            if (palabra.revelarLetra(letra)) {
                print("¡Bien hecho! La letra '$letra' está en la palabra.")
            } else {
                jugador.fallarIntento()
                println("La letra '$letra' no está en la palabra.")
            }
        } while ((jugador.intentos > 0) && !palabra.esCompleta())

        if (palabra.esCompleta()) {
            println("\n¡Felicidades! Has adivinado la palabra: ${palabra.palabraOculta}")
        } else {
            println("\nLo siento, te has quedado sin intentos. La palabra era: ${palabra.palabraOculta}")
        }
    }

    fun preguntar(msj: String): Boolean {
        do {
            print("$msj (s/n): ")
            val respuesta = readln().trim().lowercase()
            when (respuesta) {
                "s" -> return true
                "n" -> return false
                else -> println("Respuesta no válida! Inténtelo de nuevo...")
            }
        } while (true)
    }
}