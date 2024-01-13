import java.util.*

//L’algorisme mergesort és un mètode d’ordenació que es basa en un
//principi molt simple: s’ordenen les dues meitats d’un vector i, una
//vegada ordenades, es fusionen agafant cada vegada l’element més petit
//de cada meitat. Escriu un programa recursiu que implementi aquest
//algorisme d’ordenació.

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val v = IntArray(n)
    for(i in 0 until n){
        v[i] = sc.nextInt()
    }
    mergesort(v, 0, v.size-1)
    println(v.contentToString())
}
fun mergesort(v: IntArray, esq: Int, dre: Int){
    if(esq < dre){
        val mig = (esq + dre)/2
        mergesort(v, esq, mig)
        mergesort(v, mig+1, dre)
        merge(v, esq, mig, dre)
    }
}
fun merge(v: IntArray, esq: Int, mig: Int, dre: Int){
    val n1 = mig - esq + 1
    val n2 = dre - mig
    val esqArray = IntArray(n1)
    val dreArray = IntArray(n2)
    for(i in 0 until n1){
        esqArray[i] = v[esq + i]
    }
    for(j in 0 until n2){
        dreArray[j] = v[mig + 1 + j]
    }
    var i = 0
    var j = 0
    var k = esq
    while(i < n1 && j < n2){
        if(esqArray[i] <= dreArray[j]){
            v[k] = esqArray[i]
            i++
        }else{
            v[k] = dreArray[j]
            j++
        }
        k++
    }
    while(i < n1){
        v[k] = esqArray[i]
        i++
        k++
    }
    while(j < n2){
        v[k] = dreArray[j]
        j++
        k++
    }
}