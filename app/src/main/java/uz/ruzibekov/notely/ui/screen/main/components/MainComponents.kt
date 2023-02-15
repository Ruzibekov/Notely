package uz.ruzibekov.notely.ui.screen.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.notely.R
import uz.ruzibekov.notely.domain.model.NoteData
import uz.ruzibekov.notely.ui.components.NotelyTextField
import uz.ruzibekov.notely.ui.screen.main.listener.MainListener
import uz.ruzibekov.notely.ui.screen.main.state.MainState
import uz.ruzibekov.notely.ui.theme.NotelyColor
import uz.ruzibekov.notely.ui.theme.NotelyIcons
import uz.ruzibekov.notely.utils.Constants

object MainComponents {

    @Composable
    fun ContentView(noteList: List<NoteData>, listener: MainListener) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (noteList.isEmpty())
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(id = R.drawable.image_none),
                    contentDescription = "None image"
                )
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Adaptive(150.dp),
                contentPadding = PaddingValues(all = 10.dp)
            ) {
                items(noteList) { note ->
                    ContentItem(note = note, onClick = { listener.openAddNoteScreen(it) })
                }
            }
        }
    }

    @Composable
    private fun ContentItem(note: NoteData, onClick: (Long) -> Unit) {
        Surface(
            modifier = Modifier
                .padding(all = 4.dp)
                .width(150.dp)
                .height(180.dp),
            shape = MaterialTheme.shapes.medium,
            color = NotelyColor.Violet
        ) {
            Column(
                modifier = Modifier.clickable { onClick(note.id) }.padding(all = 12.dp),
            ) {
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = note.subtitle,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }

    @Composable
    fun TopbarView(state: MainState, listener: MainListener) {
        Card(elevation = Constants.ELEVATION, shape = RoundedCornerShape(0.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = Constants.HORIZONTAL_PADDING,
                        vertical = Constants.VERTICAL_PADDING
                    ),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.h1
                    )
                    Icon(
                        modifier = Modifier.clip(CircleShape).clickable { listener.showMoreDialog() },
                        painter = painterResource(id = NotelyIcons.More),
                        contentDescription = "options icon"
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                NotelyTextField(
                    value = state.search.value,
                    onValueChange = {
                        state.search.value = it
                        listener.onSearch(state.search.value)
                    },
                )
            }
        }
    }

    @Composable
    fun FloatingButton(onClick: () -> Unit) {
        FloatingActionButton(
            onClick = { onClick() },
            backgroundColor = NotelyColor.Violet
        ) {
            Icon(
                painter = painterResource(id = NotelyIcons.Add),
                contentDescription = "add note icon",
                tint = NotelyColor.White
            )
        }
    }

}