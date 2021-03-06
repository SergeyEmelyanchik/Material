package ru.geekbrains.material.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.geekbrains.material.BuildConfig
import ru.geekbrains.material.repository.PictureOfTheDayResponseData
import ru.geekbrains.material.repository.PictureOfTheDayRetrofitImpl

class PictureOfTheDayViewModel(
    private val liveDataForViewToObserve: MutableLiveData<PictureOfTheDayAppState> = MutableLiveData(),
    private val retrofitImpl: PictureOfTheDayRetrofitImpl = PictureOfTheDayRetrofitImpl()
) : ViewModel() {
    fun getLiveData(): LiveData<PictureOfTheDayAppState> {
        return liveDataForViewToObserve
    }

    fun sendServerRequest() {
        liveDataForViewToObserve.value = PictureOfTheDayAppState.Loading(0)
        val apiKey: String = BuildConfig.NASA_API_KEY
        if (apiKey.isBlank()) {
            liveDataForViewToObserve.value = PictureOfTheDayAppState.Error(Throwable("wrong key"))
        } else {
            retrofitImpl.getRetrofit().getPictureOfTheDay(apiKey).enqueue(callback)
        }
    }

    fun sendServerRequest(date:String) {
        liveDataForViewToObserve.value = PictureOfTheDayAppState.Loading(0)
        val apiKey: String = BuildConfig.NASA_API_KEY
        if (apiKey.isBlank()) {
            liveDataForViewToObserve.value = PictureOfTheDayAppState.Error(Throwable("wrong key"))
        } else {
            retrofitImpl.getRetrofit().getPictureOfTheDay(apiKey,date).enqueue(callback)
        }
    }

    private val callback = object : Callback<PictureOfTheDayResponseData> {
        override fun onResponse(
            call: Call<PictureOfTheDayResponseData>,
            response: Response<PictureOfTheDayResponseData>
        ) {
            if (response.isSuccessful) {
                response.body()?.let {
                    liveDataForViewToObserve.postValue(PictureOfTheDayAppState.Success(it))
                }
            } else {
                // TODO HW
            }
        }

        override fun onFailure(call: Call<PictureOfTheDayResponseData>, t: Throwable) {
            // TODO HW
        }
    }
}