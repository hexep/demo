package com.ihexep.demo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ihexep.demo.R
import com.ihexep.demo.components.custom.AnySizeTextField
import com.ihexep.demo.ui.theme.DemoTheme


const val phone_mask = "000 000 0000"

fun phoneNumberFilter(text: AnnotatedString): TransformedText {
    val trimmed = if (text.text.length >= 10) text.text.substring(0..9) else text.text

    val annotatedString = AnnotatedString.Builder().run {
        for (i in trimmed.indices) {
            append(trimmed[i])
            if (i == 2 || i == 5) {
                append(" ")
            }
        }
        pushStyle(
            SpanStyle(
                color = Color(0x1A0A0B0F),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
                fontWeight = FontWeight.W400
            )
        )
        append(phone_mask.takeLast(phone_mask.length - length))
        toAnnotatedString()
    }

    val phoneNumberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 2) return offset
            if (offset <= 5) return offset + 1
            if (offset <= 10) return offset + 2
            return 12
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 3 && text.length >= offset) return offset
            if (offset <= 7 && text.length >= offset - 1) return offset - 1
            if (offset <= 12 && text.length >= offset - 2) return offset - 2
            return text.length
        }
    }

    return TransformedText(annotatedString, phoneNumberOffsetTranslator)
}

@Composable
fun BuyAirtime() {
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var amountNumber by rememberSaveable { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val pattern = remember { Regex("^\\d+\$") }

    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .padding(top = 30.dp)
            .height(172.dp)
            .padding(horizontal = 20.dp)
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
            modifier = Modifier.weight(1f)
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
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
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
                        value = phoneNumber,
                        onValueChange = {
                            if (it.isEmpty() || it.matches(pattern)) {
                                phoneNumber = it.take(10)
                            }
                        },
                        valueStyle = MaterialTheme.typography.titleSmall.copy(
                            color = Color(0x800A0B0F),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
                            fontWeight = FontWeight.W400
                        ),
                        hintStyle = MaterialTheme.typography.titleSmall.copy(
                            color = Color(0x1A0A0B0F),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
                            fontWeight = FontWeight.W400
                        ),
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(1.dp, Color(0xFFE0E0E0)),
                        background = Color(0xFFF8F8F8),
                        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        visualTransformation = { phoneNumberFilter(it) },
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
                        value = amountNumber,
                        onValueChange = {
                            if (it.isEmpty() || it.matches(pattern)) {
                                amountNumber = it
                            }
                        },
                        hint = "100",
                        valueStyle = MaterialTheme.typography.titleSmall.copy(
                            color = Color(0x800A0B0F),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
                            fontWeight = FontWeight.W400
                        ),
                        hintStyle = MaterialTheme.typography.titleSmall.copy(
                            color = Color(0x1A0A0B0F),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
                            fontWeight = FontWeight.W400
                        ),
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(1.dp, Color(0xFFE0E0E0)),
                        background = Color(0xFFF8F8F8),
                        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
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