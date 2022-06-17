package com.example.bookapp.ui.api

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

data class PostModel(
    val userId: Int,
    var id: Int,
    var title: String,
    var body: String
)