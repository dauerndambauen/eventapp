package com.dauerndambauen.eventapp.storage

import android.content.Context
import androidx.room.Room

class DatabaseAccess(context: Context) {

    private val db = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java, "eventDatabase"
    ).build()

    val eventDao = db.eventDAO()
    val events: List<Event> = eventDao.getAll()
}
