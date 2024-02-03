package com.niloy.robobaj2.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.niloy.robobaj2.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomEditText(
    label: String,
    placeholder: String,
    inputType: String,
    modifier: Modifier,
    onValueChanged: (String) -> Unit
) {
    var visualTransformation: VisualTransformation = VisualTransformation.None
    var alpha: Float = 0f
    var keyboardType=KeyboardType.Text
    if(inputType == "text"){
        keyboardType = KeyboardType.Text
    }
    else if(inputType == "phone"){
        keyboardType = KeyboardType.Phone
    }
    else if(inputType == "email"){
        keyboardType = KeyboardType.Email
    }
    else if(inputType == "int"){
        keyboardType = KeyboardType.Decimal
    }
    var value by remember {
        mutableStateOf("")
    }
    var passIcon by remember {
        mutableStateOf(true)
    }
    var iconId = if (passIcon) R.drawable.baseline_key_24 else R.drawable.baseline_key_off_24

    if (inputType == "password" && passIcon) {
        visualTransformation = PasswordVisualTransformation()
        alpha = 1f
    }
    if (!passIcon) {
        alpha = 1f
    }
    OutlinedTextField(value = value, onValueChange = { text ->
        value = text
        onValueChanged(value)

    }, label = { Text(text = label) }, placeholder = {
        Text(
            text = placeholder
        )
    }, visualTransformation = visualTransformation, trailingIcon = {
        if (inputType == "password") {
            Image(painter = painterResource(id = iconId),
                contentDescription = "Icon",
                modifier = Modifier
                    .clickable { passIcon = !passIcon }
                    .alpha(alpha))
        }

    }, modifier = modifier, keyboardOptions = KeyboardOptions(keyboardType = keyboardType))
}