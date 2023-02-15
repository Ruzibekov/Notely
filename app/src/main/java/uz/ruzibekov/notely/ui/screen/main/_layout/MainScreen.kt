package uz.ruzibekov.notely.ui.screen.main._layout

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import uz.ruzibekov.notely.domain.model.NoteData
import uz.ruzibekov.notely.ui.screen.main.components.MainComponents
import uz.ruzibekov.notely.ui.screen.main.listener.MainListener
import uz.ruzibekov.notely.ui.screen.main.state.MainState

object MainScreen {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun Default(
        state: MainState,
        listener: MainListener
    ) {
        Scaffold(
            topBar = {
                MainComponents.TopbarView(
                    state = state,
                    listener = listener
                )
            },
            floatingActionButton = {
                MainComponents.FloatingButton(onClick = {
                    listener.openAddNoteScreen()
                })
            }
        ) {
            MainComponents.ContentView(
                noteList = state.searchList.value,
                listener = listener
            )
        }
    }

}