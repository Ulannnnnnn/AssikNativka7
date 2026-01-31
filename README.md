# Assignment 7 – Native Mobile Development (Android)

##  Project Overview
This project is an Android application developed using **Kotlin** and **Jetpack Compose** as part of Assignment 7 for the Native Mobile Development course.  
The application demonstrates UI development with Compose, basic state management, data persistence, and network data loading.

---

##  Technologies Used
- **Kotlin**
- **Android Studio**
- **Jetpack Compose**
- **Material 3**
- **SharedPreferences** (for local data storage)
- **REST API** (JSONPlaceholder)
- **Git & GitHub**

---

## Project Structure
The project follows a modular and clean structure:

```

com.example.assigmment7
│
├── model          # Data models (UserProfile, Post)
├── network        # API service for network requests
├── storage        # Local storage (SharedPreferences)
├── ui             # UI screens (ProfileScreen, PostsScreen)
│   └── theme      # App theme and styles
├── viewmodel      # ViewModels (if used)
└── MainActivity   # App entry point

```

---

##  Features Implemented

###  Profile Screen
- Input fields for **Name**, **Email**, and **Age**
- Input validation:
  - Email format validation
  - Age must be greater than 0
- Save user data locally using **SharedPreferences**
- Automatically loads saved data on app start

###  Posts Screen
- Loads posts from a public REST API
- Displays posts in a scrollable list
- Uses modern Compose UI components

###  UI & UX
- Built fully with **Jetpack Compose**
- Uses **Material 3** components
- Responsive layout
- Clean and minimal design

---

## How to Run the Project
1. Open the project in **Android Studio**
2. Make sure an emulator or physical device is available
3. Click **Run **
4. The app will launch automatically

---

##  API Used
- JSONPlaceholder  
  https://jsonplaceholder.typicode.com/posts

 <img width="974" height="503" alt="image" src="https://github.com/user-attachments/assets/484809d8-e915-4bb9-9b75-4fbd24bbde98" />

<img width="974" height="507" alt="image" src="https://github.com/user-attachments/assets/0f819c9a-0284-4f98-9637-53857286fc0d" />

<img width="974" height="519" alt="image" src="https://github.com/user-attachments/assets/ad0c1185-438e-4a58-852a-1f8c2ad76d8f" />
<img width="974" height="529" alt="image" src="https://github.com/user-attachments/assets/701d540d-b6c9-42ef-8f9c-d7dff258a9b6" />
<img width="1366" height="736" alt="image" src="https://github.com/user-attachments/assets/945ef262-a3bf-4c0a-98b5-930e22b4166e" />
