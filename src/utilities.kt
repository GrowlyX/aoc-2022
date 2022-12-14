import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(day: Int, part: Int) =
    File(
        "G:\\Organizations\\AOC\\inputs",
        "day$day-part$part.txt"
    ).let {
        if (it.exists())
            return@let it.readLines()

        return@let listOf()
    }

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
