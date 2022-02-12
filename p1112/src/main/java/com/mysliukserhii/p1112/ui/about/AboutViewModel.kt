package com.mysliukserhii.p1112.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Геологічна служба США (USGS) у співпраці з державними установами, партнерами з університетів та приватною промисловістю розробляє систему раннього попередження про землетруси (EEW) для західного узбережжя Сполучених Штатів під назвою ShakeAlert. Програма землетрусів USGS спрямована на пом’якшення втрат від землетрусу в Сполучених Штатах. Громадяни, служби швидкого реагування та інженери покладаються на USGS для отримання точної та своєчасної інформації про те, де відбуваються землетруси, інтенсивність поштовхів землі в різних місцях, а також ймовірність значного потрясіння землі в майбутньому."
    }
    val text: LiveData<String> = _text
}