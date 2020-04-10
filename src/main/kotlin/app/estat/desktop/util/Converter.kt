package app.estat.desktop.util

import org.joda.time.DateTime
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

fun LocalDate.dateTime(): DateTime {
    val date = Date.from(atStartOfDay()
            .atZone(ZoneId.systemDefault())
            .toInstant())

    return DateTime(date)
}

fun DateTime.localDate(): LocalDate {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(toInstant().millis), ZoneId.systemDefault()).toLocalDate()
}