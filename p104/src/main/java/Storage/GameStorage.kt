package Storage

import com.mysliukserhii.p104.GameData
import com.mysliukserhii.p104.R
import kotlin.random.Random

object GameStorage {
    private val gameImage = listOf<Int>(R.drawable.witcher,R.drawable.cyberpunk,
    R.drawable.division,R.drawable.arma, R.drawable.borderlands,R.drawable.fallout,
    R.drawable.reddead,R.drawable.skyrim,R.drawable.resident,R.drawable.starbound,
    R.drawable.rust,R.drawable.sniper,R.drawable.deadcells,R.drawable.insurgency)

    private val nameGame = listOf<String>("Witcher 3: Wild Hunt","Cyberpunk 2077",
    "The Division","ARMA 4","Borderlands","Fallout 4","Red Dead 2","Skyrim","Resident Evil",
        "Starbound", "Rust", "Sniper Elite", "Dead Cells","Insurgency" )

    private val date = listOf<String>("12 МАЯ 2015","10 ДЕК 2020","6 МАР 2016","10 НОЯ 2006",
        "20 ОКТ 2009","10 НОЯ 2015","26 ОКТ 2018","11 НОЯ 2011","5 МАР 2009","22 ИЮЛ 2016",
    "11 ДЕК 2013","29 СЕН 2005","10 МАЯ 2017","12 ДЕК 2018")

    private val price = listOf<String>("112","599","849","450","245","349","699","139","449","99","499","299","144","189")

    fun getRandomRecept() : MutableList<GameData>
    {
        return MutableList(300) {
            val count = Random.nextInt(0,14)
            GameData(gameImage[count],nameGame[count],date[count],price[count])
        }
    }
}