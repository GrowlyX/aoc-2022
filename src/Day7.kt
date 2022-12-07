/**
 * @author GrowlyX
 * @since 12/2/2022
 */
fun main()
{
    data class Command(
        val execution: String,
        val results: MutableList<String>
    )

    data class Container(
        val name: String,
        val directory: Boolean,
        val size: Int = -1,
        val subFiles: MutableMap<String, Container> = mutableMapOf(),
        val parent: Container? = null
    )
    {
        fun aggregateSize(): Int
        {
            if (directory)
            {
                return subFiles.values
                    .map(Container::aggregateSize)
                    .sum()
            }

            return size
        }
    }

    fun parseIntoCommands(input: List<String>): List<Command>
    {
        val commands = mutableListOf<Command>()

        for (line in input)
        {
            if (line.startsWith("$"))
            {
                commands += Command(
                    execution = line.removePrefix("$ "),
                    results = mutableListOf()
                )
                continue
            }

            commands.last().results += input
        }

        return commands
    }

    fun part1(input: List<String>): Int
    {
        val root = Container("/", true)

        val commands = parseIntoCommands(input)
        commands.removeFirst() // already in root

        var scope = root

        for (command in commands)
        {
            val label = command.execution.split(" ")

            if (label == "cd")
            {
                scope = when (label[1])
                {
                    "/" -> root
                    ".." -> scope.parent ?: root
                    else -> {
                        scope.subFiles[label[1]]
                            ?: kotlin.run {
                                val container = Container(
                                    split[1], 
                                    directory = true,
                                    parent = scope
                                )

                                scope.subFiles[label[1]] = container
                                container
                            }
                    }
                }
            }

            if (label == "ls")
            {
                for (result in command.results)
                {
                    val split = result.split(" ")
                    val directory = split[0] == "dir"

                    scope.subFiles[split[1]]
                        ?: kotlin.run {
                            scope.subFiles[split[1]] =
                                Container(
                                    split[1], 
                                    size = if (directory) -1 else directory.toInt()
                                    directory = directory,
                                    parent = scope
                                )
                        }
                }
            }
        }
        
        return root.aggregateSize()
    }

    fun part2(input: List<String>): Int
    {
        return -1
    }

    println(part1(readInput(7, 1)))
    println(part2(readInput(7, 2)))
}
