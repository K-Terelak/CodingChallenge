package com.example.codingchallenge.model

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class FeedEntity() : RealmObject {
    @PrimaryKey
    var id: String = ""
    var copyright: String = ""
    var results: RealmList<AlbumEntity> = realmListOf()
    var updated: String = ""

    constructor(id: String, copyright: String, results: RealmList<AlbumEntity>, updated: String) : this() {
        this.id = id
        this.copyright = copyright
        this.results = results
        this.updated = updated
    }
}
