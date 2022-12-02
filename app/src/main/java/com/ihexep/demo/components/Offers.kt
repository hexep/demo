package com.ihexep.demo.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ihexep.demo.components.items.OfferItem
import com.ihexep.demo.model.DemoOffers
import com.ihexep.demo.ui.theme.DemoTheme

@Composable
fun Offers() {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 30.dp)
        ) {
            Text(
                text = "Offers",
                color = Color(0xFF0A0B0F),
                fontSize = 19.sp,
                fontWeight = FontWeight.W500,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "View All",
                color = Color(0xFFB91A2E),
                fontSize = 12.sp,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.W500
            )
        }
        LazyRow(
            contentPadding = PaddingValues(horizontal = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            items(DemoOffers) { offer ->
                OfferItem(offer)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OffersPreview() {
    DemoTheme {
        Offers()
    }
}