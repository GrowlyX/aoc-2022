/**
 * @author GrowlyX
 * @since 12/2/2022
 */
enum class Play(
    val score: Int,
    private val destroysEnumConstants: List<String>
)
{  
    Scissors(3, listOf(
        "Paper"
    )),

    Rock(1, listOf(
        "Scissors"
    )),
        
    Paper(2, listOf(
        "Rock"
    ));

    val destroys by lazy {
        this.destroysEnumConstants.map(Play::valueOf)
    }
}

fun main()
{
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

            if (first in second.destroys)
            {
                score += 0
                println("You won!")
                return@forEach
            }

            if (second in first.destroys)
            {
                score += 6
                println("You lost!")
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
