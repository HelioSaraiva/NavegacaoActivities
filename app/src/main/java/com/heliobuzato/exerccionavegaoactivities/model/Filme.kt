package com.heliobuzato.exerccionavegaoactivities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Filme(
    val nome: String,
    val descricao: String,
    val imagemId: Int
): Parcelable