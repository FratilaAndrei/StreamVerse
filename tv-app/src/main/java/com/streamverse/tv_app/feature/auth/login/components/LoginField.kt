package com.streamverse.tv_app.feature.auth.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text

@Composable
fun LoginField(
    modifier: Modifier = Modifier,
    focusRequester: FocusRequester,
    onValueChange: (String) -> Unit,
    value: String,
    keyboardType: KeyboardType,
    placeholder: String,
) {

    val isFocused = remember { mutableStateOf(false) }

    val outOfFocusColor = 0xff6e6e6e
    val borderOutOfFocusColor = 0xffc4c4c4
    val backgroundColor = when {
        isFocused.value -> Color.White
        else -> Color(outOfFocusColor)
    }
    val borderColor = when {
        isFocused.value -> Color(borderOutOfFocusColor)
        else -> Color.Transparent
    }
    Box(contentAlignment = Alignment.CenterStart, modifier = modifier) {
        BasicTextField(
            value,
            onValueChange = onValueChange,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            modifier = Modifier
                .background(backgroundColor, shape = MaterialTheme.shapes.medium)
                .border(3.dp, borderColor, shape = MaterialTheme.shapes.medium)
                .width(375.dp)
                .padding(vertical = 8.dp, horizontal = 12.dp)
                .onFocusChanged { isFocused.value = it.hasFocus }
                .focusRequester(
                    focusRequester
                )
        )
        if (value.isEmpty()) {
            Row {
                Spacer(modifier = Modifier.width(8.dp))
                Text(placeholder, modifier = Modifier.padding(start = 6.dp))
            }

        }
    }

}