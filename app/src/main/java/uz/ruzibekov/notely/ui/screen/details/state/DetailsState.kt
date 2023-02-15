package uz.ruzibekov.notely.ui.screen.details.state

import androidx.compose.runtime.mutableStateOf

class DetailsState {
    val noteId = mutableStateOf(-1L)
    val noteTitle = mutableStateOf("")
    val noteSubtitle = mutableStateOf("")
}