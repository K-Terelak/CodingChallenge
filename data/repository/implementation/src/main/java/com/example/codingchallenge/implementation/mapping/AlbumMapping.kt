package com.example.codingchallenge.implementation.mapping

import com.example.codingchallenge.data.api.model.AlbumDto
import com.example.codingchallenge.data.api.model.FeedDto
import com.example.codingchallenge.data.api.model.GenreDto
import com.example.codingchallenge.implementation.utils.toLocalDate
import com.example.codingchallenge.model.Album
import com.example.codingchallenge.model.AlbumEntity
import com.example.codingchallenge.model.Feed
import com.example.codingchallenge.model.FeedEntity
import com.example.codingchallenge.model.Genre
import com.example.codingchallenge.model.GenreEntity
import io.realm.kotlin.ext.realmListOf

fun FeedEntity.toFeed(): Feed = Feed(
    id = id,
    copyright = copyright,
    results = results.map { it.toAlbum() }
)

fun AlbumEntity.toAlbum(): Album = Album(
    id = id,
    artistId = artistId,
    artistName = artistName,
    artistUrl = artistUrl,
    artworkUrl100 = artworkUrl100,
    contentAdvisoryRating = contentAdvisoryRating,
    genres = genres.map { it.toGenre() },
    kind = kind,
    name = name,
    releaseDate = releaseDate.toLocalDate(),
    url = url,
    copyright = feed.firstOrNull()?.copyright.orEmpty()
)

fun GenreEntity.toGenre(): Genre = Genre(
    genreId = genreId,
    name = name,
    url = url
)

fun AlbumDto.toAlbumEntity(): AlbumEntity = AlbumEntity(
    id = id,
    artistId = artistId.orEmpty(),
    artistName = artistName.orEmpty(),
    artistUrl = artistUrl.orEmpty(),
    artworkUrl100 = artworkUrl100.orEmpty(),
    contentAdvisoryRating = contentAdvisoryRating.orEmpty(),
    genres = realmListOf<GenreEntity>().apply {
        genres?.forEach { this.add(it.toGenreEntity()) }
    },
    kind = kind.orEmpty(),
    name = name.orEmpty(),
    releaseDate = releaseDate.orEmpty(),
    url = url.orEmpty()
)

fun GenreDto.toGenreEntity(): GenreEntity = GenreEntity(
    genreId = genreId,
    name = name,
    url = url
)

fun FeedDto.toFeedEntity(): FeedEntity = FeedEntity(
    id = id,
    copyright = copyright,
    results = realmListOf<AlbumEntity>().apply {
        results.forEach { albumDto: AlbumDto ->
            this.add(albumDto.toAlbumEntity())
        }
    },
    updated = updated
)
