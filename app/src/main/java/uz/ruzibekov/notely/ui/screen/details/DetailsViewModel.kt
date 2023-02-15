package uz.ruzibekov.notely.ui.screen.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.ruzibekov.notely.data.repository.NoteRepository
import uz.ruzibekov.notely.domain.model.NoteData
import uz.ruzibekov.notely.ui.screen.details.state.DetailsState
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    val state = DetailsState()

    fun addNote(noteData: NoteData) {
        viewModelScope.launch {
            repository.addNote(note = noteData)
        }
    }

    fun updateNote() {
        viewModelScope.launch {
            repository.updateNote(note = getNoteData())
        }
    }

    fun getNoteById(id: Long) {
        if (id != -1L)
            viewModelScope.launch {
                val note = repository.getNoteById(id)
                state.noteId.value = note.id
                state.noteTitle.value = note.title
                state.noteSubtitle.value = note.subtitle
            }
    }

    fun deleteNote() {
        viewModelScope.launch {
            repository.deleteNote(getNoteData())
        }
    }

    fun getNoteData() = NoteData(
        id = state.noteId.value,
        title = state.noteTitle.value,
        subtitle = state.noteSubtitle.value
    )
}