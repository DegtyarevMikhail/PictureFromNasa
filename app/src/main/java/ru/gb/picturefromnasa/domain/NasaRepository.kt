package ru.gb.picturefromnasa.domain


import ru.gb.picturefromnasa.api.PictureOfTheDayResponse

interface NasaRepository {

    suspend fun pictureOfTheDay(): PictureOfTheDayResponse
}