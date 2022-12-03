package com.ihexep.demo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ihexep.demo.components.items.BottomBarItem
import com.ihexep.demo.model.BottomBarActions
import com.ihexep.demo.ui.theme.DemoTheme

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(50),
        border = BorderStroke(1.dp, Color(0xFFD4D4D4)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier.height(80.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            BottomBarActions.forEach {
                BottomBarItem(it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    DemoTheme {
        BottomBar()
    }
}