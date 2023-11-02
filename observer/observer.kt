// Subject
interface WeatherStation {
    fun addObserver(observer: WeatherDisplay)
    fun removeObserver(observer: WeatherDisplay)
    fun notifyObservers()
}

// Concrete Subject
class ConcreteWeatherStation : WeatherStation {
    private var temperature: Float = 0.0f
    private val observers = mutableListOf<WeatherDisplay>()

    override fun addObserver(observer: WeatherDisplay) {
        observers.add(observer)
    }

    override fun removeObserver(observer: WeatherDisplay) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update(temperature)
        }
    }

    fun setTemperature(newTemperature: Float) {
        this.temperature = newTemperature
        notifyObservers()
    }
}

// Observer
interface WeatherDisplay {
    fun update(temperature: Float)
}

// Concrete Observer
class CurrentConditionsDisplay : WeatherDisplay {
    override fun update(temperature: Float) {
        println("Current conditions: $temperature °C")
    }
}

// Client Code
fun main() {
    val weatherStation = ConcreteWeatherStation()
    val currentConditions = CurrentConditionsDisplay()

    weatherStation.addObserver(currentConditions)

    println("Changing temperature...")
    weatherStation.setTemperature(30.0f)

    println("Changing temperature again...")
    weatherStation.setTemperature(32.0f)
}
