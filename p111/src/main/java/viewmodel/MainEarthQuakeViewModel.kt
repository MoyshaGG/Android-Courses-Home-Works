package viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import api.CowardService
import mapper.EarthQuakeMapper
import model.EarthQuakeDto
import model.FeatureDto
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import ui.model.EarthQuakeDvo

class MainEarthQuakeViewModel : ViewModel() {
    private val covardService = initServer()

    private val _earthquakeLiveData = MutableLiveData<EarthQuakeDto>()
    val earthquakeLiveData: LiveData<EarthQuakeDto> = _earthquakeLiveData
    lateinit var earthquakeDvoLiveData: List<EarthQuakeDvo>

    init {
        getEarthQuake()
    }

    private fun getEarthQuake() {
        covardService
            .getQuakeAlert(3)
            .enqueue(object : Callback<EarthQuakeDto> {

                override fun onResponse(
                    call: Call<EarthQuakeDto>,
                    response: Response<EarthQuakeDto>
                ) {
                    _earthquakeLiveData.value = response.body()
                    earthquakeDvoLiveData = EarthQuakeMapper(earthquakeLiveData.value!!).map()
                }

                override fun onFailure(call: Call<EarthQuakeDto>, t: Throwable) {
                }
            })
    }

    private fun initServer() = Retrofit.Builder()
        .baseUrl("https://api.geonet.org.nz")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(CowardService::class.java)
}