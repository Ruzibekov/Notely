package uz.ruzibekov.notely.ui.screen.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.ruzibekov.notely.data.repository.NoteRepository
import uz.ruzibekov.notely.domain.model.NoteData
import uz.ruzibekov.notely.ui.screen.main.state.MainState
import java.util.Collections.addAll
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    val state = MainState()

    fun initialize(owner: LifecycleOwner) {
        noteRepository.getNoteList().observe(owner) {
            state.noteList.value = it
            state.searchList.value = state.noteList.value
        }
    }

    fun onSearch(noteTitle: String) {
        val newList = mutableListOf<NoteData>()
        state.noteList.value.forEach {
            if (it.title.lowercase().contains(noteTitle.lowercase()))
                newList.add(it)
        }
        state.searchList.value = newList
    }

}