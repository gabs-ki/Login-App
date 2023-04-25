package br.senai.sp.jandira.loginaplication.model

import androidx.compose.ui.graphics.painter.Painter

data class Category (
    var id: Long = 0,
    var name: String = "",
    var image: Painter? = null,

){

}