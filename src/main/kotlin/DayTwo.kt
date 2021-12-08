import java.io.File

fun main() {
    val input = readFileAsLinesUsingUseLines("/Users/kakao_ent/Desktop/input.txt")
    val horizontal = input
        .filter {
            val str = it.split(" ")
            str[0] == "forward"
        }
        .map {
            val str = it.split(" ")
            str[1].toInt()
        }
        .reduce{ total, data ->
            total + data
        }

    val depth = input
        .filter {
            val str = it.split(" ")
            str[0] == "down" || str[0] == "up"
        }
        .map {
            val str = it.split(" ")
            if (str[0] == "down") {
                return@map str[1].toInt()
            } else {
                return@map str[1].toInt().unaryMinus()
            }
        }
        .reduce{ total, data ->
            total + data
        }

    println(horizontal * depth)
}