package com.dauerndambauen.eventapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

object Callender {

    @Composable
    fun date(day: Int, month: Int, year: Int) {
        Text(
            text = "$day, $month, $year"
        )
    }
}
