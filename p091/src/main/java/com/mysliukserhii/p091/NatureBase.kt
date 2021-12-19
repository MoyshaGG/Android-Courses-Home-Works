package com.mysliukserhii.p091

class NatureBase {

     val natureElements = listOf(
        Nature(R.id.menu_animal1, R.drawable.bear,"Это медведь" ),
        Nature(R.id.menu_animal2, R.drawable.olen, "Это олень" ),
        Nature(R.id.menu_animal3, R.drawable.wolf, "Это вівк" ),
        Nature(R.id.menu_bird1, R.drawable.sparrow, "Это воробей" ),
        Nature(R.id.menu_bird2, R.drawable.orel, "Это орел" ),
        Nature(R.id.menu_bird3, R.drawable.duck, "Это утка" )
    )
    fun getNatureElementById(id: Int?): Nature? {
        return natureElements.find { it.id == id }
    }

}