class Icon:
    def __init__(self, icon_type):
        self.icon_type = icon_type
        self.attribute = "original"

class IconFactory:
    _icons = {}

    @classmethod
    def get_icon(cls, icon_type):
        if icon_type not in cls._icons:
            cls._icons[icon_type] = Icon(icon_type)
        return cls._icons[icon_type]

# Client code
icon1 = IconFactory.get_icon("PDF")
icon2 = IconFactory.get_icon("PDF")

print(icon1.attribute)  # Output: "original"
print(icon2.attribute)  # Output: "original"

icon1.attribute = "changed"

print(icon1.attribute)  # Output: "changed"
print(icon2.attribute)  # Output: "changed"
