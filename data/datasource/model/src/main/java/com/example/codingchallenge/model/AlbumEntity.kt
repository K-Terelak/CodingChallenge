package com.example.codingchallenge.model

import io.realm.kotlin.ext.backlinks
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class AlbumEntity() : RealmObject {
    @PrimaryKey
    var id: String = ""
    var artistId: String = ""
    var artistName: String = ""
    var artistUrl: String = ""
    var artworkUrl100: String = ""
    var contentAdvisoryRating: String = ""
    var genres: RealmList<GenreEntity> = realmListOf()
    var kind: String = ""
    var name: String = ""
    var releaseDate: String = ""
    var url: String = ""
    val feed: RealmResults<FeedEntity> by backlinks(FeedEntity::results)

    constructor(
        id: String,
        artistId: String,
        artistName: String,
        artistUrl: String,
        artworkUrl100: String,
        contentAdvisoryRating: String,
        genres: RealmList<GenreEntity>,
        kind: String,
        name: String,
        releaseDate: String,
        url: String,
    ) : this() {
        this.id = id
        this.artistId = artistId
        this.artistName = artistName
        this.artistUrl = artistUrl
        this.artworkUrl100 = artworkUrl100
        this.contentAdvisoryRating = contentAdvisoryRating
        this.genres = genres
        this.kind = kind
        this.name = name
        this.releaseDate = releaseDate
        this.url = url
    }
}
