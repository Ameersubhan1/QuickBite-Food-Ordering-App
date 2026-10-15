<div align="center">

# 🍔 QuickBite

### A food delivery Android app built with Java & Firebase

Browse restaurants, order your favourite meals, and track your delivery in real time.

![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)
![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)
![Backend](https://img.shields.io/badge/Backend-Firebase-FFCA28?logo=firebase&logoColor=black)
![IDE](https://img.shields.io/badge/IDE-Android%20Studio-3DDC84?logo=androidstudio&logoColor=white)

</div>

---

## 📽️ Demo Video

<!--
  HOW TO ADD THE VIDEO (pick ONE option):

  OPTION 1 (recommended): On GitHub, click the pencil icon to edit this README,
  then drag & drop your .mp4 file right here. GitHub uploads it and inserts a
  link that plays inline. (Free accounts: max 10 MB per video.)

  OPTION 2: Upload the video to YouTube, then use a clickable thumbnail:
  [![QuickBite Demo](https://img.youtube.com/vi/YOUR_VIDEO_ID/maxresdefault.jpg)](https://www.youtube.com/watch?v=YOUR_VIDEO_ID)

  Delete this comment once done.
-->

https://github.com/Ameersubhan1/QuickBite-Food-Ordering-App/blob/main/QuickBite(updated)/VIDEO-2026-10-15-18-51-56%20(1).mp4

---

## 📖 About the Project

**QuickBite** is a native Android application that makes ordering food simple and fast. Users can create an account, explore nearby restaurants, browse categorised menus, place an order, track it on a map, and leave a rating once it arrives.

The app is written in **Java** using **Android Studio**, with **Firebase** powering authentication and real-time data storage.

---

## ✨ Features

- 🔐 **User Authentication** – Sign up, log in, and log out securely
- 🏠 **Home Screen** – Promotional offers and a list of nearby restaurants
- 📋 **Categorised Menus** – Starters, Pizzas, Burgers, Drinks and more
- 🛒 **Cart & Checkout** – Add items, enter delivery details, and choose a payment method
- 📍 **Order Tracking** – Follow your order status on a live map
- ⭐ **Ratings & Feedback** – Rate your experience and submit feedback after delivery
- 🕘 **Order History** – View all your previous orders
- 👤 **User Profile** – View and manage your account information
- ☁️ **Real-time Sync** – Data stored and updated instantly with Firebase

---

## 🛠️ Tech Stack

| Category        | Technology                          |
| --------------- | ----------------------------------- |
| Language        | Java                                |
| IDE             | Android Studio                      |
| Platform        | Android (Min SDK: _add yours_)      |
| Backend / DB    | Firebase Realtime Database          |
| Authentication  | Firebase Authentication             |
| Maps            | Google Maps SDK                     |
| Build System    | Gradle                              |

---

## 📸 Screenshots

| Login | Home | Menu |
| :---: | :---: | :---: |
| <img src="screenshots/login.png" width="200"/> | <img src="screenshots/home.png" width="200"/> | <img src="screenshots/menu.png" width="200"/> |

| Checkout | Track Order | Profile |
| :---: | :---: | :---: |
| <img src="screenshots/checkout.png" width="200"/> | <img src="screenshots/track.png" width="200"/> | <img src="screenshots/profile.png" width="200"/> |

> 💡 Create a `screenshots/` folder in the repo and add your images with the names above.

---

## 📂 Project Structure

```
QuickBite-Food-Ordering-App/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/quickbite/
│   │   │   ├── MainActivity.java
│   │   │   ├── ProfileActivity.java
│   │   │   ├── OrderHistoryActivity.java
│   │   │   └── ...
│   │   ├── res/                 # Layouts, drawables, strings
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── screenshots/
├── build.gradle
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- [Android Studio](https://developer.android.com/studio) (latest stable version)
- JDK 11 or higher
- An Android device or emulator (API level _add yours_ or above)
- A Firebase account

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Ameersubhan1/QuickBite-Food-Ordering-App.git
   ```

2. **Open the project** in Android Studio and let Gradle sync.

3. **Set up Firebase**
   - Go to the [Firebase Console](https://console.firebase.google.com/) and create a new project
   - Add an Android app with the package name `com.example.quickbite`
   - Download `google-services.json` and place it inside the `app/` folder
   - Enable **Authentication** (Email/Password) and **Realtime Database**

4. **Add your Google Maps API key** (needed for order tracking)
   - Add the key to `AndroidManifest.xml` or `local.properties`

5. **Run the app** on an emulator or a physical device ▶️

> ⚠️ `google-services.json` and API keys are not included in this repository for security reasons.

---

## 🧭 How to Use

1. Create an account or log in
2. Choose a restaurant from the home screen
3. Add items from the menu to your cart
4. Go to checkout, enter your address and pick a payment method
5. Place the order and track it on the map
6. Rate your order and leave feedback

---

## 🔮 Future Improvements

- [ ] Online payment gateway integration
- [ ] Push notifications for order updates
- [ ] Restaurant search and filters
- [ ] Favourites and saved addresses
- [ ] Admin / restaurant dashboard
- [ ] Dark mode

---

## 🤝 Contributing

Contributions, issues and feature requests are welcome! Feel free to open an issue or submit a pull request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m "Add AmazingFeature"`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Ameer Subhan**

- GitHub: [@Ameersubhan1](https://github.com/Ameersubhan1)
- LinkedIn: [your-linkedin](https://www.linkedin.com/in/ameer-subhan-hussain-a86837295/)
- Email: ameersubhan568@gmail.com

<div align="center">

⭐ If you like this project, please give it a star!

</div>
