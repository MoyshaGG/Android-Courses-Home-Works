package viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import model.EarthQuakeDto
import androidx.lifecycle.ViewModel

class DetailsRecommendationsFragmentViewModel: ViewModel() {

    private val _earthquakeLiveData = MutableLiveData<EarthQuakeDto>()
    val earthquakeLiveData: LiveData<EarthQuakeDto> = _earthquakeLiveData
}