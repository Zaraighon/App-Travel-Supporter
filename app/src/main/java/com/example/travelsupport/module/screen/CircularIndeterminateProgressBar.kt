package com.example.travelsupport.module.screen

import android.widget.Spinner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ehsanmsz.mszprogressindicator.progressindicator.BallSpinFadeLoaderProgressIndicator
import com.example.travelsupport.ui.theme.LightBlue

@Composable
fun CircularIndeterminateProgressBar (
    isDisplayed: Boolean,
    modifier: Modifier
){
    if(isDisplayed){
        Row (modifier = modifier, horizontalArrangement = Arrangement.Center){
            BallSpinFadeLoaderProgressIndicator(
                color = Color.Gray,
            )
        }
    }
}