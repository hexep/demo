package com.ihexep.demo.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ihexep.demo.R
import com.ihexep.demo.ui.theme.DemoTheme

@Composable
fun Banner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFFE5950),
                        Color(0xFFAF0E22)
                    )
                )
            )
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFFFFFF), Color(0x00FFFFFF)),
                    start = Offset.Zero,
                    end = Offset.Infinite
                ),
                alpha = 0.05f,
                radius = 190.dp.toPx(),
                center = Offset(x = 46.dp.toPx(), y = 190.dp.toPx())
            )
            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFFFFFF), Color(0x00FFFFFF)),
                    start = Offset.Zero,
                    end = Offset.Infinite
                ),
                alpha = 0.05f,
                radius = 127.dp.toPx(),
                center = Offset(x = 15.dp.toPx(), y = 190.dp.toPx())
            )
            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFFFFFF), Color(0x00FFFFFF)),
                    start = Offset.Zero,
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                ),
                alpha = 0.2f,
                radius = 157.dp.toPx(),
                center = Offset(x = size.width - 26.dp.toPx(), y = -14.dp.toPx())
            )
            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFFFFFF), Color(0x00FFFFFF)),
                    start = Offset.Zero,
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                ),
                alpha = 0.2f,
                radius = 105.dp.toPx(),
                center = Offset(x = size.width - 26.dp.toPx(), y = -14.dp.toPx())
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 30.dp, end = 49.dp)
                .align(Alignment.Center)
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0x4DFFFFFF))
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_earnings),
                    tint = Color.Unspecified,
                    contentDescription = "earnings",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Become an agent",
                    color = Color.White,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.W500
                )
                Text(
                    text = "Start earning today",
                    color = Color.White,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.W300
                )
            }
            Icon(
                painter = painterResource(R.drawable.ic_chevron_right),
                tint = Color.Unspecified,
                contentDescription = "chevron_right"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BannerPreview() {
    DemoTheme {
        Banner()
    }
}