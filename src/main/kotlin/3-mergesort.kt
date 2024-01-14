import java.util.*

/**
 * El algoritmo `mergesort` es un método de ordenación que se basa en un
 * principio muy simple: se ordenan las dos mitades de un vector y, una
 * vez ordenadas, se fusionan tomando cada vez el elemento más pequeño
 * de cada mitad. Este programa implementa dicho algoritmo de ordenación
 * de manera recursiva.
 */

fun main() {
    val scanner = Scanner(System.`in`)

    println("Indica el tamaño de la array:")
    val tamañoArray = scanner.nextInt()
    val vector = IntArray(tamañoArray)
    println("Indica los numeros que componen tu array:")
    for (i in 0 until tamañoArray) {
        vector[i] = scanner.nextInt()
    }
    mergesort(vector, 0, vector.size - 1)
    println(vector.contentToString())
}

/**
 * @author Joel Montalvan i Daniel Reinosa
 *
 * Método recursivo para realizar el `mergesort` en un subconjunto del array.
 *
 * @param array El array que se va a ordenar.
 * @param izquierda Índice de inicio del subconjunto.
 * @param derecha Índice de fin del subconjunto.
 */
fun mergesort(array: IntArray, izquierda: Int, derecha: Int) {
    if (izquierda < derecha) {
        val mitad = (izquierda + derecha) / 2

        mergesort(array, izquierda, mitad)
        mergesort(array, mitad + 1, derecha)

        merge(array, izquierda, mitad, derecha)
    }
}

/**
 * @author Joel Montalvan i Daniel Reinosa
 *
 * Método para fusionar dos mitades ordenadas de un array.
 *
 * @param array El array que se va a fusionar.
 * @param izquierda Índice de inicio de la primera mitad.
 * @param mitad Índice final de la primera mitad y también inicio de la segunda mitad.
 * @param derecha Índice final de la segunda mitad.
 */
fun merge(array: IntArray, izquierda: Int, mitad: Int, derecha: Int) {
    val tamañoIzquierda = mitad - izquierda + 1
    val tamañoDerecha = derecha - mitad

    val arrayIzquierda = IntArray(tamañoIzquierda)
    val arrayDerecha = IntArray(tamañoDerecha)

    for (i in 0 until tamañoIzquierda) {
        arrayIzquierda[i] = array[izquierda + i]
    }
    for (j in 0 until tamañoDerecha) {
        arrayDerecha[j] = array[mitad + 1 + j]
    }

    var i = 0
    var j = 0
    var k = izquierda

    while (i < tamañoIzquierda && j < tamañoDerecha) {
        if (arrayIzquierda[i] <= arrayDerecha[j]) {
            array[k] = arrayIzquierda[i]
            i++
        } else {
            array[k] = arrayDerecha[j]
            j++
        }
        k++
    }

    while (i < tamañoIzquierda) {
        array[k] = arrayIzquierda[i]
        i++
        k++
    }

    while (j < tamañoDerecha) {
        array[k] = arrayDerecha[j]
        j++
        k++
    }
}
