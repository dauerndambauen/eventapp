package com.dauerndambauen.eventapp.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Event (
    @PrimaryKey val id: Int, //id is made: year month day hour minute for simpler sorting and finding
    @ColumnInfo(name = "event_name") val eventName: String,
    @ColumnInfo(name = "event_type") val eventType: String,
    @ColumnInfo(name = "day") val day: Int,
    @ColumnInfo(name = "month") val month: Int,
    @ColumnInfo(name = "year") val year: Int,
    @ColumnInfo(name = "hour") val hour: Int,
    @ColumnInfo(name = "minute") val minute: Int,
    @ColumnInfo(name = "location") val location: String,
    @ColumnInfo(name = "description") val description: String, //To save more infos for the App like Information on trains
    @ColumnInfo(name = "comment") val comment: String, //To save comments of the user
    @ColumnInfo(name = "durationDay") val durationDay: Int,
    @ColumnInfo(name = "durationMonth") val durationMonth: Int,
    @ColumnInfo(name = "durationYear") val durationYear: Int,
    @ColumnInfo(name = "durationHour") val durationHour: Int,
    @ColumnInfo(name = "durationMinute") val durationMinute: Int,
    @ColumnInfo(name = "plan") val plan: String //to group the events
)
