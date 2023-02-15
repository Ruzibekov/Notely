package uz.ruzibekov.notely.ui.screen.details.components

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
import uz.ruzibekov.notely.domain.model.NoteData
import uz.ruzibekov.notely.ui.screen.details.listener.DetailsListener
import uz.ruzibekov.notely.ui.theme.NotelyColor


@Composable
fun DetailsBottomSheet(
    listener: DetailsListener,
    noteData: NoteData
) {
    Column(modifier = Modifier.padding(vertical = 10.dp)) {
        ItemBottomSheet(
            title = stringResource(R.string.details_sheet_add_attachment),
            onClick = { listener.addAttachment(noteData) },
        )
        ItemBottomSheet(
            title = stringResource(R.string.details_sheet_delete_note),
            onClick = { listener.deleteNote() },
        )
        ItemBottomSheet(
            title = stringResource(R.string.details_sheet_share_note),
            onClick = { /*TODO*/ },
        )
        ItemBottomSheet(
            title = stringResource(R.string.details_sheet_lock_note),
            onClick = { /*TODO*/ },
        )
        ItemBottomSheet(
            title = stringResource(R.string.details_sheet_pin_to_top),
            onClick = { /*TODO*/ },
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