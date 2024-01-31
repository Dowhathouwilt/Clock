package com.example.myapplication.model

import androidx.annotation.StringRes
import androidx.room.Entity
import com.example.myapplication.R


enum class Repeat(
    @StringRes val repeatName: Int,
    val day: Int
) {
    Monday(
        day = 1,
        repeatName = R.string.repeat_mondays
    ),
    Tuesday(
        day = 2,
        repeatName = R.string.repeat_tuesday
    ),
    Wednesday(
        day = 3,
        repeatName = R.string.repeat_wednesday
    ),
    Thursday(
        day = 4,
        repeatName = R.string.repeat_thursday
    ),
    Friday(
        day = 5,
        repeatName = R.string.repeat_friday
    ),
    Saturday(
        day = 6,
        repeatName = R.string.repeat_saturday
    ),
    Sunday(
        day = 7,
        repeatName = R.string.repeat_sunday
    )
}