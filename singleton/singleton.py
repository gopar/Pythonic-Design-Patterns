class SingletonNew:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
        return cls._instance

def singleton(cls):
    instances = {}
    def wrapper(*args, **kwargs):
        if cls not in instances:
            instances[cls] = cls(*args, **kwargs)
        return instances[cls]
    return wrapper

@singleton
class SingletonDecorator:
    pass

class SingletonMeta(type):
    _instances = {}
    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            instance = super().__call__(*args, **kwargs)
            cls._instances[cls] = instance
        return cls._instances[cls]

class SingletonMetaclass(metaclass=SingletonMeta):
    pass

class SingletonDict:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
        return cls._instance

    def __init__(self):
        self.__dict__ = self._instance.__dict__

# my_module.py
shared_variable = None
# Testing the Singletons

# Test the Singletons
s1 = SingletonNew()
s2 = SingletonNew()
print(s1 is s2)  # Output: True

s3 = SingletonDecorator()
s4 = SingletonDecorator()
print(s3 is s4)  # Output: True

s5 = SingletonMetaclass()
s6 = SingletonMetaclass()
print(s5 is s6)  # Output: True

s7 = SingletonDict()
s8 = SingletonDict()
print(s7 is s8)  # Output: True
