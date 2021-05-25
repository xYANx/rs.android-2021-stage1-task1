package subtask3

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        var arrayList = arrayListOf<String>()
        var text = ""
        var isStart = false
        val idMap = mutableMapOf<Char, String>()
        val listMap = mutableMapOf<Char, Map<String,String>>()
        val boolMap = mutableMapOf<Char, Boolean>()
//        boolMap['{'] = false
//        boolMap['['] = false
//        boolMap['('] = false
//        boolMap['<'] = false

        idMap['{'] = ""
        idMap['['] = ""
        idMap['('] = ""
        idMap['<'] = ""


        for(s in inputString){
            if(s == '{' || s == '[' || s == '(' || s == '<'){
                for(i in boolMap){
                    if (i.value) {
                        text = idMap[i.key] ?: ""
                        text += s
                        idMap.replace(i.key, text)
                    }
                }
                boolMap[s] = true
                isStart = true
            } else if(s == '}' || s == ']' || s == ')' || s == '>'){
                val c = changeChar(s)
                if (isStart){
                    boolMap[c] = false
                    text = idMap[c] ?: ""
                    idMap[c] = ""
                    arrayList.add(text)
                    for(i in boolMap){
                        if (i.value) {
                            text = idMap[i.key] ?: ""
                            text += s
                            idMap.replace(i.key, text)
                        }
                    }
                }
            } else for(i in boolMap){
                    if (i.value) {
                        text = idMap[i.key] ?: ""
                        text += s
                        idMap.replace(i.key, text)
                    }
                }
        }
        for (a in boolMap){
            println(a.key + " - " + a.value)
        }
//        for (a in idMap){
//            println(a.key + " - " + a.value)
//        }
        val arrayString = Array(arrayList.size, { i -> (i * i).toString() })
        for (i in arrayList.indices){
            arrayString[i] = arrayList[i]
            println(arrayList[i])
        }
        return arrayString
    }

    private fun changeChar(c: Char): Char{
        var exit = '{'
        if(c == '}') exit = '{'
        if(c == ']') exit = '['
        if(c == ')') exit = '('
        if(c == '>') exit = '<'
        return exit
    }
}
