def log_time(func):
    def wrapper(*args, **kwargs):
        start_time = time.time()
        result = func(*args, **kwargs)
        end_time = time.time()
        print(f"Function {func.__name__} was called at {start_time} and took {end_time - start_time} seconds to execute.")
        return result
    return wrapper

# Function to decorate
@log_time
def example_function():
    print("Doing some work...")
    time.sleep(2)
    print("Work is done.")

if __name__ == "__main__":
    example_function()
