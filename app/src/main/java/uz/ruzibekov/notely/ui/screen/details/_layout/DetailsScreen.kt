package uz.ruzibekov.notely.ui.screen.details._layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uz.ruzibekov.notely.ui.components.NotelyTextField
import uz.ruzibekov.notely.ui.screen.details.state.DetailsState
import uz.ruzibekov.notely.utils.Constants

object DetailsScreen {

    @Composable
    fun Default(
        modifier: Modifier = Modifier,
        state: DetailsState
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    horizontal = Constants.HORIZONTAL_PADDING,
                    vertical = Constants.VERTICAL_PADDING
                )
        ) {
            NotelyTextField(
                value = state.noteTitle.value,
                onValueChange = { state.noteTitle.value = it },
                singleLine = true,
                textStyle = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(10.dp))
            NotelyTextField(
                modifier = Modifier.fillMaxSize(),
                value = state.noteSubtitle.value,
                onValueChange = { state.noteSubtitle.value = it },
                singleLine = false,
                textStyle = MaterialTheme.typography.body1
            )
        }
    }
}