package com.example.codingchallenge.common.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun LocalDate.toFormattedDate(): String = this.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
