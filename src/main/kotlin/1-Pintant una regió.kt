import java.util.*

/**
 * Programa principal que permet a l'usuari especificar una cel·la inicial i un color,
 * i després pinta una regió en un tauler quadrat de 5x5.
 */
fun main() {
    val scanner = Scanner(System.`in`)

    val tauler = arrayOf(
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 1, 1, 1, 0),
        arrayOf(0, 1, 0, 1, 0),
        arrayOf(0, 1, 1, 1, 0),
        arrayOf(0, 0, 0, 0, 0)
    )

    print("Introdueix la fila de la cel·la inicial: ")
    val fila = scanner.nextInt()
    print("Introdueix la columna de la cel·la inicial: ")
    val columna = scanner.nextInt()

    print("Introdueix el color de la regió: ")
    val color = scanner.nextInt()

    pintarRegió(tauler, fila, columna, color)

    for (fila in tauler.indices) {
        for (columna in tauler[0].indices) {
            print(tauler[fila][columna])
        }
        println()
    }
}

/**
 * @author Joel Montalvan i Daniel Reinosa
 *
 * Funció recursiva que pinta una regió al tauler.
 *
 * @param tauler Tauler representat com una matriu bidimensional.
 * @param fila Fila de la cel·la actual al tauler.
 * @param columna Columna de la cel·la actual al tauler.
 * @param color Nou color amb el qual es vol pintar la regió.
 */
fun pintarRegió(tauler: Array<Array<Int>>, fila: Int, columna: Int, color: Int): Unit {
    if (fila < 0 || fila >= tauler.size || columna < 0 || columna >= tauler[0].size) {
        return
    }
    if (tauler[fila][columna] != color) {
        return
    }

    tauler[fila][columna] = color

    pintarRegió(tauler, fila - 1, columna, color)
    pintarRegió(tauler, fila + 1, columna, color)
    pintarRegió(tauler, fila, columna - 1, color)
    pintarRegió(tauler, fila, columna + 1, color)
}
