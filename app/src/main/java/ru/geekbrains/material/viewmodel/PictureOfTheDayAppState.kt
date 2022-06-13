package ru.geekbrains.material.viewmodel

import ru.geekbrains.material.repository.PictureOfTheDayResponseData

sealed class PictureOfTheDayAppState{
    data class Success(val pictureOfTheDayResponseData: PictureOfTheDayResponseData):PictureOfTheDayAppState()
    data class Error(val error:Throwable):PictureOfTheDayAppState()
    data class Loading(val progress:Int?):PictureOfTheDayAppState()
}