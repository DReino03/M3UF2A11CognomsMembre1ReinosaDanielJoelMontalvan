import java.util.*

/**
 * Funció principal
 */
fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    println(laboratoriDeRatolins(n))
}

/**
 * Funció que calcula el nombre de parelles de ratolins que hi ha al cap de n mesos
 * @param n Nombre de mesos
 * @return Nombre de parelles de ratolins
 */
fun laboratoriDeRatolins(n: Int): Int{
    if(n == 1 || n == 2)
        return n
    return laboratoriDeRatolins(n-1) + laboratoriDeRatolins(n-2)
}