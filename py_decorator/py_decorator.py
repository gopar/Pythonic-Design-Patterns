# Defining a simple decorator to measure the execution time of a function
import time

def timing_decorator(func):
    def wrapper(*args, **kwargs):
        start_time = time.time()
        result = func(*args, **kwargs)
        end_time = time.time()
        print(f"{func.__name__} took {end_time - start_time:.4f} seconds to run.")
        return result
    return wrapper

# Using the decorator to enhance the functionality of a function
@timing_decorator
def slow_function(duration):
    time.sleep(duration)
    print("Function finished execution.")

# Invoking the decorated function
slow_function(2)
