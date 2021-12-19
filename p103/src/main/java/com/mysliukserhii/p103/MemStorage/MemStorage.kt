package com.mysliukserhii.p103.MemStorage

import com.mysliukserhii.p103.R
import com.mysliukserhii.p103.VkMemAdapter
import com.mysliukserhii.p103.VkMemData
import kotlin.random.Random

object MemStorage {
    private val memImage = listOf<Int>(R.drawable.mem1,R.drawable.mem2,R.drawable.mem3,R.drawable.mem4,R.drawable.mem5,
    R.drawable.mem6,R.drawable.mem7,R.drawable.mem8,R.drawable.mem9,R.drawable.mem10,R.drawable.mem11,R.drawable.mem12)
    private val publicAvatar = listOf<Int>(R.drawable.catpub1,R.drawable.catpub2,R.drawable.catpub3,R.drawable.catpub4)
    private val nameMemPublic = listOf<String>("FunnyCats","CoolCats","OnlyCats","CuteCats","TopCats")



    fun getRandomRecept() : MutableList<VkMemData>
    {

        return MutableList(300) {
             val comments = Random.nextInt(10,100)
             val hours = Random.nextInt(10,24)
             val minutes = Random.nextInt(10,60)
             val likes = Random.nextInt(100,1000)
             val  date = "Сегодня в "+"$hours" +":"+ "$minutes"
            val public = Random.nextInt(0,4)

            VkMemData(memImage[Random.nextInt(0,12)],
                publicAvatar[public],
                nameMemPublic[public],
                date, comments.toString(), likes.toString())
        }
    }
}