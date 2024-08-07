package com.example.codingchallenge.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class GenreEntity() : RealmObject {
    @PrimaryKey
    var genreId: String = ""
    var name: String = ""
    var url: String = ""

    constructor(genreId: String, name: String, url: String) : this() {
        this.genreId = genreId
        this.name = name
        this.url = url
    }
}
