package de.hpi.dbs1.fixtures

import de.hpi.dbs1.entities.Actor

object Actors {
    @JvmField
    val ANNE_HATHAWAY = Actor("nm0004266", "Anne Hathaway").apply {
        playedIn.addAll(
            listOf(
                "Mothers' Instinct",
                "The Idea of You",
                "She Came to Me",
                "Armageddon Time",
                "Locked Down",
            )
        )
        costarNameToCount.putAll(
            mapOf(
                "Hector Elizondo" to 3,
                "Helena Bonham Carter" to 3,
                "Heather Matarazzo" to 2,
                "Jeremy Strong" to 2,
                "Jesse Eisenberg" to 2,
            )
        )
    }

    @JvmField
    val MORGAN_FREEMAN = Actor("nm0000151", "Morgan Freeman").apply {
        playedIn.addAll(
            listOf(
                "My Dead Friend Zoe",
                "57 Seconds",
                "A Good Person",
                "The Ritual Killer",
                "Paradise Highway",
            )
        )
        costarNameToCount.putAll(
            mapOf(
                "Michael Caine" to 5,
                "Aaron Eckhart" to 4,
                "Ashley Judd" to 4,
                "Bruce Willis" to 3,
                "Cary Elwes" to 3,
            )
        )
    }
    @JvmField
    val FREEMAN_WOOD = Actor("nm0939706", "Freeman Wood")
    @JvmField
    val KATHLEEN_FREEMAN = Actor("nm0293466", "Kathleen Freeman")
    @JvmField
    val HOWARD_FREEMAN = Actor("nm0293418", "Howard Freeman")
    @JvmField
    val MONA_FREEMAN = Actor("nm0293530", "Mona Freeman")

    @JvmField
    val DIEGO_LUNA = Actor("nm0526019", "Diego Luna").apply{
        playedIn.addAll(
            listOf(
                "DC League of Super-Pets",
                "Wander Darkly",
                "Berlin, I Love You",
                "Flatliners",
                "Blood Father"
            )
        )
        costarNameToCount.putAll(
            mapOf(
                "Gael García Bernal" to 4,
                "José María Yazpik" to 4,
                "Jesús Ochoa" to 3,
                "Juan Carlos Colombo" to 3,
                "Alfredo Alfonso" to 2
            )
        )
    }

    @JvmField
    val DIEGO_LUNA_ACTORS_ONLY = Actor("nm0526019", "Diego Luna").apply {
        playedIn.addAll(
            listOf(
                "DC League of Super-Pets",
                "Wander Darkly",
                "Berlin, I Love You",
                "Flatliners",
                "Blood Father"
            )
        )
        costarNameToCount.putAll(
            mapOf(
                "Gael García Bernal" to 3,
                "Jesús Ochoa" to 3,
                "Juan Carlos Colombo" to 3,
                "Alfredo Alfonso" to 2,
                "Alice Braga" to 2
            )
        )
    }

    @JvmField
    val ALVARO_LUNA = Actor("nm0209968", "Álvaro de Luna")
    @JvmField
    val MANUEL_LUNA = Actor("nm0209963", "Manuel Luna")
    @JvmField
    val CONSUELO_LUNA = Actor("nm0346141", "Consuelo Guerrero de Luna")
    @JvmField
    val LUNA_MAYA = Actor("nm2532164", "Luna Maya")

    @JvmField
    val JACK_BLACK = Actor("nm0085312", "Jack Black").apply {
        playedIn.addAll(
            listOf(
                "Borderlands",
                "Kung Fu Panda 4",
                "Free LSD",
                "The Super Mario Bros. Movie",
                "Apollo 10¢: A Space Age Childhood"
            )
        )
        costarNameToCount.putAll(
            mapOf(
                "Angelina Jolie" to 4,
                "David Cross" to 4,
                "Dustin Hoffman" to 4,
                "Andy Dick" to 3,
                "Ben Stiller" to 3
            )
        )
    }

    @JvmField
    val JACK_BLACK2 = Actor("nm4795107", "Jack Black").apply {
        playedIn.addAll(
            listOf("Treasures from the Rubble")
        )
        costarNameToCount.putAll(
            mapOf(
                "Alexandra Branyon" to 1,
                "Billie Wilson May" to 1,
                "Jimmy Lee Sudduth" to 1,
                "Margaret Kitchings" to 1
            )
        )
    }
}
