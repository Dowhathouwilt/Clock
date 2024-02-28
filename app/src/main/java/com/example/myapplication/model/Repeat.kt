package com.example.myapplication.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.room.Entity
import com.example.myapplication.R


enum class Repeat(
    @StringRes val repeatName: Int,
    @StringRes val shortName: Int,
    val dayNumber: Int
    ) {
    Monday(
        repeatName = R.string.repeat_mondays,
        shortName = R.string.short_mondays,
        dayNumber = 1
    ),
    Tuesday(
        repeatName = R.string.repeat_tuesday,
        shortName = R.string.short_tuesday,
        dayNumber = 2
    ),
    Wednesday(
        repeatName = R.string.repeat_wednesday,
        shortName = R.string.short_wednesday,
        dayNumber = 3
    ),
    Thursday(
        repeatName = R.string.repeat_thursday,
        shortName = R.string.short_thursday,
        dayNumber = 4
    ),
    Friday(
        repeatName = R.string.repeat_friday,
        shortName = R.string.short_friday,
        dayNumber = 5
    ),
    Saturday(
        repeatName = R.string.repeat_saturday,
        shortName = R.string.short_saturday,
        dayNumber = 6
    ),
    Sunday(
        repeatName = R.string.repeat_sunday,
        shortName = R.string.short_sunday,
        dayNumber = 7
    )
}