package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        var count = 0
        for(i in 1 until sadArray.lastIndex){
            val sum = sadArray[i - 1] + sadArray[i + 1]
            if(sadArray[i] > sum){
                count++
            }
        }
        val happyArray = IntArray(sadArray.size - count)
        happyArray[0] = sadArray[0]
        happyArray[happyArray.lastIndex] = sadArray[sadArray.lastIndex]
        count = 1
        for(i in 1 until sadArray.lastIndex){
            val sum = sadArray[i - 1] + sadArray[i + 1]
            if(sadArray[i] < sum){
                happyArray[count] = sadArray[i]
                count++
            }
        }
        return happyArray
    }
}
