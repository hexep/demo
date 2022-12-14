package com.ihexep.demo.components.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ihexep.demo.model.BottomBarAction
import com.ihexep.demo.model.BottomBarActions
import com.ihexep.demo.ui.theme.DemoTheme

@Composable
fun BottomBarItem(action: BottomBarAction) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        if (action.isMain) {
            val gradient =
                Brush.linearGradient(
                    colors = listOf(Color(0xFFFE5065), Color(0xFFAF0E22)),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            OutlinedIconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(50.dp),
                border = BorderStroke(0.dp, Color.Transparent),
                shape = RoundedCornerShape(50),
                colors = IconButtonDefaults.outlinedIconButtonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(gradient),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        painter = painterResource(action.iconId),
                        tint = Color.Unspecified,
                        contentDescription = "${action.iconId}"
                    )
                }
            }
        } else {
            OutlinedIconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(50.dp),
                shape = RoundedCornerShape(50),
                border = BorderStroke(1.dp, Color(0xFFF2F2F2)),
                colors = IconButtonDefaults.outlinedIconButtonColors(
                    containerColor = Color(0xFFF8F8F8)
                )
            ) {
                Icon(
                    painter = painterResource(action.iconId),
                    tint = Color.Unspecified,
                    contentDescription = "${action.iconId}"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarItemPreview() {
    DemoTheme {
        BottomBarItem(BottomBarActions[2])
    }
}