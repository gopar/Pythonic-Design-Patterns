class AlienEnemy(Enemy):
    def attack(self):
        return "Alien enemy attacks with laser!"

class ZombieEnemy(Enemy):
    def attack(self):
        return "Zombie enemy attacks with bite!"

class RobotEnemy(Enemy):
    def attack(self):
        return "Robot enemy attacks with rockets!"

    @classmethod
    def create(cls):
        return cls()

    @classmethod
    def from_json(cls, json):
        return cls(**json)

enemy_creators = {
    'alien': AlienEnemy,
    'zombie': ZombieEnemy,
    'robot': RobotEnemy.create,
}

def enemy_attack(enemy_type):
    enemy = enemy_creators[enemy_type]()
    enemy.attack()

def enemy_attack_type(enemy_type):
    enemy_class = type(enemy_type.capitalize() + "Enemy", (Enemy,), {})
    enemy = enemy_class()
    enemy.attack()
