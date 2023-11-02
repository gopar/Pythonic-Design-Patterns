// Command Interface
interface Command {
    fun execute()
    fun undo()
}

// Concrete Command for Adding
class AddCommand(private val list: MutableList<Int>, private val value: Int) : Command {
    override fun execute() {
        list.add(value)
    }

    override fun undo() {
        list.removeAt(list.size - 1)
    }
}

// Invoker
class Calculator {
    private val commandHistory: MutableList<Command> = mutableListOf()
    private var currentCommandIndex: Int = -1

    fun executeCommand(command: Command) {
        commandHistory.add(command)
        command.execute()
        currentCommandIndex++
    }

    fun undo() {
        if (currentCommandIndex >= 0) {
            commandHistory[currentCommandIndex].undo()
            currentCommandIndex--
        }
    }

    fun redo() {
        if (currentCommandIndex < commandHistory.size - 1) {
            currentCommandIndex++
            commandHistory[currentCommandIndex].execute()
        }
    }
}

// Client Code
fun main() {
    val list = mutableListOf(1, 2, 3)
    val calculator = Calculator()

    val addFive = AddCommand(list, 5)
    val addTen = AddCommand(list, 10)

    println("Initial list: $list")  // Output: Initial list: [1, 2, 3]

    calculator.executeCommand(addFive)
    println("After adding 5: $list")  // Output: After adding 5: [1, 2, 3, 5]

    calculator.executeCommand(addTen)
    println("After adding 10: $list")  // Output: After adding 10: [1, 2, 3, 5, 10]

    calculator.undo()
    println("After undo: $list")  // Output: After undo: [1, 2, 3, 5]

    calculator.redo()
    println("After redo: $list")  // Output: After redo: [1, 2, 3, 5, 10]
}
