package uz.ruzibekov.notely.ui.screen.details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.notely.R
import uz.ruzibekov.notely.ui.screen.details.listener.DetailsListener
import uz.ruzibekov.notely.ui.theme.NotelyIcons
import uz.ruzibekov.notely.utils.Constants


@Composable
fun DetailsTopbar(listener: DetailsListener) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = Constants.HORIZONTAL_PADDING,
                vertical = Constants.VERTICAL_PADDING
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.clip(CircleShape).clickable { listener.onClickBack() },
            painter = painterResource(NotelyIcons.BackArrow),
            contentDescription = "back stack icon"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(R.string.details_screen_title),
            style = MaterialTheme.typography.subtitle1
        )
        Icon(
            modifier = Modifier.clip(CircleShape).clickable { listener.showMoreDialog() },
            painter = painterResource(NotelyIcons.More),
            contentDescription = "more icon"
        )
    }
}


