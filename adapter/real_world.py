class LocalFile:
    def read(self):
        return "Data read from local disk."

# New system (Let's say it reads from AWS S3)
class S3File:
    def fetch(self):
        return "Data fetched from S3 bucket."

def read(self):
    return self.fetch()

S3File.read = read

# Client code that can work with any file-like object
def client_code(file_obj):
    print(file_obj.read())

# Using the client code
local_file = LocalFile()
client_code(local_file)

s3_file = S3File()
client_code(s3_file)
