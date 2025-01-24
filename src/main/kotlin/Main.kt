package es.iesra.prog2425_ahorcado

fun main() {
    val palabras = Palabra.generarPalabras(2, 7, 10)

    palabras.forEach { println(it.palabraOculta) }

}
