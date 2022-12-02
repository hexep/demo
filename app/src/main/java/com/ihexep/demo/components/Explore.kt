package com.ihexep.demo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ihexep.demo.components.items.ExploreItem
import com.ihexep.demo.model.DemoExplorables
import com.ihexep.demo.ui.theme.DemoTheme

@Composable
fun Explore() {
    Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
        Text(
            text = "Explore",
            color = Color(0xFF0A0B0F),
            fontSize = 19.sp,
            fontWeight = FontWeight.W500,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 30.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(DemoExplorables) { explorable ->
                ExploreItem(explorable = explorable)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExplorePreview() {
    DemoTheme {
        Explore()
    }
}