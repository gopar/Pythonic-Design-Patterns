from dataclasses import dataclass, field
from typing import Optional

@dataclass
class Car:
    make: str
    model: str
    year: int
    color: Optional[str] = field(default="Black")
    wheels: Optional[int] = field(default=4)
    sunroof: Optional[bool] = field(default=False)

class Car:
    def __init__(self, make: str, model: str, year: int, color="Black", wheels=4, sunroof=False):
        self.make = make
        self.model = model
        self.year = year
        self.color = color
        self.wheels = wheels
        self.sunroof = sunroof

# Creating instances of Car with different parameters
car1 = Car("Toyota", "Camry", 2022)
car2 = Car("Ford", "Mustang", 2022, color="Red", sunroof=True)
car3 = Car("Tesla", "Model X", 2022, wheels=4, color="White")
