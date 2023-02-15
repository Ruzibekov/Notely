package uz.ruzibekov.notely.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.notely.R
import uz.ruzibekov.notely.ui.theme.NotelyColor

@Composable
fun NotelyTextField(
    value: String,
    onValueChange: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .background(NotelyColor.Gray)
            .padding(vertical = 8.dp, horizontal = 14.dp)
    ) {
        if (value.isEmpty())
            Text(
                text = stringResource(id = R.string.main_screen_textfield_placeholder),
                style = MaterialTheme.typography.body1,
                color = NotelyColor.Font.Dark
            )
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = { onValueChange(it) },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true,
            maxLines = 1
        )
    }
}