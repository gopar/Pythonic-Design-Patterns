# The basic coffee
def basic_coffee():
    return 2.0, "Basic coffee"

# Decorators
def add_milk(coffee_func):
    def wrapper():
        cost, description = coffee_func()
        return cost + 0.5, description + ", with milk"
    return wrapper

def add_sugar(coffee_func):
    def wrapper():
        cost, description = coffee_func()
        return cost + 0.2, description + ", with sugar"
    return wrapper

if __name__ == "__main__":
    coffee = basic_coffee
    print(f"Cost: {coffee()[0]}; Description: {coffee()[1]}")

    coffee = add_milk(basic_coffee)
    print(f"Cost: {coffee()[0]}; Description: {coffee()[1]}")

    coffee = add_sugar(add_milk(basic_coffee))
    print(f"Cost: {coffee()[0]}; Description: {coffee()[1]}")
