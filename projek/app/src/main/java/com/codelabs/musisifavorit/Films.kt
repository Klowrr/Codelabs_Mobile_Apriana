package com.codelabs.musisifavorit

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Films(
    var name : String ="",
    var sutradara : String ="",
    var produser : String ="",
    var rilis : String = "",
    var detail : String ="",
    var photo : Int = 0,
) : Parcelable
