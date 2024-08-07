# CodingChallenge


## Tech Stack
- Jetpack Compose
- Hilt
- Ktor
- Coroutine
- Realm
- Timber
- Coil
- Material3
- Kotlinx-serialization

## Features:
- HomeScreen
  - Displays a list of two albums per row.
  - Data is loaded from local database (Realm) and supports offline-first functionality.
  - The synchronization mechanism fetches data from `https://rss.applemarketingtools.com` and saves it into the local database.
  - Error handling. Allow user to retry network call if it fails and there is no data in the database
  - Each cell displays `name/artist/thumbnail`.
  - Tapping on each cell pushes another screen onto the navigation stack (AlbumDetailsScreen)
 # 
- AlbumDetailsScreen
    -  Displays detailed information about a selected album such as: `thumbnal/name/artist/copyright/genres/releaseDate` in format `dd.MM.yyyy`.
    -  Includes a button that redirects to an external URL.

## Decisions
- Multi-Module Architecture - the app is structured into multiple modules to enchance scalability and maintainability
- Offline-first Approach - ensuring the app is fully functional without an internet connection. Data is initially loaded from the local database
- Data Synchronization - using Ktor for making network requests to fetch the latest data from the api
- Dependency Injection - used Hilt to simplify the process of providing and menaging dependencies
- Async Image Loading - used coil library for efficient image loading and caching


## Video
[Screen_recording_20240807_184813.webm](https://github.com/user-attachments/assets/5f960f03-f187-4523-90b0-5b9f749e5df9)
