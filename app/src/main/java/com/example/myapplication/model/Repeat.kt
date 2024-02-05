package com.example.myapplication.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.room.Entity
import com.example.myapplication.R


enum class Repeat(
    @StringRes val repeatName: Int,
    @StringRes val shortName: Int,
) {
    Monday(
        repeatName = R.string.repeat_mondays,
        shortName = R.string.short_mondays
    ),
    Tuesday(
        repeatName = R.string.repeat_tuesday,
        shortName = R.string.short_tuesday
    ),
    Wednesday(
        repeatName = R.string.repeat_wednesday,
        shortName = R.string.short_wednesday
    ),
    Thursday(
        repeatName = R.string.repeat_thursday,
        shortName = R.string.short_thursday
    ),
    Friday(
        repeatName = R.string.repeat_friday,
        shortName = R.string.short_friday
    ),
    Saturday(
        repeatName = R.string.repeat_saturday,
        shortName = R.string.short_saturday
    ),
    Sunday(
        repeatName = R.string.repeat_sunday,
        shortName = R.string.short_sunday
    );

    companion object {
        fun getRepeat(day: Int): Repeat {
            return Repeat.entries[day]
        }
    }

}