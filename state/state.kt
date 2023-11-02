// Defining the State Interface
interface State {
    fun onEnterState()
    fun observe()
}

// Concrete States
class PeacefulState(private val mammoth: Mammoth) : State {
    override fun onEnterState() {
        println("${mammoth} calms down.")
    }

    override fun observe() {
        println("${mammoth} is calm and peaceful.")
    }
}

class AngryState(private val mammoth: Mammoth) : State {
    override fun onEnterState() {
        println("${mammoth} gets angry!")
    }

    override fun observe() {
        println("${mammoth} is furious!")
    }
}

// Context
class Mammoth {
    private var state: State = PeacefulState(this)

    fun timePasses() {
        if (state is PeacefulState) {
            changeStateTo(AngryState(this))
        } else {
            changeStateTo(PeacefulState(this))
        }
    }

    private fun changeStateTo(newState: State) {
        state = newState
        state.onEnterState()
    }

    override fun toString(): String {
        return "The mammoth"
    }

    fun observe() {
        state.observe()
    }
}

// Usage
fun main() {
    val mammoth = Mammoth()
    mammoth.observe()
    mammoth.timePasses()
    mammoth.observe()
    mammoth.timePasses()
    mammoth.observe()
}
