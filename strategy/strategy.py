from dataclasses import dataclass
from typing import List, Callable

# Using dataclass to make Anime class more Pythonic
@dataclass
class Anime:
    name: str
    rating: float
    year: int

    def __repr__(self):
        return f"{self.name} ({self.rating}, {self.year})"

# Using Callable for the strategy
def sort_by_ratings(anime_list: List[Anime]) -> List[Anime]:
    return sorted(anime_list, key=lambda x: x.rating, reverse=True)

def sort_by_year(anime_list: List[Anime]) -> List[Anime]:
    return sorted(anime_list, key=lambda x: x.year, reverse=True)

# Define the context
class AnimeListContext:
    def __init__(self, strategy: Callable = None):
        self.strategy = strategy

    def set_strategy(self, strategy: Callable):
        self.strategy = strategy

    def sort_anime(self, anime_list: List[Anime]) -> List[Anime]:
        return self.strategy(anime_list) if self.strategy else anime_list

anime_list = [
    Anime("Naruto", 7.5, 2002),
    Anime("Attack on Titan", 9.0, 2013),
    Anime("Death Note", 8.5, 2006)
]

# Using SortByRatings strategy
context = AnimeListContext(sort_by_ratings)
sorted_list = context.sort_anime(anime_list)
print(f"Sorted by ratings: {sorted_list}")

# Using SortByYear strategy
context.set_strategy(sort_by_year)
sorted_list = context.sort_anime(anime_list)
print(f"Sorted by year: {sorted_list}")
