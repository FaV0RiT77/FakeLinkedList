import java.util.HashMap

fun main() {

    val threeDHashMap: MutableMap<String, MutableMap<String, MutableMap<String, Int>>> = HashMap()

    threeDHashMap["Layout"] = HashMap()
    threeDHashMap["Layout"]!!["ViewGroup1"] = HashMap()
    threeDHashMap["Layout"]!!["ViewGroup1"]!!["View1"] = 10
    threeDHashMap["Layout"]!!["ViewGroup1"]!!["View2"] = 20
    threeDHashMap["Layout"]!!["ViewGroup2"] = HashMap()
    threeDHashMap["Layout"]!!["ViewGroup2"]!!["View3"] = 30
    threeDHashMap["Layout"]!!["ViewGroup2"]!!["View4"] = 40

    findViewWithId(threeDHashMap, 30)
}

fun findViewWithId(viewGroup: Any, id: Int): String {
    val viewId = 30
    if (id != viewId) {
        viewId.equals(id)
    }
}