package com.example.data

import com.example.domain.model.*
import com.example.domain.repository.FootballRepository
import java.util.ArrayList


class FootballRepositoryMock():FootballRepository {
        override fun getCountry(country: String): List<CountryModel> {
            return listOf(
                CountryModel("England", "1", "A", "A1", R.drawable.england, "England"),
                CountryModel("France", "1", "A", "A2", R.drawable.france, "France"),
                CountryModel("Croatia", "1", "A", "A3", R.drawable.croatia, "Croatia"),
                CountryModel("Spain","1", "A", "A4", R.drawable.spain, "Spain"),
                CountryModel("Senegal", "1", "B", "B1", R.drawable.senegal, "Senegal"),
                CountryModel("Brazil", "6", "B", "B2", R.drawable.brazil, "Brazil"),
                CountryModel("Germany", "7", "B", "B3", R.drawable.germany, "Germany"),
                CountryModel("Argentina", "8", "B", "B4", R.drawable.argentina, "Argentina"),
                CountryModel("Portugal", "9", "C", "C1", R.drawable.portugal, "Portugal"),
                CountryModel("Netherlands", "10", "C", "C2", R.drawable.nederlan, "Netherlands"),
                CountryModel("Belgium", "11", "C", "C3", R.drawable.belgium, "Belgium"),
                CountryModel("Serbia", "12", "C", "C4", R.drawable.serbia, "Serbia"),
                CountryModel("Uruguay", "13", "D", "D1", R.drawable.uruguai, "Uruguay"),
                CountryModel("Morocco", "14", "D", "D2", R.drawable.morokko, "Morocco"),
                CountryModel("Japan", "15", "D", "D3", R.drawable.japan, "Japan"),
                CountryModel("Qatar", "16", "D", "D4", R.drawable.qatar, "Qatar"),
                CountryModel("Japan", "15", "D", "D3", R.drawable.japan, "Japan"),
                CountryModel("Qatar", "16", "D", "D4", R.drawable.qatar, "Qatar"),

        )
    }

    override fun getPlayer(country: String): List<PlayerModel> = when(country) {

        "Qatar" -> {
            listOf(
                PlayerModel(10, "Akram Afif", 24, R.drawable.qatar, R.drawable.qatar, "Qatar"),
                PlayerModel(7, "Hassan Al-Haydos", 31, R.drawable.qatar, R.drawable.qatar, "Qatar"),
                PlayerModel(9, "Almoez Ali", 24, R.drawable.qatar, R.drawable.qatar, "Qatar"),
                PlayerModel(14, "Karim Boudiaf", 31, R.drawable.qatar, R.drawable.qatar, "Qatar"),
                PlayerModel(16, "Boualem Khoukhi", 31, R.drawable.qatar, R.drawable.qatar, "Qatar"),
                PlayerModel(6, "Assim Madibo", 23, R.drawable.qatar, R.drawable.qatar, "Qatar"),
                PlayerModel(1, "Saad Al-Sheeb", 32, R.drawable.qatar, R.drawable.qatar, "Qatar"),
                PlayerModel(3, "Tarek Salman", 31, R.drawable.qatar, R.drawable.qatar, "Qatar"),
                PlayerModel(20, "Abdelkarim Hassan", 28, R.drawable.qatar, R.drawable.qatar, "Qatar"),
                PlayerModel(8, "Abdulaziz Hatem", 29, R.drawable.qatar, R.drawable.qatar, "Qatar")
            )
        }

        "Japan" -> {
            listOf(
                PlayerModel(10, "Shinji Kagawa", 32, R.drawable.japan, R.drawable.japan, "Japan"),
                PlayerModel(7, "Takumi Minamino", 26, R.drawable.japan, R.drawable.japan, "Japan"),
                PlayerModel(9, "Yuya Osako", 31, R.drawable.japan, R.drawable.japan, "Japan"),
                PlayerModel(14, "Genki Haraguchi", 30, R.drawable.japan, R.drawable.japan, "Japan"),
                PlayerModel(16, "Wataru Endo", 28, R.drawable.japan, R.drawable.japan, "Japan"),
                PlayerModel(6, "Hotaru Yamaguchi", 30, R.drawable.japan, R.drawable.japan, "Japan"),
                PlayerModel(1, "Eiji Kawashima", 39, R.drawable.japan, R.drawable.japan, "Japan"),
                PlayerModel(3, "Yuto Nagatomo", 34, R.drawable.japan, R.drawable.japan, "Japan"),
                PlayerModel(20, "Shoya Nakajima", 26, R.drawable.japan, R.drawable.japan, "Japan"),
                PlayerModel(8, "Gaku Shibasaki", 29, R.drawable.japan, R.drawable.japan, "Japan")
            )
        }

        "Morocco" -> {
            listOf(
                PlayerModel(7, "Hakim Ziyech", 28, R.drawable.morokko, R.drawable.morokko, "Morocco"),
                PlayerModel(9, "Youssef En-Nesyri", 24, R.drawable.morokko, R.drawable.morokko, "Morocco"),
                PlayerModel(18, "Achraf Hakimi", 23, R.drawable.morokko, R.drawable.morokko, "Morocco"),
                PlayerModel(14, "Romain Saiss", 31, R.drawable.morokko, R.drawable.morokko, "Morocco"),
                PlayerModel(16, "Noussair Mazraoui", 23, R.drawable.morokko, R.drawable.morokko, "Morocco"),
                PlayerModel(6, "Karim El Ahmadi", 36, R.drawable.morokko, R.drawable.morokko, "Morocco"),
                PlayerModel(1, "Munir Mohamedi", 33, R.drawable.morokko, R.drawable.morokko, "Morocco"),
                PlayerModel(3, "Hamza Mendyl", 24, R.drawable.morokko, R.drawable.morokko, "Morocco"),
                PlayerModel(20, "Amine Harit", 24, R.drawable.morokko, R.drawable.morokko, "Morocco"),
                PlayerModel(8, "Younes Belhanda", 31, R.drawable.morokko, R.drawable.morokko, "Morocco")
            )
        }

        "Uruguay" -> {
            listOf(
                PlayerModel(9, "Luis Suarez", 35, R.drawable.uruguai, R.drawable.uruguai, "Uruguay"),
                PlayerModel(21, "Edinson Cavani", 34, R.drawable.uruguai, R.drawable.uruguai, "Uruguay"),
                PlayerModel(10, "Giorgian De Arrascaeta", 27, R.drawable.uruguai, R.drawable.uruguai, "Uruguay"),
                PlayerModel(5, "Jose Gimenez", 26, R.drawable.uruguai, R.drawable.uruguai, "Uruguay"),
                PlayerModel(15, "Matias Vecino", 30, R.drawable.uruguai, R.drawable.uruguai, "Uruguay"),
                PlayerModel(6, "Rodrigo Bentancur", 24, R.drawable.uruguai, R.drawable.uruguai, "Uruguay"),
                PlayerModel(1, "Fernando Muslera", 35, R.drawable.uruguai, R.drawable.uruguai, "Uruguay"),
                PlayerModel(2, "Jose Maria Gimenez", 26, R.drawable.uruguai, R.drawable.uruguai, "Uruguay"),
                PlayerModel(14, "Nahitan Nandez", 26, R.drawable.uruguai, R.drawable.uruguai, "Uruguay"),
                PlayerModel(17, "Diego Laxalt", 28, R.drawable.uruguai, R.drawable.uruguai, "Uruguay")
            )
        }

        "Serbia" -> {
            listOf(
                PlayerModel(10, "Luka Jovic", 23, R.drawable.serbia, R.drawable.serbia, "Serbia"),
                PlayerModel(7, "Dusan Tadic", 32, R.drawable.serbia, R.drawable.serbia, "Serbia"),
                PlayerModel(9, "Aleksandar Mitrovic", 27, R.drawable.serbia, R.drawable.serbia, "Serbia"),
                PlayerModel(21, "Nemanja Gudelj", 30, R.drawable.serbia, R.drawable.serbia, "Serbia"),
                PlayerModel(3, "Nikola Milenkovic", 24, R.drawable.serbia, R.drawable.serbia, "Serbia"),
                PlayerModel(1, "Predrag Rajkovic", 26, R.drawable.serbia, R.drawable.serbia, "Serbia"),
                PlayerModel(5, "Uros Spajic", 28, R.drawable.serbia, R.drawable.serbia, "Serbia"),
                PlayerModel(11, "Filip Kostic", 29, R.drawable.serbia, R.drawable.serbia, "Serbia"),
                PlayerModel(8, "Sergej Milinkovic-Savic", 26, R.drawable.serbia, R.drawable.qatar, "Serbia"),
                PlayerModel(6, "Nemanja Matic", 33, R.drawable.serbia, R.drawable.serbia, "Serbia")
            )
        }

        "Belgium" -> {
            listOf(
                PlayerModel(9, "Romelu Lukaku", 28, R.drawable.belgium, R.drawable.belgium, "Belgium"),
                PlayerModel(7, "Kevin De Bruyne", 30, R.drawable.belgium, R.drawable.belgium, "Belgium"),
                PlayerModel(10, "Eden Hazard", 31, R.drawable.belgium, R.drawable.belgium, "Belgium"),
                PlayerModel(14, "Axel Witsel", 32, R.drawable.belgium, R.drawable.belgium, "Belgium"),
                PlayerModel(5, "Jan Vertonghen", 34, R.drawable.belgium, R.drawable.belgium, "Belgium"),
                PlayerModel(3, "Toby Alderweireld", 32, R.drawable.belgium, R.drawable.belgium, "Belgium"),
                PlayerModel(4, "Dries Mertens", 34, R.drawable.belgium, R.drawable.belgium, "Belgium"),
                PlayerModel(8, "Youri Tielemans", 24, R.drawable.belgium, R.drawable.belgium, "Belgium"),
                PlayerModel(6, "Leander Dendoncker", 26, R.drawable.belgium, R.drawable.belgium, "Belgium")
            )
        }

        "Netherlands" -> {
            listOf(
                PlayerModel(9, "Memphis Depay", 28, R.drawable.nederlan, R.drawable.nederlan, "Netherlands"),
                PlayerModel(7, "Quincy Promes", 30, R.drawable.nederlan, R.drawable.nederlan, "Netherlands"),
                PlayerModel(10, "Frenkie de Jong", 24, R.drawable.nederlan, R.drawable.nederlan, "Netherlands"),
                PlayerModel(14, "Davy Klaassen", 29, R.drawable.nederlan, R.drawable.nederlan, "Netherlands"),
                PlayerModel(5, "Georginio Wijnaldum", 31, R.drawable.nederlan, R.drawable.nederlan, "Netherlands"),
                PlayerModel(1, "Maarten Stekelenburg", 39, R.drawable.nederlan, R.drawable.nederlan, "Netherlands"),
                PlayerModel(3, "Stefan de Vrij", 29, R.drawable.nederlan, R.drawable.nederlan, "Netherlands"),
                PlayerModel(4, "Matthijs de Ligt", 22, R.drawable.nederlan, R.drawable.nederlan, "Netherlands"),
                PlayerModel(8, "Mart Donny van de Beek", 24, R.drawable.nederlan, R.drawable.nederlan, "Netherlands"),
                PlayerModel(6, "Owen Wijndal", 22, R.drawable.nederlan, R.drawable.nederlan, "Netherlands")
            )
        }

        "Portugal" -> {
            listOf(
                PlayerModel(7, "Cristiano Ronaldo", 37, R.drawable.portugal, R.drawable.portugal, "Portugal"),
                PlayerModel(10, "Bernardo Silva", 27, R.drawable.portugal, R.drawable.portugal, "Portugal"),
                PlayerModel(21, "João Cancelo", 27, R.drawable.portugal, R.drawable.portugal, "Portugal"),
                PlayerModel(11, "Diogo Jota", 24, R.drawable.portugal, R.drawable.portugal, "Portugal"),
                PlayerModel(6, "Rúben Neves", 24, R.drawable.portugal, R.drawable.portugal, "Portugal"),
                PlayerModel(1, "Rui Patrício", 33, R.drawable.portugal, R.drawable.portugal, "Portugal"),
                PlayerModel(4, "Rúben Dias", 24, R.drawable.portugal, R.drawable.portugal, "Portugal"),
                PlayerModel(14, "Danilo Pereira", 30, R.drawable.portugal, R.drawable.portugal, "Portugal"),
                PlayerModel(19, "João Palhinha", 26, R.drawable.portugal, R.drawable.portugal, "Portugal"),
                PlayerModel(8, "Bruno Fernandes", 27, R.drawable.portugal, R.drawable.portugal, "Portugal")
            )
        }

        "Argentina" -> {
            listOf(
                PlayerModel(10, "Lionel Messi", 34, R.drawable.argentina, R.drawable.argentina, "Argentina"),
                PlayerModel(7, "Ángel Di María", 33, R.drawable.argentina, R.drawable.argentina, "Argentina"),
                PlayerModel(9, "Sergio Agüero", 33, R.drawable.argentina, R.drawable.argentina, "Argentina"),
                PlayerModel(5, "Leandro Paredes", 27, R.drawable.argentina, R.drawable.argentina, "Argentina"),
                PlayerModel(14, "Nicolás González", 24, R.drawable.argentina, R.drawable.argentina, "Argentina"),
                PlayerModel(1, "Emiliano Martínez", 29, R.drawable.argentina, R.drawable.argentina, "Argentina"),
                PlayerModel(3, "Nicolás Otamendi", 33, R.drawable.argentina, R.drawable.argentina, "Argentina"),
                PlayerModel(11, "Giovani Lo Celso", 25, R.drawable.argentina, R.drawable.argentina, "Argentina"),
                PlayerModel(6, "Rodrigo De Paul", 27, R.drawable.argentina, R.drawable.argentina, "Argentina"),
                PlayerModel(18, "Guido Rodríguez", 27, R.drawable.argentina, R.drawable.argentina, "Argentina")
            )
        }

        "Germany" -> {
            listOf(
                PlayerModel(9, "Timo Werner", 26, R.drawable.germany, R.drawable.germany, "Germany"),
                PlayerModel(7, "Leroy Sané", 25, R.drawable.germany, R.drawable.germany, "Germany"),
                PlayerModel(10, "Serge Gnabry", 26, R.drawable.germany, R.drawable.germany, "Germany"),
                PlayerModel(8, "Joshua Kimmich", 27, R.drawable.germany, R.drawable.germany, "Germany"),
                PlayerModel(6, "Leon Goretzka", 27, R.drawable.germany, R.drawable.germany, "Germany"),
                PlayerModel(1, "Manuel Neuer", 35, R.drawable.germany, R.drawable.germany, "Germany"),
                PlayerModel(3, "Antonio Rüdiger", 28, R.drawable.germany, R.drawable.germany, "Germany"),
                PlayerModel(11, "Kai Havertz", 22, R.drawable.germany, R.drawable.germany, "Germany"),
                PlayerModel(13, "Matthias Ginter", 28, R.drawable.germany, R.drawable.germany, "Germany"),
                PlayerModel(18, "Thomas Müller", 32, R.drawable.germany, R.drawable.germany, "Germany")
            )
        }

        "Brazil" -> {
            listOf(
                PlayerModel(10, "Neymar Jr.", 29, R.drawable.brazil, R.drawable.brazil, "Brazil"),
                PlayerModel(9, "Gabriel Jesus", 24, R.drawable.brazil, R.drawable.brazil, "Brazil"),
                PlayerModel(7, "Douglas Costa", 31, R.drawable.brazil, R.drawable.brazil, "Brazil"),
                PlayerModel(5, "Casemiro", 29, R.drawable.brazil, R.drawable.brazil, "Brazil"),
                PlayerModel(8, "Arthur", 25, R.drawable.brazil, R.drawable.brazil, "Brazil"),
                PlayerModel(1, "Alisson Becker", 28, R.drawable.brazil, R.drawable.brazil, "Brazil"),
                PlayerModel(3, "Eder Militão", 23, R.drawable.brazil, R.drawable.brazil, "Brazil"),
                PlayerModel(20, "Vinicius Jr.", 21, R.drawable.brazil, R.drawable.brazil, "Brazil"),
                PlayerModel(22, "Weverton", 33, R.drawable.brazil, R.drawable.brazil, "Brazil"),
                PlayerModel(17, "Lucas Paquetá", 24, R.drawable.brazil, R.drawable.brazil, "Brazil")
            )
        }

        "Senegal" -> {
            listOf(
                PlayerModel(7, "Sadio Mané", 29, R.drawable.senegal, R.drawable.senegal, "Senegal"),
                PlayerModel(9, "Keita Baldé", 26, R.drawable.senegal, R.drawable.senegal, "Senegal"),
                PlayerModel(18, "Pape Abou Cissé", 26, R.drawable.senegal, R.drawable.senegal, "Senegal"),
                PlayerModel(5, "Idrissa Gueye", 31, R.drawable.senegal, R.drawable.senegal, "Senegal"),
                PlayerModel(8, "Cheikhou Kouyaté", 32, R.drawable.senegal, R.drawable.senegal, "Senegal"),
                PlayerModel(1, "Edouard Mendy", 29, R.drawable.senegal, R.drawable.senegal, "Senegal"),
                PlayerModel(3, "Kalidou Koulibaly", 30, R.drawable.senegal, R.drawable.senegal, "Senegal"),
                PlayerModel(20, "Ismaïla Sarr", 23, R.drawable.senegal, R.drawable.senegal, "Senegal"),
                PlayerModel(22, "Alfred Gomis", 28, R.drawable.senegal, R.drawable.senegal, "Senegal"),
                PlayerModel(10, "Mame Biram Diouf", 34, R.drawable.senegal, R.drawable.senegal, "Senegal")
            )
        }

        "Spain" -> {
            listOf(
                PlayerModel(10, "Sergio Ramos", 35, R.drawable.spain, R.drawable.spain, "Spain"),
                PlayerModel(21, "Ferran Torres", 21, R.drawable.spain, R.drawable.spain, "Spain"),
                PlayerModel(8, "Koke", 29, R.drawable.spain, R.drawable.spain, "Spain"),
                PlayerModel(1, "David de Gea", 30, R.drawable.spain, R.drawable.spain, "Spain"),
                PlayerModel(15, "Sergio Busquets", 33, R.drawable.spain, R.drawable.spain, "Spain"),
                PlayerModel(5, "Aymeric Laporte", 27, R.drawable.spain, R.drawable.spain, "Spain"),
                PlayerModel(7, "Gerard Moreno", 29, R.drawable.spain, R.drawable.spain, "Spain"),
                PlayerModel(22, "Pau Torres", 24, R.drawable.spain, R.drawable.spain, "Spain"),
                PlayerModel(9, "Álvaro Morata", 28, R.drawable.spain, R.drawable.spain, "Spain"),
                PlayerModel(20, "Marco Asensio", 25, R.drawable.spain, R.drawable.spain, "Spain")
            )
        }

        "England" -> {
            listOf(
                PlayerModel(1, "Harry Kane", 28, R.drawable.england, R.drawable.england, "England"),
                PlayerModel(2, "Raheem Sterling", 27, R.drawable.england, R.drawable.england, "England"),
                PlayerModel(3, "Mason Mount", 22, R.drawable.england, R.drawable.england, "England"),
                PlayerModel(4, "Jordan Henderson", 31, R.drawable.england, R.drawable.england, "England"),
                PlayerModel(5, "Jack Grealish", 26, R.drawable.england, R.drawable.england, "England"),
                PlayerModel(6, "Kalvin Phillips", 25, R.drawable.england, R.drawable.england, "England"),
                PlayerModel(7, "Kyle Walker", 31, R.drawable.england, R.drawable.england, "England"),
                PlayerModel(8, "John Stones", 27, R.drawable.england, R.drawable.england, "England"),
                PlayerModel(9, "Luke Shaw", 26, R.drawable.england, R.drawable.england, "England"),
                PlayerModel(10, "Phil Foden", 21, R.drawable.england, R.drawable.england, "England"),



            )
        }

        "France" -> {
            listOf(
                PlayerModel(7, "Antoine Griezmann", 30, R.drawable.france, R.drawable.france, "France"),
                PlayerModel(10, "Kylian Mbappé", 23, R.drawable.france, R.drawable.france, "France"),
                PlayerModel(13, "N'Golo Kanté", 30, R.drawable.france, R.drawable.france, "France"),
                PlayerModel(5, "Raphaël Varane", 28, R.drawable.france, R.drawable.france, "France"),
                PlayerModel(1, "Hugo Lloris", 34, R.drawable.france, R.drawable.france, "France"),
                PlayerModel(21, "Lucas Hernández", 25, R.drawable.france, R.drawable.france, "France"),
                PlayerModel(14, "Adrien Rabiot", 26, R.drawable.france, R.drawable.france, "France"),
                PlayerModel(2, "Benjamin Pavard", 25, R.drawable.france, R.drawable.france, "France"),
                PlayerModel(12, "Mike Maignan", 26, R.drawable.france, R.drawable.france, "France"),
                PlayerModel(6, "Paul Pogba", 28, R.drawable.france, R.drawable.france, "France")
            )
        }

        "Croatia" -> {
            listOf(
                PlayerModel(7, "Ivan Perišić", 32, R.drawable.croatia, R.drawable.croatia, "Croatia"),
                PlayerModel(10, "Luka Modrić", 35, R.drawable.croatia, R.drawable.croatia, "Croatia"),
                PlayerModel(4, "Ivan Rakitić", 33, R.drawable.croatia, R.drawable.croatia, "Croatia"),
                PlayerModel(3, "Borna Barišić", 29, R.drawable.croatia, R.drawable.croatia, "Croatia"),
                PlayerModel(1, "Dominik Livaković", 26, R.drawable.croatia, R.drawable.croatia, "Croatia"),
                PlayerModel(21, "Josip Juranović", 26, R.drawable.croatia, R.drawable.croatia, "Croatia"),
                PlayerModel(17, "Mario Pašalić", 26, R.drawable.croatia, R.drawable.croatia, "Croatia"),
                PlayerModel(2, "Šime Vrsaljko", 29, R.drawable.croatia, R.drawable.croatia, "Croatia"),
                PlayerModel(12, "Lovre Kalinić", 31, R.drawable.croatia, R.drawable.croatia, "Croatia"),
                PlayerModel(8, "Mateo Kovačić", 27, R.drawable.croatia, R.drawable.croatia, "Croatia")
            )
        }

        else-> emptyList()
    }


    override fun getPastGame(name: String): List<PasteGameModel> {
        return listOf(PasteGameModel(
            1, "18.02.2023", "18:00","Spain",
        "England", R.drawable.spain, R.drawable.england, 1, 2, 4
                , 2, 1, 8, 2, 0, 0, 0),
            PasteGameModel(
                2, "18.02.2023", "21:00","Brazil",
                "Senegal", R.drawable.brazil, R.drawable.senegal, 7, 2, 1
            , 2, 12, 4, 5, 1, 1, 0)
        )
    }

    override fun getUpcoming(name: String): List<UpcomingModel> {
        return listOf(
            UpcomingModel(
            1, "20.02.2023", "18:00", "Portugal", "Japan", R.drawable.portugal,
            R.drawable.japan, "Kolina", R.drawable.england, "Al-Bayt Stadium", "Qatar", 80000
            ),
            UpcomingModel(
                1, "20.02.2023", "19:00", "Germany", "Poland", R.drawable.germany,
                R.drawable.poland, " Javier Rodríguez", R.drawable.spain, "Qatar Arena", "Qatar", 66000
        ))
    }

    override fun getRating(): List<RatingModel> {
        return listOf(
            RatingModel(
            1, R.drawable.argentina, "Argentine", 100
        ),
            RatingModel(
                2, R.drawable.brazil, "England", 99
        ),
            RatingModel(
                3, R.drawable.spain, "Spain", 98
            ),
            RatingModel(
                4, R.drawable.germany, "Germany", 97
            ),
            RatingModel(
                5, R.drawable.england, "England", 96
            ),
            RatingModel(
                6, R.drawable.croatia, "Croatia", 95
            ),

            )
    }
}