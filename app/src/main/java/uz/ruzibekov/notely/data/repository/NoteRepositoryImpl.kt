package uz.ruzibekov.notely.data.repository

import androidx.lifecycle.LiveData
import uz.ruzibekov.notely.data.room.NoteDao
import uz.ruzibekov.notely.domain.model.NoteData

class NoteRepository(private val dao: NoteDao) {

    fun getNoteList(): LiveData<List<NoteData>> {
        return dao.getAll()
    }

    suspend fun addNote(note: NoteData){
        dao.addNote(note)
    }

    suspend fun updateNote(note: NoteData){
        dao.updateNote(note)
    }

    suspend fun getNoteById(noteId: Long): NoteData{
        return dao.getNoteById(id = noteId)
    }

    suspend fun deleteNote(note: NoteData){
        dao.delete(note)
    }

}