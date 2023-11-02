import random

class AlienEnemy:
    def attack(self):
        return "Alien enemy attacks with laser!"

class ZombieEnemy:
    def attack(self):
        return "Zombie enemy attacks with bite!"

class RobotEnemy:
    def attack(self):
        return "Robot enemy attacks with rockets!"

    @classmethod
    def from_json(cls, json):
        return cls(**json)

enemies = {
    'alien': AlienEnemy,
    'zombie': ZombieEnemy,
    'robot': RobotEnemy,
}

def enemy_attack():
    enemy_type = random.choice(enemies.keys())
    enemy = enemies[enemy_type]()
    enemy.attack()
