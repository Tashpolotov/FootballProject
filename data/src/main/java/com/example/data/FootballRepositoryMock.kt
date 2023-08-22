package com.example.data

import com.example.domain.model.*
import com.example.domain.repository.FootballRepository
import java.util.ArrayList


class FootballRepositoryMock():FootballRepository {
    override fun getCountry(country: String): List<CountryModel> {
        return listOf(
            CountryModel("1",
                listOf("Group A"), listOf("A1", "A2", "A3", "A4"), listOf(
                    R.drawable.qatar, R.drawable.ecuador,
                    R.drawable.ecuador, R.drawable.ecuador,
                ), listOf("Germany", "England", "Kyrgyzstan", "France")

            ),
            CountryModel("2",
                listOf("Group B"), listOf("B1", "B2", "B3", "B4"), listOf(
                    R.drawable.ecuador, R.drawable.ecuador,
                    R.drawable.qatar, R.drawable.qatar
                ), listOf("Poland", "Brazil", "Spain", "Italy")

            )
        )
    }

    override fun getPlayer(country: String): List<PlayerModel> = when(country){
        "Germany"-> listOf(PlayerModel(
            listOf(4, 8, 6, 5), listOf("aza", "beka", "4ika", "nurba"), listOf(22, 18, 26, 30),
            listOf(R.drawable.img_player_fragment, R.drawable.img_player_fragment, R.drawable.img_player_fragment,
                R.drawable.img_player_fragment) , listOf(R.drawable.qatar, R.drawable.qatar, R.drawable.qatar, R.drawable.ecuador) ,
            "Germany"
        ))

        "England"-> listOf(PlayerModel(
            listOf(4, 8, 6, 5), listOf("asdds", "qwe", "dsazx", "dsaw"), listOf(22, 18, 26, 30),
            listOf(R.drawable.img_player_fragment, R.drawable.img_player_fragment, R.drawable.img_player_fragment,
                R.drawable.img_player_fragment) , listOf(R.drawable.qatar, R.drawable.qatar, R.drawable.qatar, R.drawable.ecuador) ,
            "England"
        ))

        "France"-> listOf(PlayerModel(
            listOf(4, 8, 6, 5), listOf("ccc", "qqqqq", "ddddd", "rrrrrr"), listOf(22, 18, 26, 30),
            listOf(R.drawable.img_player_fragment, R.drawable.img_player_fragment, R.drawable.img_player_fragment,
                R.drawable.img_player_fragment) , listOf(R.drawable.qatar, R.drawable.qatar, R.drawable.qatar, R.drawable.ecuador) ,
            "France"
        ))

        "Kyrgyzstan" -> listOf(PlayerModel(
            listOf(4, 8, 6, 5), listOf("tttt", "4654dsa", "78945", "1123156"), listOf(22, 18, 26, 30),
            listOf(R.drawable.img_player_fragment, R.drawable.img_player_fragment, R.drawable.img_player_fragment,
                R.drawable.img_player_fragment) , listOf(R.drawable.qatar, R.drawable.qatar, R.drawable.qatar, R.drawable.ecuador) ,
            "Kyrgyzstan3e"
        ))

        else -> emptyList()
    }

    override fun getPastGame(name: String): List<PasteGameModel> {
        return listOf(PasteGameModel(
            1, "18.02.2023", "18:00","Italy",
        "England", R.drawable.qatar, R.drawable.ecuador, 1, 2, 4
                , 2, 1, 8, 2, 0, 0, 0),
            PasteGameModel(
                2, "18.02.2023", "21:00","Spain",
                "Senegal", R.drawable.qatar, R.drawable.ecuador, 7, 2, 1
            , 2, 12, 4, 5, 1, 1, 0)
        )
    }

    override fun getUpcoming(name: String): List<UpcomingModel> {
        return listOf(
            UpcomingModel(
            1, "20.02.2023", "18:00", "Russia", "Brazil", R.drawable.qatar,
            R.drawable.qatar, "Azamat", R.drawable.qatar, "Alai", "Qatar", 80000
            ),
            UpcomingModel(
                1, "20.02.2023", "19:00", "Spain", "Poland", R.drawable.qatar,
                R.drawable.qatar, "Azamat", R.drawable.qatar, "Poland", "Qatar", 66000
        ))
    }

    override fun getRating(): List<RatingModel> {
        return listOf(
            RatingModel(
            1, R.drawable.qatar, "Qatar", 100
        ),
            RatingModel(
                2, R.drawable.qatar, "Russia", 99
        ),
            RatingModel(
                3, R.drawable.qatar, "Spain", 98
            ),
            RatingModel(
                4, R.drawable.qatar, "Germany", 97
            ),
            RatingModel(
                5, R.drawable.qatar, "Brasil", 96
            ),
            RatingModel(
                6, R.drawable.qatar, "Italy", 95
            ),

            )
    }
}