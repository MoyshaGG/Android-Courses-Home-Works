package com.mysliukserhii.p091

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    private val natureBase: NatureBase = NatureBase()
    private val _natureLiveData = MutableLiveData<Nature>()
    val natureLiveData : LiveData<Nature> = _natureLiveData

        fun loadNatureData(id:Int?){
            val natureElements = natureBase.getNatureElementById(id)
            natureElements?.let{_natureLiveData.value   = it}

    }
}