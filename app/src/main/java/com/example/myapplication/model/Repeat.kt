package com.example.myapplication.model

import androidx.annotation.StringRes
import androidx.room.Entity
import com.example.myapplication.R


enum class Repeat(
    @StringRes val repeatName: Int,
    @StringRes val shortName: Int,
    val day: Int
) {
    Monday(
        day = 1,
        repeatName = R.string.repeat_mondays,
        shortName = R.string.short_mondays
    ),
    Tuesday(
        day = 2,
        repeatName = R.string.repeat_tuesday,
        shortName = R.string.short_tuesday
    ),
    Wednesday(
        day = 3,
        repeatName = R.string.repeat_wednesday,
        shortName = R.string.short_wednesday
    ),
    Thursday(
        day = 4,
        repeatName = R.string.repeat_thursday,
        shortName = R.string.short_thursday
    ),
    Friday(
        day = 5,
        repeatName = R.string.repeat_friday,
        shortName = R.string.short_friday
    ),
    Saturday(
        day = 6,
        repeatName = R.string.repeat_saturday,
        shortName = R.string.short_saturday
    ),
    Sunday(
        day = 7,
        repeatName = R.string.repeat_sunday,
        shortName = R.string.short_sunday
    )
}