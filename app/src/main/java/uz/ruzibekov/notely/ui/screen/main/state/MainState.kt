package uz.ruzibekov.notely.ui.screen.main.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import uz.ruzibekov.notely.domain.model.NoteData

class MainState {
    val search = mutableStateOf("")
    val noteList: MutableState<List<NoteData>> = mutableStateOf(listOf())
    val searchList: MutableState<List<NoteData>> = mutableStateOf(listOf())
}