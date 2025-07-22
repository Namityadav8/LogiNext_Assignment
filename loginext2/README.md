# Simple Food Catalog App

## Overview
This is a basic Android application built in Kotlin, demonstrating a simple two-screen app with a cascading animated catalog of food items on the Home screen and an Order screen. A third tab is included as a placeholder.

### Features
- Bottom navigation with three tabs (Home, Order, More).
- Home screen shows a list of food items (name, price, placeholder image) in a RecyclerView.
- Cascading layout animation on the Home screen.
- Order screen stub for collecting user orders.
- Third tab is empty for future use.

## Architecture
- **Pattern**: MVI-lite (simple separation of UI and data logic).
- **Language**: Kotlin
- **UI**: XML layouts, RecyclerView

## Getting Started
### Prerequisites
- Android Studio 4.2+
- Android SDK with API level 21+

### Build and Run
1. Clone or unzip the project.
2. Open in Android Studio: `File > Open` and select the project folder.
3. Let Gradle sync and download dependencies.
4. Connect an Android device or start an emulator.
5. Run the app via the Run toolbar or `Shift+F10`.

## Project Structure (simplified)
```
app/
 ├─ src/main/java/com/example/loginext/
 │   ├─ MainActivity.kt
 │   ├─ HomeFragment.kt
 │   ├─ OrderFragment.kt
 │   ├─ ThirdFragment.kt
 │   ├─ FoodItem.kt
 │   └─ FoodAdapter.kt
 ├─ src/main/res/layout/
 │   ├─ activity_main.xml
 │   ├─ fragment_home.xml
 │   ├─ fragment_order.xml
 │   ├─ fragment_third.xml
 │   └─ item_food.xml
 ├─ src/main/res/menu/
 │   └─ bottom_nav_menu.xml
 ├─ src/main/res/navigation/
 │   └─ nav_graph.xml
 └─ src/main/res/anim/
     └─ layout_animation_fall_down.xml
```

## Notes and Assumptions
- No external API is used; data is hard-coded in `HomeFragment`.
- Images should be added manually to `res/drawable` with names like `food1.png`, etc.
- Variable names are kept simple for clarity.
- Basic unit test provided for `FoodAdapter`.

## Future Improvements
- Implement Order screen logic.
- Integrate real API.
- Add image loading with Glide.
- Improve UI styling.
