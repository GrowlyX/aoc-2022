/**
 * @author GrowlyX
 * @since 12/2/2022
 */
enum class Play(val score: Int)
{  
    Paper(2)  Rock(1), Scissors(3);

    fun destroys() = Play.values()
        .getOrNull(ordinal + 1)
        ?: Play.Paper
}

fun main()
{
   fun calculateScore(input: List<String>, withPlay: Boolean): Int {
        val lose = mapOf(1 to 0, 2 to 1, 0 to 2)
        val won = mapOf(0 to 1, 1 to 2, 2 to 0)

        return input.sumOf { round ->
            val (op, result) = round.split(" ").map { it[0].code }
            val opCode = op - 'A'.code
            val meCode = result - 'X'.code

            val (resultScore, playScore) = if (withPlay) {
                when {
                    opCode == meCode -> 3
                    won[opCode]!! == meCode -> 6
                    else -> 0
                } to meCode + 1
            } else {
                3 * meCode to when (meCode) {
                    0 -> lose[opCode]!!
                    1 -> opCode
                    else -> won[opCode]!!
                } + 1
            }

            resultScore + playScore
        }
    }

    fun part1(input: List<String>): Int
    {
        val mappings = mutableMapOf(
            'A' to Play.Rock,
            'B' to Play.Paper,
            'C' to Play.Scissors,
            'X' to Play.Rock,
            'Y' to Play.Paper,
            'Z' to Play.Scissors
        )

        var score = 0

        input.forEach {
            val first = mappings[it[0]]!!
            val second = mappings[it[2]]!!

            score += first.score

            if (first == second)
            {
                score += 3
                println("It's a tie!")
                return@forEach
            }

            if (second.destroys() == first)
            {
                println("You lost! $first lost to $second")
                return@forEach
            }

            if (first.destroys() == second)
            {
                score += 6
                println("You won! $first won to $second")
                return@forEach
            }

            println("NOTHING HAPPENED?? ${it}")
        }

        return score
    }

    fun part2(input: List<String>): Int
    {
        return -1
    }

    println(part1(readInput(2, 1)))
    println(part2(readInput(1, 2)))
}
