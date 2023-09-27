class RealDocument:
    def __init__(self):
        self.content = None

    def read(self):
        print(f"Reading content: {self.content}")

    def write(self, content):
        self.content = content
        print(f"Writing content: {self.content}")

class SecureDocumentProxy:
    def __init__(self, password):
        self.password = password
        self.real_document = RealDocument()

    def read(self):
        self.real_document.read()

    def write(self, content):
        if self.password == "correct_password":
            self.real_document.write(content)
        else:
            print("Unauthorized: Incorrect password for write operation.")

# Client code
secure_doc = SecureDocumentProxy("correct_password")
secure_doc.write("Hello, world!")  # Successful write operation
secure_doc.read()  # Reads the content

wrong_password_doc = SecureDocumentProxy("wrong_password")
wrong_password_doc.write("This won't work")  # Unsuccessful write operation
wrong_password_doc.read()  # Reads the content (potentially empty or old)
