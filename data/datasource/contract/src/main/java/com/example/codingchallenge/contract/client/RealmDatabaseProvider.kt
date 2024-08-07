package com.example.codingchallenge.contract.client

import io.realm.kotlin.Realm

interface RealmDatabaseProvider {
    val realm: Realm
}
