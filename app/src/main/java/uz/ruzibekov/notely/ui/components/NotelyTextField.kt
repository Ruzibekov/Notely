package uz.ruzibekov.notely.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import uz.ruzibekov.notely.ui.theme.NotelyColor

@Composable
fun NotelyTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean,
    textStyle: TextStyle
) {
    Box {
        if (value.isEmpty())
            Text(
                modifier = modifier,
                text = "Untitled",
                style = textStyle,
                color = NotelyColor.Font.LightGray
            )
        BasicTextField(
            modifier = modifier,
            value = value,
            onValueChange = { onValueChange(it) },
            singleLine = singleLine,
            textStyle = textStyle,
        )
    }
}