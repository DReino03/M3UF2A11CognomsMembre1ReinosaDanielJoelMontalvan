import java.util.*

//1. Pintant una regió.
//Tenim un tauler quadrat de n × n cel·les blanques i negres, distribuïdes
//de qualsevol forma. Una regió blanca és un conjunt contigu de cel·les
//blanques: dues cel·les blanques són contígües si tenen un costat comú
//(si només tenen un vértex comú, llavors no son contigües). Una regió
//negra es defineix de forma equivalent. El valor de n no pot ser més gran
//de 20.
//Exemple. Si donat el taulell de l’esquerra es demana pintar la regió de la
//cel·la (3,3) de color gris. El resultat hauria de ser el taulell de la dreta.

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val tauler = Array(n){Array(n){0}}
    for(i in 0..<n){
        for(j in 0..<n){
            tauler[i][j] = sc.nextInt()
        }
    }
    val x = sc.nextInt()
    val y = sc.nextInt()
    val color = sc.nextInt()
    pintarRegio(tauler, x, y, color)
    printTauler(tauler)


}
fun pintarRegio(tauler: Array<Array<Int>>, x: Int, y: Int, color: Int){
    if(x < 0 || x >= tauler.size || y < 0 || y >= tauler.size)
        return
    if(tauler[x][y] != color)
        return
    tauler[x][y] = color
    pintarRegio(tauler, x-1, y, color)
    pintarRegio(tauler, x+1, y, color)
    pintarRegio(tauler, x, y-1, color)
    pintarRegio(tauler, x, y+1, color)
}
fun printTauler(tauler: Array<Array<Int>>){
    for(element in tauler){
        for(j in tauler.indices){
            print("${element[j]} ")
        }
        println()
    }
}
