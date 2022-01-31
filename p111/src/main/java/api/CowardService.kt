package api
import model.EarthQuakeDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CowardService {
    @GET("quake?")
    fun getQuakeAlert(
        @Query("MMI") MMI: Int,
    ): Call<EarthQuakeDto>
}