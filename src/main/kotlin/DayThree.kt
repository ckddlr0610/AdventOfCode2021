fun main() {
    val input = readFileAsLinesUsingUseLines("/Users/kakao_ent/Desktop/input.txt")

    val columns = input[0].indices

    val gamma = buildString {
        for (column in columns) {
            val result = input.calculateBinaryPerColumn(column)
            val commonBit = if (result.first < result.second) {
                "0"
            } else {
                "1"
            }
            append(commonBit)
        }
    }

    val epsilon = gamma.invertToString()
    println(gamma.toInt(2) * epsilon.toInt(2))
}

private fun String.invertToString(): String {
    return this.asIterable().joinToString("") {
        if (it == '0') {
            "1"
        } else {
            "0"
        }
    }
}

private fun List<String>.calculateBinaryPerColumn(column: Int): Pair<Int, Int> {
    var zero = 0
    var one = 0

    for (str in this) {
        if (str[column] == '0') {
            zero++
        } else {
            one++
        }
    }

    return zero to one
}
