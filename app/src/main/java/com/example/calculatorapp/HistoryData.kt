package com.example.calculatorapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HistoryData(
    val bilangan: String,
    val hasil: String
): Parcelable