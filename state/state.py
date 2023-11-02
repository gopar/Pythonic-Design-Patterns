class CharacterState:
    def move(self):
        pass

    def attack(self):
        pass


class MageState(CharacterState):
    def move(self):
        print("Floating gracefully.")

    def attack(self):
        print("Casting a spell of destruction!")


class FighterState(CharacterState):
    def move(self):
        print("Marching with valor.")

    def attack(self):
        print("Swinging the sword of destiny!")


class ScavengerState(CharacterState):
    def move(self):
        print("Scurrying cautiously.")

    def attack(self):
        print("Lashing with a nimble dagger.")


class Character:
    def __init__(self):
        self.state = None

    def change_state(self, state):
        self.state = state

    def move(self):
        self.state.move()

    def attack(self):
        self.state.attack()


# Usage
if __name__ == "__main__":
    character = Character()

    mage_state = MageState()
    fighter_state = FighterState()
    scavenger_state = ScavengerState()

    character.change_state(mage_state)
    character.move()
    character.attack()

    character.change_state(fighter_state)
    character.move()
    character.attack()

    character.change_state(scavenger_state)
    character.move()
    character.attack()
