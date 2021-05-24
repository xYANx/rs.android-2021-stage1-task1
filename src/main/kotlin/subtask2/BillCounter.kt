package subtask2

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var result = "Bon Appetit"
        var sum = 0
        for(i in bill.indices){
            if(i != k){
                sum += bill[i]
            }
        }
        sum /= 2
        if(sum != b){
            result = (b - sum).toString()
        }
        return result
    }
}
