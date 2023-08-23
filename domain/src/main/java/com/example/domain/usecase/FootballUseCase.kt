package com.example.domain.usecase

import com.example.domain.repository.FootballRepository
import java.sql.DataTruncation

class FootballUseCase(private val repository: FootballRepository) {

    operator fun invoke(){
        repository.getCountry(country = String())
        repository.getPastGame(name = String())
        repository.getUpcoming(name = String())
        repository.getRating()
        repository.getPlayer(country = String())
    }
}