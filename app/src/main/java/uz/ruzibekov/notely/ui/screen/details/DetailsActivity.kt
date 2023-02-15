package uz.ruzibekov.notely.ui.screen.details

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import uz.ruzibekov.notely.R
import uz.ruzibekov.notely.domain.model.NoteData
import uz.ruzibekov.notely.ui.screen.details._layout.DetailsScreen
import uz.ruzibekov.notely.ui.screen.details.components.DetailsBottomSheet
import uz.ruzibekov.notely.ui.screen.details.components.DetailsTopbar
import uz.ruzibekov.notely.ui.screen.details.listener.DetailsListener
import uz.ruzibekov.notely.ui.theme.NotelyTheme

@OptIn(ExperimentalMaterialApi::class)
@AndroidEntryPoint
class DetailsActivity : ComponentActivity(), DetailsListener {

    companion object {
        const val NOTE_ID_KEY = "note-id-key"
    }

    private val viewModel: DetailsViewModel by viewModels()
    private lateinit var bottomSheetState: ModalBottomSheetState
    private lateinit var scope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotelyTheme {
                Initialize()
                ModalBottomSheetLayout(
                    sheetState = bottomSheetState,
                    sheetShape = RoundedCornerShape(
                        topStart = 15.dp,
                        topEnd = 15.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    ),
                    sheetContent = {
                        DetailsBottomSheet(
                            listener = this@DetailsActivity,
                            noteData = NoteData(
                                id = viewModel.state.noteId.value,
                                title = viewModel.state.noteTitle.value,
                                subtitle = viewModel.state.noteSubtitle.value
                            )
                        )
                    },
                    content = {
                        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
                            DetailsTopbar(this@DetailsActivity)
                            DetailsScreen.Default(
                                modifier = Modifier.weight(1f),
                                state = viewModel.state
                            )
                        }
                    }
                )
            }
        }
    }

    @Composable
    private fun Initialize() {
        val noteId = intent.getLongExtra(NOTE_ID_KEY, -1)
        viewModel.getNoteById(noteId)
        bottomSheetState = rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden
        )
        scope = rememberCoroutineScope()
    }

    override fun onClickBack() {
        finish()
    }

    override fun showMoreDialog() {
        scope.launch {
            bottomSheetState.show()
        }
    }

    override fun addAttachment(note: NoteData) {
        if (note.title.isNotEmpty() && note.id == -1L) {
            note.id = 0
            viewModel.addNote(note)
            showToast(text = getString(R.string.toast_successful_add_attachment))
        } else
            viewModel.updateNote()
        closeSheetDialog()
        finish()
    }

    override fun deleteNote() {
        if (viewModel.state.noteId.value != -1L) {
            viewModel.deleteNote()
            finish()
            showToast(getString(R.string.toast_successful_delete))
        } else
            showToast(text = getString(R.string.toast_fail_delete))
        closeSheetDialog()
    }

    override fun shareNote(note: NoteData) {
//        TODO("Not yet implemented")
        closeSheetDialog()
    }

    override fun lockNote(note: NoteData) {
//        TODO("Not yet implemented")
        closeSheetDialog()
    }

    override fun pinToTop(note: NoteData) {
//        TODO("Not yet implemented")
        closeSheetDialog()
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }


    private fun closeSheetDialog() {
        scope.launch { bottomSheetState.hide() }
    }
}