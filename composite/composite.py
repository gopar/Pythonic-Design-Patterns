# Simulating a GUI library using Composite Pattern
class Widget:
    def draw(self):
        pass


class Frame(Widget):
    def __init__(self):
        self.children = []

    def add(self, child):
        self.children.append(child)

    def draw(self):
        print("Drawing a frame")
        for child in self.children:
            child.draw()


class Panel(Widget):
    def __init__(self):
        self.children = []

    def add(self, child):
        self.children.append(child)

    def draw(self):
        print("Drawing a panel")
        for child in self.children:
            child.draw()


class Text(Widget):
    def draw(self):
        print("Drawing text")


class Button(Widget):
    def draw(self):
        print("Drawing a button")


# Constructing the GUI
top_frame = Frame()

# Adding two panels to the top frame
panel1 = Panel()
panel2 = Panel()
top_frame.add(panel1)
top_frame.add(panel2)

# Adding text widgets to the panels
text1 = Text()
text2 = Text()
panel1.add(text1)
panel2.add(text2)

# Drawing the GUI
top_frame.draw()
