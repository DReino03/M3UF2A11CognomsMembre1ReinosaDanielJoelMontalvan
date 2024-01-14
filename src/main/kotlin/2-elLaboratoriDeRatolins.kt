import java.util.*

/**
 * Funció principal
 */
fun main(){
    val sc = Scanner(System.`in`)
    println("Introdueix un nombre que representi un mes:")
    val n = sc.nextInt()
    val result = laboratoriDeRatolins(n)
    println("Al cap de $n messos hi haura $result parelles de ratolins al laboratori.")
}

/**
 * @author Joel Montalvan i Daniel Reinosa
 * Funció que calcula el nombre de parelles de ratolins que hi ha al cap de n mesos
 * @param n Nombre de mesos
 * @return Nombre de parelles de ratolins
 */
fun laboratoriDeRatolins(n: Int): Int{
    if(n == 1 || n == 2)
        return n
    return laboratoriDeRatolins(n-1) + laboratoriDeRatolins(n-2)
}