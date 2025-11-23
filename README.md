# 🏆 MVP Leaderboard — Sportsdunia Assignment

This project implements the MVP (Most Valuable Player) Leaderboard required for the Sportsdunia Mobile Application Developer assessment. The system fetches player and event data, computes MVP scores based on the provided rules, sorts the players, and displays the leaderboard with a toggle for top performers.

---

## 🔧 Technologies Used

### Frontend
- React.js
- Axios (for API calls)
- CSS (custom styling)

### Backend
- Spring Boot (Java)
- Jackson (JSON parsing)
- Maven

---

## 📌 Features Implemented

### ✔ MVP Score Calculation
The backend computes a score for every player using the following rules:

| Action                | Points |
|----------------------|--------|
| TAKE_WICKET          | +20    |
| 50_RUNS_MILESTONE    | +15    |
| HIT_SIX              | +2     |
| HIT_FOUR             | +1     |

### ✔ Sorted Leaderboard
- Players are sorted by MVP score in **descending order**
- Dense ranking format is used (1, 2, 3…)

### ✔ Toggle Top Performers
- A button switches between:
  - Showing **all players**
  - Showing players with **score ≥ 20**

### ✔ Clean UI Design
- Card-based layout
- Responsive styling
- Highlighted score and rank indicators

---

## 📁 Folder Structure

# Project Structure — MVP Leaderboard Assignment

MVP-Leaderboard-Assignment/
│
├── backend/                          # Spring Boot Backend
│   ├── pom.xml
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/mvp/
│   │   │   │   ├── controller/
│   │   │   │   │   └── LeaderboardController.java
│   │   │   │   ├── service/
│   │   │   │   │   └── LeaderboardService.java
│   │   │   │   ├── model/
│   │   │   │   │   ├── Player.java
│   │   │   │   │   ├── Event.java
│   │   │   │   │   └── RankedPlayer.java
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       ├── players.json
│   │   │       └── events.json
│   │   └── test/
│
├── frontend/                         # React + Vite Frontend
│   ├── package.json
│   ├── vite.config.js
│   ├── src/
│   │   ├── App.jsx
│   │   ├── index.css
│   │   └── components/
│   │       ├── Leaderboard.jsx
│   │       └── Leaderboard.css
│   └── public/
│
└── output/                           # Documentation + Screenshots
    ├── full_leaderboard.png
    ├── top_performers.png
    └── explanation.md



---

## 🚀 How to Run the Project

### 1. Start Backend (Spring Boot)

bash :
    cd backend
    mvn spring-boot:run

Backend API URL :
    http://localhost:8080/api/leaderboard

### Start Frontend (React)

bash :
    cd frontend
    npm install
    npm start

Frontend URL:
    http://localhost:3000/


---

## 🖼 Screenshots
- Full Leaderboard → `output/Full Leaderboard.jpg`
- Top Performers (≥20) → `output/Top Performers.jpg`

---

## 📄 Logic Summary
- Backend loads `players.json` & `events.json`
- Computes MVP scores from event rules
- Every player included even if score = 0
- Players sorted by descending score
- Dense ranking applied (1,2,3…)
- React frontend fetches data from backend API using Axios
- Toggle button filters players ≥ 20 points
- UI updates instantly with React state

---

## 🏁 Conclusion
This project fully satisfies the Sportsdunia MVP Leaderboard requirements:

✔ Correct MVP score calculation  
✔ Sorted leaderboard (high → low)  
✔ Toggle for top performers  
✔ Clean and responsive UI  
✔ Fully functional React + Spring Boot integration  

You can now run, review, and submit this project confidently.
