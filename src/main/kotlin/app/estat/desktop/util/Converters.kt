package app.estat.desktop.util

import org.joda.time.DateTime
import java.time.*
import java.util.*

fun LocalDate.toDateTime(): DateTime {
    val date = Date.from(atStartOfDay()
            .atZone(ZoneId.systemDefault())
            .toInstant())

    return DateTime(date)
}

fun DateTime.toLocalTime(): LocalTime? {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(toInstant().millis), ZoneId.systemDefault()).toLocalTime()
}