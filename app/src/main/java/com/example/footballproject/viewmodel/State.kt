package com.example.footballproject.viewmodel

import com.example.domain.model.*


data class State (

    val country : List<CountryModel> = emptyList(),
    val player : List<PlayerModel> = emptyList(),
    val pastGame:List<PasteGameModel> = emptyList(),
    val upcoming:List<UpcomingModel> = emptyList(),
    val rating:List<RatingModel> = emptyList(),
        )