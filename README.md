# Working on Progress

# HaloSocialNetwork
Social media app where user can connect to another user.

# Purpose for this app?
I wanna make this app as a benchmark for my upcoming future projects, why so?, because i try my best to write the code in this app as clean as possible, using the most recommnded and best practice architecture in android development. This app provides all the latest and the best way to make Modern Android App.

# Kotlin Multiplatform Mobile?
KMM is great, i immediately fall in love since it's become Beta and knowing the fact that it can use Jetpack Compose for android side it make it even more great. I do believe KMM is a future of Mobile Development, it'a multiplatform mobile (Android & IOS), but it's NATIVE!!!, how cool is that?, seeing KOTLIN, JETPACK COMPOSE AND SWIFT UI combined together in one codebase, it's a DEADLY COMBO. So because of that i make this app to not depend on library and dependencies that use Java under the hood, because i will definetely want to expand this app using Kotlin Multiplatform in the future. But for now it's just for android.

# What topics is covered in this app?
* Fully Kotlin and Jetpack Compose with the latest version
* Reactive Programming using the one and only Kotlin Flow
* Modularization (MVVM and Clean Architecture)
* Convention Plugin and Gradle Version Catalog
* Adaptive Layout (Foldable and Large Screens)
* Better handling navigation (include nested navigation)
* Edge-to-edge UI
* Material 3 design
* Dynamic Theme
* Splashscreen API
* Flexible network lib (Ktor Client/Retrofit)
* Flexible injection (Dagger-Hilt/Koin)
* Custom Backend built with Ktor-Server

### Structural design pattern
The app is built with the Model-View-ViewModel (MVVM) is its structural design pattern that separates objects into three distinct groups:
- Models hold application data. They’re usually structs or simple classes.
- Views display visual elements and controls on the screen. They’re typically subclasses of UIView.
- View models transform model information into values that can be displayed on a view. They’re usually classes, so they can be passed around as references.


## Tech Stack.
- [Kotlin](https://developer.android.com/kotlin) - Kotlin is a programming language that can run on JVM. Google has announced Kotlin as one of its officially supported programming languages in Android Studio; and the Android community is migrating at a pace from Java to Kotlin.
- [Material 3](https://m3.material.io/foundations/accessible-design/overview) - Latest Material design for Android.
- Jetpack components:
    - [Jetpack Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments. These components help you produce better-organized, and often lighter-weight code, that is easier to maintain.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) -The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.
    - [Paging 3 library](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) - The Paging library helps you load and display pages of data from a larger dataset from local storage or over network. This approach allows your app to use both network bandwidth and system resources more efficiently.
- [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) - A concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
- [Kotlin Flow](https://developer.android.com/kotlin/flow) - In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value.
- [Room](https://developer.android.com/jetpack/androidx/releases/room?gclid=CjwKCAjww8mWBhABEiwAl6-2RXqgw6-tYMdlLGJiAhLnEl9PNim-Sz8lx9P6JCaOD9qfQQojs-4DoRoCPkAQAvD_BwE&gclsrc=aw.ds) - Modern SQLite build on top of traditional SQLite, use for local database storage.
- [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - A dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
- [Coil](https://coil-kt.github.io/coil/compose/)- An image loading library for Android backed by Kotlin Coroutines.
