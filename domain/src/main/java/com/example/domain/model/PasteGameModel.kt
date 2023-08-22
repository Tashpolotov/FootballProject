package com.example.domain.model

data class PasteGameModel (
    val id:Int,
    val date:String,
    val time:String,
    val countryName1:String,
    val countryName2:String,
    val imgCountry1:Int,
    val imgCountry2:Int,
    val team1Score:Int,
    val team2Score:Int,
    val team1Corner:Int,
    val team2Corner:Int,
    val team1Attack:Int,
    val team2Attack:Int,
    val team1YellowCard:Int,
    val team2YellowCard:Int,
    val team1Penalties:Int,
    val team2Penalties:Int,
        )