package com.ihexep.demo.components.custom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun AnySizeTextField(
    modifier: Modifier = Modifier,
    value: String,
    valueStyle: TextStyle = TextStyle.Default,
    hint: String = "",
    hintStyle: TextStyle = TextStyle.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    background: Color = Color.White,
    shape: Shape = RoundedCornerShape(5.dp),
    border: BorderStroke = ButtonDefaults.outlinedButtonBorder,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    BasicTextField(
        value = value,
        singleLine = true,
        onValueChange = { onValueChange(it) },
        modifier = modifier,
        textStyle = valueStyle,
        cursorBrush = SolidColor(LocalContentColor.current),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        decorationBox = { innerTextField ->
            Card(
                border = border,
                shape = shape
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(background)
                ) {
                    if (leadingIcon != null) {
                        leadingIcon()
                    }
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .weight(1.0f)
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = hint,
                                style = hintStyle
                            )
                        }
                        innerTextField()
                    }
                    if (trailingIcon != null) {
                        trailingIcon()
                    }
                }
            }
        }
    )
}