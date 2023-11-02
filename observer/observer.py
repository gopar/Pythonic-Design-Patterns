# Define the Subject (Observable) interface
class WeatherStation:
    def add_observer(self, observer):
        pass

    def remove_observer(self, observer):
        pass

    def notify_observers(self):
        pass

# Concrete implementation of Subject
class ConcreteWeatherStation(WeatherStation):
    def __init__(self):
        self.temperature = 0
        self.observers = []

    def add_observer(self, observer):
        self.observers.append(observer)

    def remove_observer(self, observer):
        self.observers.remove(observer)

    def notify_observers(self):
        for observer in self.observers:
            observer.update(self.temperature)

    def set_temperature(self, temperature):
        self.temperature = temperature
        self.notify_observers()

# Define the Observer interface
class WeatherDisplay:
    def update(self, temperature):
        pass

# Concrete implementation of Observer
class CurrentConditionsDisplay(WeatherDisplay):
    def update(self, temperature):
        print(f"Current conditions: {temperature}°C")

# Client code
weather_station = ConcreteWeatherStation()
current_display = CurrentConditionsDisplay()

# Registering the observer
weather_station.add_observer(current_display)

# Changing the temperature (this will trigger observer notifications)
weather_station.set_temperature(25)
weather_station.set_temperature(30)
