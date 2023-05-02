package co.proexe.data.infrastructure

import android.widget.ImageView
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

fun ImageView.loadImage(url: String) {
    Glide.with(context)
        .load(url)
        .into(this@loadImage)
}

fun Date.convertToString(): String {
    val localTimeZone = TimeZone.getDefault()
    val outputDateFormat = SimpleDateFormat("HH:mm")
    outputDateFormat.timeZone = localTimeZone
    val localTime = outputDateFormat.format(this)

    return localTime
}