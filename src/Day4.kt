/**
 * @author GrowlyX
 * @since 12/4/2022
 */
fun main()
{
    fun parseLineIntoRanges(line: String) =
        line.split(",")
            .map { range ->
                val parsed = range.split("-")

                // TODO: improve range parsing
                parsed.first().toInt()..parsed[1].toInt()
            }

    fun part1(input: List<String>): Int
    {
        var containsEntireRange = 0

        input.forEach {
            val split = parseLineIntoRanges(it)

            val first = split.first()
            val second = split[1]

            val containsAll = second
                .all { num ->
                    num in first
                }

            val containsAllSecond = first
                .all { num ->
                    num in second
                }

            if (containsAll || containsAllSecond)
            {
                containsEntireRange += 1
            }
        }

        return containsEntireRange
    }

    fun part2(input: List<String>): Int
    {
        var containsAnyOverlaps = 0

        input.forEach {
            val split = parseLineIntoRanges(it)

            val first = split.first()
            val second = split[1]

            val containsAny = second
                .any { num ->
                    num in first
                }

            if (containsAny)
            {
                containsAnyOverlaps += 1
            }
        }

        return containsAnyOverlaps
    }

    println(part1(readInput(4, 1)))
    println(part2(readInput(4, 2)))
}
