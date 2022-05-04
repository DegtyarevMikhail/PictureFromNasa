package ru.gb.picturefromnasa.domain


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.gb.picturefromnasa.api.NasaApi
import ru.gb.picturefromnasa.api.PictureOfTheDayResponse

class NasaRepositoryImpl : NasaRepository {


    private val api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.nasa.gov/")
        .client(OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
            .build()
        )
        .build()
        .create(NasaApi::class.java)


    override suspend fun pictureOfTheDay(): PictureOfTheDayResponse = api.pictureOfTheDay("KqNLF4mgINJPbYEiGuTEYV57vEIjGxDiZCpiWm0u")


}