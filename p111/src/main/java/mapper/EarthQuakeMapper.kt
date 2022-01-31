package mapper

import com.mysliukserhii.p111.Magnitude
import com.mysliukserhii.p111.R
import model.EarthQuakeDto
import ui.model.EarthQuakeDvo
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class EarthQuakeMapper(private val earthQuakeDto: EarthQuakeDto) {
    fun simpleDateFormat(time: String)
    {
        val currentDate = DateFormat.getDateInstance().format(Calendar.getInstance().time)
        var formatter =  SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z")

    }
    fun map(): List<EarthQuakeDvo> {
        return earthQuakeDto.features.map {
            var dtoTime = it.properties.time

            EarthQuakeDvo(
                it.properties.time, //TODO доделать и упростить
                it.properties.locality,
                Magnitude.getMagnitude(it.properties.magnitude).title,
                Magnitude.getMagnitude(it.properties.magnitude).color,
                it.properties.magnitude.toString()
            )
        }
    }
}