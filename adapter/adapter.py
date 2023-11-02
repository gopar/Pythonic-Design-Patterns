class LocalFile:
    def read(self):
        return "Data read from local disk."

class S3File:
    def fetch(self):
        return "Data fetched from S3 bucket."

# Adapter
class S3FileAdapter:
    def __init__(self, s3_file):
        self.s3_file = s3_file

    def read(self):
        return self.s3_file.fetch()

# Client code that can work with any file-like object
def client_code(file_obj):
    print(file_obj.read())

# Using the client code
local_file = LocalFile()
client_code(local_file)

s3_file = S3File()
s3_adapter = S3FileAdapter(s3_file)
client_code(s3_adapter)
