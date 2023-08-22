package com.example.footballproject.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.FootballRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.ArrayList
import javax.inject.Inject

@HiltViewModel
class FootballViewModel @Inject constructor(val repository: FootballRepository):ViewModel() {

    private val _football = MutableStateFlow(State())
    val football : StateFlow<State> = _football


    fun loadRating() {
        viewModelScope.launch {
            val rating = repository.getRating()
            _football.value = _football.value.copy(rating = rating)
        }
    }

    fun loadUpcoming(name: String){
        viewModelScope.launch {
            val upcomingGame = repository.getUpcoming(name)
            _football.value = _football.value.copy(upcoming = upcomingGame)
        }
    }

    fun loadPastGame(name:String){
        viewModelScope.launch {
            val pastGame = repository.getPastGame(name)
            _football.value = _football.value.copy(pastGame = pastGame)
        }
    }

    fun loadPlayer(country: String) {
        Log.d("FootballViewModel", "Loading player data for country: $country")
        viewModelScope.launch {
            val players = repository.getPlayer(country)
            _football.value = _football.value.copy(player = players)
        }
    }

    fun loadCountry(country:String) {
        viewModelScope.launch {
            val country = repository.getCountry(country)
            _football.value = _football.value.copy(country = country)
        }
    }


}