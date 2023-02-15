package uz.ruzibekov.notely.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import uz.ruzibekov.notely.domain.model.NoteData

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_database")
    fun getAll(): LiveData<List<NoteData>>

    @Insert
    suspend fun addNote(noteData: NoteData)

    @Update
    suspend fun updateNote(noteData: NoteData)

    @Delete
    suspend fun delete(noteData: NoteData)

    @Query("SELECT * FROM note_database WHERE id=:id")
    suspend fun getNoteById(id: Long): NoteData

}