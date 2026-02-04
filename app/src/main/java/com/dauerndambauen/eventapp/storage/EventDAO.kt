package com.dauerndambauen.eventapp.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface EventDAO {
    @Query("SELECT * FROM event")
    fun getAll(): List<Event>

    @Query("SELECT * FROM event WHERE id IN (:eventIds)")
    fun loadAllByIds(eventIds: IntArray): List<Event>

    @Query("SELECT * FROM event WHERE event_name LIKE :plan")
    fun findByPlan(plan: String): List<Event>

    @Insert
    fun insertAll(vararg events: Event)

    @Delete
    fun delete(event: Event)

}
