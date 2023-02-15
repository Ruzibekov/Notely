package uz.ruzibekov.notely.ui.screen.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.notely.R
import uz.ruzibekov.notely.ui.screen.main.listener.MainListener
import uz.ruzibekov.notely.ui.theme.NotelyColor

@Composable
fun MainBottomSheet(
    listener: MainListener,
) {
    Column(modifier = Modifier.padding(vertical = 10.dp)) {
        ItemBottomSheet(
            title = stringResource(R.string.main_sheet_sort),
            onClick = { listener.sort() },
        )
        ItemBottomSheet(
            title = stringResource(R.string.main_sheet_select_notes),
            onClick = { listener.selectNotes() },
        )
        ItemBottomSheet(
            title = stringResource(R.string.main_sheet_list_mode),
            onClick = { listener.listMode() },
        )
        ItemBottomSheet(
            title = stringResource(R.string.main_sheet_new_folder),
            onClick = { listener.newFolder() },
            isLast = true
        )
    }
}

@Composable
private fun ItemBottomSheet(
    title: String,
    onClick: () -> Unit,
    isLast: Boolean = false
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick() }
        .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = title,
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (!isLast)
            Divider(color = NotelyColor.Black)
    }
}