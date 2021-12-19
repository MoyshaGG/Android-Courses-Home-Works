package com.mysliukserhii.p101.ChatStorage

import android.content.Context
import com.mysliukserhii.p101.Chat
import com.mysliukserhii.p101.R
import kotlin.random.Random


object ChatStorage {

    private val avatars = listOf<Int>(R.drawable.cat1,
        R.drawable.cat2,R.drawable.cat3,R.drawable.cat4,R.drawable.cat5)
    private val messages = listOf<String>(
        "Коты – это ценнейший ресурс. Они уют вырабатывают.",
        "Человек культурен настолько, насколько он способен понять кошку.",
        "Когда все люди будут такими, как коты в два часа дня, мир достигнет совершенства.",
        "Любить кошку можно только на ее условиях. ",
        "Кошка выбирает себе хозяина, и никак иначе. ",
        "Тот, кто не может понять свою кошку, не может понять вообще ничего.",
        "С эстетической точки зрения, в мире существует только две идеальные вещи: часы и кошки."
    )
    fun random(context: Context) = MutableList(10000) {
        Chat(it,avatars[Random.nextInt(0,5)],
            DummyNameStorage.random(),
            messages[Random.nextInt(0,7)],
            "10:45 PM",
            Random.nextBoolean()
        )
    }

}