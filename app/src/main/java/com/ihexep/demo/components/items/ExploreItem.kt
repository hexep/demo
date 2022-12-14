package com.ihexep.demo.components.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ihexep.demo.model.DemoExplorables
import com.ihexep.demo.model.Explorable
import com.ihexep.demo.ui.theme.DemoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreItem(explorable: Explorable) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 1.dp, color = Color(0xFFE8E8E8)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFCFCFC)),
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(all = 15.dp)
        ) {
            Icon(
                painter = painterResource(explorable.iconId),
                tint = Color.Unspecified,
                contentDescription = "${explorable.iconId}",
                modifier = Modifier
                    .size(55.dp)
                    .background(Color.White)
                    .shadow(
                        elevation = 7.dp,
                        shape = RoundedCornerShape(10.dp),
                        ambientColor = Color(0x1AFFFDFD)
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        border = BorderStroke(width = 1.dp, color = Color(0xFFE8E8E8)),
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(
                    text = explorable.title,
                    color = Color(0xFF0A0B0F),
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.W500,
                )
                Text(
                    text = explorable.desc,
                    overflow = TextOverflow.Ellipsis,
                    color = Color(0xFF6B6B6B),
                    maxLines = 2,
                    lineHeight = 20.sp,
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.W300,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExploreItemPreview() {
    DemoTheme {
        ExploreItem(DemoExplorables[0])
    }
}