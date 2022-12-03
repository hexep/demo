package com.ihexep.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.ihexep.demo.components.*
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
                        modifier = Modifier
                        .pointerInput(Unit) {
                            detectTapGestures(onTap = { focusManager.clearFocus() })
                        }
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                            TopBar()
                            Banner()
                            Offers()
                            BuyAirtime()
                            Explore()
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