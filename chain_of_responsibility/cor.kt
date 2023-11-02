// Handler interface
interface Logger {
    var next: Logger?
    fun log(severity: String, message: String)
}

// Concrete Handler 1: InfoLogger
class InfoLogger : Logger {
    override var next: Logger? = null

    override fun log(severity: String, message: String) {
        if (severity == "INFO") {
            println("[INFO] $message")
        } else {
            next?.log(severity, message)
        }
    }
}

// Concrete Handler 2: ErrorLogger
class ErrorLogger : Logger {
    override var next: Logger? = null

    override fun log(severity: String, message: String) {
        if (severity == "ERROR") {
            println("[ERROR] $message")
        } else {
            next?.log(severity, message)
        }
    }
}

// Client Code
fun main() {
    val infoLogger = InfoLogger()
    val errorLogger = ErrorLogger()

    infoLogger.next = errorLogger

    infoLogger.log("INFO", "This is an informational message.")
    infoLogger.log("ERROR", "This is an error message.")
    infoLogger.log("DEBUG", "This is a debug message.") // This message will go unhandled
}
