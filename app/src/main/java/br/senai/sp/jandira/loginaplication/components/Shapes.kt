package br.senai.sp.jandira.loginaplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopShape() {
    Box(modifier = Modifier
        .background(
            color = Color(217, 0, 255, 255),
            shape = RoundedCornerShape(bottomStart = 16.dp)
        )
        .size(120.dp, 40.dp)
    )
}

@Preview
@Composable
fun TopShapePreview() {
    TopShape()
}

@Composable
fun BottomShape() {
    Box(modifier = Modifier
        .background(
            color = Color(217, 0, 255, 255),
            shape = RoundedCornerShape(topEnd = 16.dp)
        )
        .size(120.dp, 40.dp)
    )
}