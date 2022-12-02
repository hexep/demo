package com.ihexep.demo.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ihexep.demo.R
import com.ihexep.demo.components.custom.AnySizeTextField
import com.ihexep.demo.ui.theme.DemoTheme



const val mask = "000 000 0000"

fun mobileNumberFilter(text: AnnotatedString): TransformedText {
    // change the length
    val trimmed =
        if (text.text.length >= 12) text.text.substring(0..12) else text.text

    val annotatedString = AnnotatedString.Builder().run {
        for (i in trimmed.indices) {
            append(trimmed[i])
            if (i == 1 || i == 4 || i == 6) {
                append(" ")
            }
        }
        pushStyle(SpanStyle(color = Color.LightGray))
        append(mask.takeLast(mask.length - length))
        toAnnotatedString()
    }

    val phoneNumberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 1) return offset
            if (offset <= 4) return offset + 1
            if (offset <= 6) return offset + 2
            if (offset <= 9) return offset + 3
            return 12
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 1) return offset
            if (offset <= 4) return offset - 1
            if (offset <= 6) return offset - 2
            if (offset <= 9) return offset - 3
            return 9
        }
    }

    return TransformedText(annotatedString, phoneNumberOffsetTranslator)
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyAirtime() {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Buy Airtime",
            color = Color(0xFF0A0B0F),
            fontSize = 19.sp,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.W500,
        )
        Card(
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(width = 1.dp, color = Color(0xFFE8E8E8)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 10.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_telkom_logo),
                    tint = Color.Unspecified,
                    contentDescription = "telkom",
                    modifier = Modifier
                        .size(35.dp)
                        .clip(RoundedCornerShape(6.dp))
                )
                Text(
                    text = "Telkom",
                    color = Color(0xFF000000),
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.W500,
                )
                Icon(
                    painter = painterResource(R.drawable.ic_chevron_down),
                    tint = Color.Unspecified,
                    contentDescription = "chevron_down"
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.Bottom)
                ) {
                    Text(
                        text = "Phone Number",
                        color = Color(0x800A0B0F),
                        fontSize = 12.sp,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.W400
                    )
                    AnySizeTextField(
                        value = "",
                        onValueChange = {},
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(1.dp, Color(0xFFE0E0E0)),
                        background = Color(0xFFF8F8F8),
                        visualTransformation = { mobileNumberFilter(it) },
                        modifier = Modifier.height(40.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier
                        .width(101.dp)
                        .align(Alignment.Bottom)
                ) {
                    Text(
                        text = "Amount",
                        color = Color(0x800A0B0F),
                        fontSize = 12.sp,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.W400
                    )
                    AnySizeTextField(
                        value = "",
                        onValueChange = {},
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(1.dp, Color(0xFFE0E0E0)),
                        background = Color(0xFFF8F8F8),
                        visualTransformation = { mobileNumberFilter(it) },
                        modifier = Modifier.height(40.dp)
                    )
                }
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, Color(0xFFE0E0E0)),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color(0xFFF8F8F8)
                    ),
                    modifier = Modifier
                        .height(40.dp)
                        .align(Alignment.Bottom)
                ) {
                    Text(
                        text = "Buy",
                        color = Color(0x800A0B0F),
                        fontSize = 12.sp,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.W500,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BuyAirtimePreview() {
    DemoTheme {
        BuyAirtime()
    }
}