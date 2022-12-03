package com.ihexep.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ihexep.demo.components.*
import com.ihexep.demo.components.items.ExploreItem
import com.ihexep.demo.model.DemoExplorables
import com.ihexep.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val focusManager = LocalFocusManager.current
                    Box(
                        modifier = Modifier.pointerInput(Unit) {
                            detectTapGestures(onTap = { focusManager.clearFocus() })
                        }
                    ) {
                        LazyColumn() {
                            item { TopBar() }
                            item { Banner() }
                            item { Offers() }
                            item { BuyAirtime() }
                            item {
                                Text(
                                    text = "Explore",
                                    color = Color(0xFF0A0B0F),
                                    fontSize = 19.sp,
                                    fontWeight = FontWeight.W500,
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier.padding(
                                        start = 30.dp,
                                        end = 30.dp,
                                        top = 20.dp,
                                        bottom = 15.dp)
                                )
                            }
                            items(DemoExplorables) { explorable ->
                                ExploreItem(explorable = explorable)
                            }
                        }
                        BottomBar(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(20.dp)
                        )
                    }
                }
            }
        }
    }
}