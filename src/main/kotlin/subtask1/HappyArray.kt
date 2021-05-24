package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        var isHappy = false
        var happyArray = intArrayOf()
        var checkArray = sadArray
        if (sadArray.size > 0) {
            while (!isHappy) {
                isHappy = true
                var count = 0
                for (i in 1 until checkArray.lastIndex) {
                    val sum = checkArray[i - 1] + checkArray[i + 1]
                    if (checkArray[i] > sum) {
                        count++
                        isHappy = false
                    }
                }
                happyArray = IntArray(checkArray.size - count)
                happyArray[0] = checkArray[0]
                happyArray[happyArray.lastIndex] = checkArray[checkArray.lastIndex]
                count = 1
                for (i in 1 until checkArray.lastIndex) {
                    val sum = checkArray[i - 1] + checkArray[i + 1]
                    if (checkArray[i] < sum) {
                        happyArray[count] = checkArray[i]
                        count++
                    }
                }
                if (!isHappy) checkArray = happyArray
            }
        }
        return happyArray
    }
}
