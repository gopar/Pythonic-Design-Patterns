import java.util.*

// Strategy Interface
interface AnimeSortingStrategy {
    fun sort(animeList: Array<Anime>)
}

// Strategy 1: Sort by Ratings
class SortByRatings : AnimeSortingStrategy {
    override fun sort(animeList: Array<Anime>) {
        animeList.sortByDescending { it.rating }
        println("Sorted by ratings")
    }
}

// Strategy 2: Sort by Release Year
class SortByYear : AnimeSortingStrategy {
    override fun sort(animeList: Array<Anime>) {
        animeList.sortByDescending { it.year }
        println("Sorted by release year")
    }
}

// Anime class
data class Anime(val name: String, val rating: Double, val year: Int)

// Context
class AnimeListContext {
    lateinit var strategy: AnimeSortingStrategy

    fun setStrategy(strategy: AnimeSortingStrategy) {
        this.strategy = strategy
    }

    fun sortAnime(animeList: Array<Anime>) {
        strategy.sort(animeList)
    }
}

fun main() {
    val animeList = arrayOf(
        Anime("Naruto", 7.5, 2002),
        Anime("Attack on Titan", 9.0, 2013),
        Anime("Death Note", 9.5, 2006)
    )

    val context = AnimeListContext()

    // Sort by Ratings
    context.setStrategy(SortByRatings())
    context.sortAnime(animeList)
    println(animeList.joinToString { it.toString() })

    // Sort by Release Year
    context.setStrategy(SortByYear())
    context.sortAnime(animeList)
    println(animeList.joinToString { it.toString() })
}
