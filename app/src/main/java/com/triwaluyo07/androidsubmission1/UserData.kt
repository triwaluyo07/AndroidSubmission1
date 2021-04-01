package com.triwaluyo07.androidsubmission1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    var avatar : Int? = null,
    var username: String? = null,
    var name: String? = null,
    var repository: String? = null,
    var followers: String? = null,
    var following: String? = null,
    var location: String? = null,
    var company : String? = null


) : Parcelable
