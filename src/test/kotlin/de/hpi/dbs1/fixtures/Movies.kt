package de.hpi.dbs1.fixtures

import de.hpi.dbs1.entities.Movie

object Movies {
    @JvmField
    val WWS_1929 = Movie(
        "tt0020596",
        "The Wolf of Wall Street",
        1929,
        setOf("Drama")
    )

    @JvmField
    val WWS_2013 = Movie(
        "tt0993846",
        "The Wolf of Wall Street",
        2013,
        setOf("Crime", "Biography", "Comedy")
    )

    @JvmField
    val WIB_2009 = Movie(
        "tt22502636",
        "Willkommen in Berlin",
        2009,
        setOf("Documentary")
    )

    @JvmField
    val ANH_1977 = Movie(
        "tt0076759",
        "Star Wars: Episode IV - A New Hope",
        1977,
        setOf("Action", "Adventure", "Fantasy")
    )

    @JvmField
    val RTT_2007 = Movie(
        "tt0382932",
        "Ratatouille",
        2007,
        setOf("Adventure", "Animation", "Comedy")

    )

    @JvmField
    val GITS_1995 = Movie(
        "tt0113568",
        "Ghost in the Shell",
        1995,
        setOf("Animation", "Crime", "Action")
    ).apply {
        actorNames.addAll(
            listOf(
                "Akio Ôtsuka",
                "Atsuko Tanaka",
                "Iemasa Kayumi",
                "Kôichi Yamadera",
                "Masato Yamanouchi",
                "Namaki Masakazu",
                "Shinji Ogawa",
                "Tamio Ôki",
                "Tesshô Genda",
                "Yutaka Nakano"
            )
        )
    }

    @JvmField
    val GITS_TNM_2015 = Movie(
        "tt4337072",
        "Ghost in the Shell: The New Movie",
        2015,
        setOf("Animation", "Sci-Fi", "Action")
    ).apply {
        actorNames.addAll(
            listOf(
                "Ikkyû Jaku",
                "Kazuya Nakai",
                "Ken'ichirô Matsuda",
                "Kenji Nojima",
                "Maaya Sakamoto",
                "Mayumi Asano",
                "Megumi Han",
                "Miyuki Sawashiro",
                "Mugihito",
                "Naoto"
            )
        )
    }
}
