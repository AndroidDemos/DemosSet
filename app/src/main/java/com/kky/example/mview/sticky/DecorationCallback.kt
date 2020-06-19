package com.kky.example.mview.sticky

interface DecorationCallback {

    fun getGroupId(position: Int): Long

    fun getGroupFirstLine(position: Int): String
}