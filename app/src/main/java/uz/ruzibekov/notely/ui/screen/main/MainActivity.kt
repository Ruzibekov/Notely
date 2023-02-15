package uz.ruzibekov.notely.ui.screen.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import uz.ruzibekov.notely.ui.screen.details.DetailsActivity
import uz.ruzibekov.notely.ui.screen.main._layout.MainScreen
import uz.ruzibekov.notely.ui.screen.main.components.MainBottomSheet
import uz.ruzibekov.notely.ui.screen.main.components.MainComponents
import uz.ruzibekov.notely.ui.screen.main.listener.MainListener
import uz.ruzibekov.notely.ui.theme.NotelyTheme

@OptIn(ExperimentalMaterialApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity(), MainListener {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var sheetState: ModalBottomSheetState
    private lateinit var scope: CoroutineScope

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize(this)
        setContent {
            sheetState = rememberModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden
            )
            scope = rememberCoroutineScope()

            NotelyTheme {
                ModalBottomSheetLayout(
                    sheetState = sheetState,
                    sheetShape = RoundedCornerShape(
                        topStart = 15.dp,
                        topEnd = 15.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    ),
                    sheetContent = {
                        MainBottomSheet(listener = this@MainActivity)
                    }
                ) {
                    MainScreen.Default(state = viewModel.state, this)
                }
            }
        }
    }

    override fun openAddNoteScreen(id: Long) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.NOTE_ID_KEY, id)
        startActivity(intent)
    }

    override fun showMoreDialog() {
        scope.launch { sheetState.show() }
    }

    override fun onSearch(text: String) {
        viewModel.onSearch(noteTitle = text)
    }

    override fun sort() {
//        TODO("Not yet implemented")
    }

    override fun selectNotes() {
//        TODO("Not yet implemented")
    }

    override fun listMode() {
//        TODO("Not yet implemented")
    }

    override fun newFolder() {
//        TODO("Not yet implemented")
    }

}
