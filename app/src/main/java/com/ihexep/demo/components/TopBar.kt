package com.ihexep.demo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ihexep.demo.R
import com.ihexep.demo.ui.theme.DemoTheme

@Composable
fun TopBar() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 20.dp, end = 29.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_user_logo),
            contentDescription = "user_logo",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "My Account",
                fontSize = 10.sp,
                fontWeight = FontWeight.W300,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "D Washington",
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                style = MaterialTheme.typography.titleMedium
            )
        }
        OutlinedIconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(40.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color(0xFFF2F2F2)),
            colors = IconButtonDefaults.outlinedIconButtonColors(
                containerColor = Color(0xFFF5F5F5)
            )
        ) {
            Box {
                Icon(
                    painter = painterResource(R.drawable.ic_bell),
                    tint = Color.Unspecified,
                    contentDescription = "bell"
                )
                Icon(
                    painter = painterResource(R.drawable.ic_notification),
                    tint = Color.Unspecified,
                    contentDescription = "notification",
                    modifier = Modifier.align(Alignment.TopEnd)
                )
            }
        }
        OutlinedIconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(40.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color(0xFFF2F2F2)),
            colors = IconButtonDefaults.outlinedIconButtonColors(
                containerColor = Color(0xFFF5F5F5)
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_menu),
                tint = Color.Unspecified,
                contentDescription = "menu",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DemoTheme {
        TopBar()
    }
}