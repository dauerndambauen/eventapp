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

    @Query("SELECT * FROM event WHERE 'plan' LIKE :planF")
    fun findByPlan(planF: String): List<Event>

    @Query("DELETE FROM event WHERE 'plan' = :planD")
    fun deleteByPlan(planD: String)

    @Query("SELECT * FROM event WHERE id > :idNow ORDER by id")
    fun loadAllSortetTime(idNow: Int): List<Event>


    @Insert
    fun insertAll(vararg events: Event)

    @Delete
    fun delete(event: Event)

}
