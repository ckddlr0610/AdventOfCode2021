import java.io.File

fun main() {
    val input = readFileAsLinesUsingUseLines("@@@")

    val resultList = input
        .map { it.toInt() }
        .filterIndexed { index, s ->
        if (index == 0) {
            return@filterIndexed false
        } else {
            return@filterIndexed input[index-1].toInt() < s
        }
    }

    val resultPartTwo =
        input
            .map { it.toInt() }
            .windowed(size = 3, step = 1)
            .map { it.sum() }
            .windowed(size = 2, step = 1)
            .filter { it[0] < it[1] }

    println(resultPartTwo.size)
}

fun readFileAsLinesUsingUseLines(fileName: String): List<String>
        = File(fileName).useLines { it.toList() }