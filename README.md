DailyPulse

Self practice repo on Kotlin Multiplatform 

Daily Pulse includes a native Android and a native iOS apps, where the business logic and inftrastructure is shared in a KMP module.

Daily Pulse is using the news API to fetch, cache and display the top US business articles. It also contains a screen to display the list of news sources we use to fetch the articles from. Finally, it contains third screen to display informartion regarding the user's device.
Tech Stack

It is a prototype app based on the following technologies and patterns:

    Clean Architecture
    MVI
    Ktor
    SQL Delight
    Koin
    Jetpack Compose
    Swift UI

Architectural Diagram
The UI/Framework layers reside in the native apps, while everything from the View Model up to Data layer is in the common KMP module.

![kmp_architecture](https://github.com/user-attachments/assets/ea9c292e-0324-4b4e-92e0-31475381d016)

Architectural Layers

<img width="531" alt="kmp_arch_layer" src="https://github.com/user-attachments/assets/8cc06294-c536-430d-8bc0-d24b2180d52e" />

