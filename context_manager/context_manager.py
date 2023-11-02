# Defining a simple context manager class that manages file operations
class ManagedFile:
    def __init__(self, filename):
        self.filename = filename

    def __enter__(self):
        self.file = open(self.filename, 'r')
        return self.file

    def __exit__(self, exc_type, exc_val, exc_tb):
        if self.file:
            self.file.close()

# Using the context manager to read a file
with ManagedFile('example.txt') as f:
    content = f.read()
    print("Content of the file:", content)
# The file will be automatically closed after exiting the 'with' block.
