package com.example.locationreminders.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.locationreminders.domain.model.Notes

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Notes)

    @Query("SELECT * FROM notes_table")
    suspend fun getAllNotes(): List<Notes>

    @Delete
    suspend fun delete(note: Notes)
}