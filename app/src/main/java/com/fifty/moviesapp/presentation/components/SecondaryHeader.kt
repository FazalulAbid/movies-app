package com.fifty.moviesapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.fifty.moviesapp.R
import com.fifty.moviesapp.presentation.ui.theme.SizeMini4
import com.fifty.moviesapp.presentation.ui.theme.SizeSmall8
import com.fifty.moviesapp.presentation.ui.theme.SizeStandard16

@Composable
fun SecondaryHeader(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    fontWeight: FontWeight = FontWeight.Medium,
    maxLines: Int = 1,
    moreOptionPainter: Painter = painterResource(id = R.drawable.ic_arrow_up_right),
    showTextAndIcon: Boolean = false,
    moreOptionText: String?,
    moreOptionIconColor: Color = MaterialTheme.colorScheme.primary,
    onMoreOptionClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = SizeSmall8)
    ) {
        Text(
            modifier = Modifier
                .weight(1f),
            text = text,
            style = style.copy(
                fontWeight = fontWeight,
                color = color
            ),
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(SizeStandard16))
        moreOptionText?.let { text ->
            if (showTextAndIcon) {
                Row(
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable { onMoreOptionClick() }
                        .padding(vertical = SizeMini4, horizontal = SizeSmall8),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                    Spacer(modifier = Modifier.width(SizeSmall8))
                    Icon(
                        painter = moreOptionPainter,
                        contentDescription = stringResource(id = R.string.show_more),
                        tint = moreOptionIconColor
                    )
                }
            } else {
                IconButton(
                    onClick = { onMoreOptionClick() }
                ) {
                    Icon(
                        painter = moreOptionPainter,
                        contentDescription = text,
                        tint = moreOptionIconColor
                    )
                }
            }
        }
    }
}