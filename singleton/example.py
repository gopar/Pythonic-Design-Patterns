class ConfigurationManager:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            print("Creating ConfigurationManager instance")
            cls._instance = super(ConfigurationManager, cls).__new__(cls)
            # Put any initialization here.
            cls._instance.config_data = {}
        return cls._instance

# Client code
config1 = ConfigurationManager()
config1.config_data = {"db": "localhost", "api_key": "12345"}

config2 = ConfigurationManager()
print(config2.config_data)  # Output will be {"db": "localhost", "api_key": "12345"}, proving that config1 and config2 are the same object.

# Changing config2 will affect config1
config2.config_data["db"] = "remote_host"
print(config1.config_data)  # Output will be {"db": "remote_host", "api_key": "12345"}
