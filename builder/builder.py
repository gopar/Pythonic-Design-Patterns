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

# Creating instances of Car with different parameters
car1 = Car("Toyota", "Camry", 2022)
car2 = Car("Ford", "Mustang", 2022, color="Red", sunroof=True)
car3 = Car("Tesla", "Model X", 2022, wheels=4, color="White")
