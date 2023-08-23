package com.example.domain.repository

import com.example.domain.model.*
import java.util.ArrayList

interface FootballRepository {

    fun getCountry(country:String):List<CountryModel>


    fun getPastGame(name:String):List<PasteGameModel>

    fun getUpcoming(name:String):List<UpcomingModel>

    fun getPlayer(country: String):List<PlayerModel>

    fun getRating():List<RatingModel>
}