package com.ihexep.demo.components.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ihexep.demo.model.DemoOffers
import com.ihexep.demo.model.Offer
import com.ihexep.demo.ui.theme.DemoTheme

@Composable
fun OfferItem(
    offer: Offer
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        OutlinedIconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(50.dp),
            shape = RoundedCornerShape(50),
            border = BorderStroke(1.dp, Color(0xFFDADADA))
        ) {
            Icon(
                painter = painterResource(offer.iconId),
                tint = Color.Unspecified,
                contentDescription = "${offer.iconId}"
            )
        }
        Text(
            text = offer.title,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Clip,
            lineHeight = 11.sp,
            color = Color(0xFF24253D),
            fontSize = 10.sp,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.W400,
            modifier = Modifier.width(50.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OfferItemPreview() {
    DemoTheme {
        OfferItem(DemoOffers[0])
    }
}