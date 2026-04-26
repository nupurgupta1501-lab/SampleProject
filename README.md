**VideoURL for Sample App**
https://www.dropbox.com/scl/fi/g08vzeihtb5bxu6dty05q/Screen_recording_20260426_234702.webm?rlkey=vm4e66cbapct1ds1p82osc54e&st=d9fiyyzj&dl=0

**Screenshots**

<img width="1080" height="2400" alt="Screenshot_20260426_234154" src="https://github.com/user-attachments/assets/78416c40-32c6-4dbb-834f-6f8546d4961f" />
<img width="1080" height="2400" alt="Screenshot_20260426_234206" src="https://github.com/user-attachments/assets/fc7a2ed0-aff9-423b-bd6c-004917fe8d2d" />


**Overview**

This project is a sample Android application built to demonstrate modern Android development practices using a modularized architecture. 
The app consists of two main screens:

1) User List Screen – Displays a list of users fetched from a remote API
2) User Detail Screen – Shows detailed information for a selected user

 **Architecture**

The project follows a modularized MVVM (Model-View-ViewModel) architecture with clear separation of concerns.

**Modules**
1) app → Entry point, navigation setup
2) core → Common utilities, base classes, UI components
3) data → API services, DTOs, repository implementations
4) domain → Business logic, use cases, models
5) feature-user → UI layer (Compose screens, ViewModels)
   
**Tech Stack**
1) Kotlin – Primary programming language
2) Jetpack Compose – Modern UI toolkit
3) MVVM Architecture – Separation of UI and business logic
4) Hilt (Dagger) – Dependency Injection
5) Coroutines & Flow – Asynchronous programming
6) Retrofit – Network layer
7) StateFlow – UI state management
8) Navigation Compose – Navigation between screens
9) JUnit & Mockito – Unit testing
    
**API**
Primary API:
https://fake-json-api.mock.beeceptor.com/users

**Features**
1) Fetch and display a list of users
2) Navigate to detail screen on item click
3) Handle loading, success, and error states
4) Clean separation between layers
5) Reactive UI using StateFlow

**Testing**

Unit tests are included for:
ViewModels

**Tools used:**
JUnit
Mockito / MockK
Coroutines Test

**Package Structure**
<img width="352" height="565" alt="Screenshot 2026-04-26 at 11 39 35 PM" src="https://github.com/user-attachments/assets/e34b1609-d517-475d-b9db-d4a0485b34c8" />

**Assumptions**
1) API response structure is stable and predictable
2) Internet connectivity is available
3) Minimal UI/UX focus (functional implementation prioritized)
   
**Improvements (Future Scope)**
Implement offline caching (Room Database)
Add UI tests (Espresso / Compose UI Testing)
Improve error handling and retry mechanisms
Implement multi-module dependency optimization
Add CI/CD pipeline
