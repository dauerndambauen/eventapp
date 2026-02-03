package com.dauerndambauen.eventapp.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Event::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun eventDAO(): EventDAO
}