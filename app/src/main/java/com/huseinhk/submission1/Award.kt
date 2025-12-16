package com.huseinhk.submission1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Award(
    val category: String,
    val title: String,
    val image: Int
): Parcelable
