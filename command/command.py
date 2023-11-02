class Command:
    def execute(self):
        pass

    def undo(self):
        pass

# Concrete Command for Adding
class AddCommand(Command):
    def __init__(self, lst, value):
        self.lst = lst
        self.value = value

    def execute(self):
        self.lst.append(self.value)

    def undo(self):
        self.lst.pop()

# Invoker
class Calculator:
    def __init__(self):
        self.command_history = []
        self.current_command_index = -1

    def execute_command(self, command):
        self.command_history.append(command)
        command.execute()
        self.current_command_index += 1

    def undo(self):
        if self.current_command_index >= 0:
            self.command_history[self.current_command_index].undo()
            self.current_command_index -= 1

    def redo(self):
        if self.current_command_index < len(self.command_history) - 1:
            self.current_command_index += 1
            self.command_history[self.current_command_index].execute()

# Client code
if __name__ == "__main__":
    lst = [1, 2, 3]
    calculator = Calculator()

    add_five = AddCommand(lst, 5)
    add_ten = AddCommand(lst, 10)

    print(f"Initial list: {lst}")

    calculator.execute_command(add_five)
    print(f"After adding 5: {lst}")

    calculator.execute_command(add_ten)
    print(f"After adding 10: {lst}")

    calculator.undo()
    print(f"After undo: {lst}")

    calculator.redo()
    print(f"After redo: {lst}")
