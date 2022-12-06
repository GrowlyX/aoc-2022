/**
 * @author GrowlyX
 * @since 12/2/2022
 */
fun main()
{
    fun part1(input: List<String>): List<Char>
    {
        val directions = input
            .filter {
                it.startsWith("move")
            }

        val containerListIndex = input
            .indexOfFirst {
                it.startsWith(" 1 ")
            }

        if (containerListIndex == -1)
        {
            throw IllegalStateException(
                "No container list line found ( 1 2 3 ...)"
            )
        }

        val containerList = input[containerListIndex]
            .removePrefix(" ")
            .removeSuffix(" ")
            .split("   ")
            .map(String::toInt)

        val crateContainers = mutableListOf<MutableList<Char>>()

        for (container in containerList)
        {
            val index = 1 + (4 * (container - 1))
            val characters = mutableListOf<Char>()

            for (row in 0 until containerListIndex)
            {
                val crate = input[row]
                    .getOrNull(index)
                    ?: ' '

                if (crate !== ' ')
                {
                    characters += crate
                }
            }

            characters.reverse()
            crateContainers += characters
        }

        for (direction in directions)
        {
            // ghetto parse solution but its fine 4 now
            // TODO: regex? extract keys
            val parsed = direction
                .replace("move ", "")
                .replace(" from ", ",")
                .replace(" to ", ",")
                .split(",")
                .map(String::toInt)

            val toRemove = parsed[0]
            val removeFrom = parsed[1] - 1
            val relocateTo = parsed[2] - 1

            val takenFromContainer = crateContainers[removeFrom]

            crateContainers[relocateTo] +=
                takenFromContainer.takeLast(toRemove).reversed()

            (1..toRemove).forEach { _ ->
                takenFromContainer.removeLastOrNull()
            }
        }

        return crateContainers.map { it.last() }
    }

    fun part2(input: List<String>): Int
    {
        return -1
    }

    println(part1(readInput(5, 1)))
    println(part2(readInput(5, 2)))
}
