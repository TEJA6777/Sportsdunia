import { useEffect, useState } from "react";
import axios from "axios";
import "./Leaderboard.css"; // import CSS file

const API_URL = "http://localhost:8080/api/leaderboard";

export default function Leaderboard() {
  const [players, setPlayers] = useState([]);
  const [topOnly, setTopOnly] = useState(false);

  useEffect(() => {
    axios.get(API_URL).then((res) => {
      setPlayers(res.data);
    });
  }, []);

  const filtered = topOnly ? players.filter((p) => p.score >= 20) : players;

  return (
    <div className="leaderboard-container">
      <h1 className="title">MVP Leaderboard</h1>

      <button className="toggle-btn" onClick={() => setTopOnly((p) => !p)}>
        {topOnly ? "Show All Players" : "Show Top Performers (≥ 20)"}
      </button>

      <div className="list-container">
        {filtered.map((p) => (
          <div className="player-card" key={p.id}>
            <div className="player-info">
              <span className="player-rank">#{p.rank}</span>
              <span className="player-name">{p.name}</span>
            </div>

            <div className="player-score">{p.score}</div>
          </div>
        ))}

        {filtered.length === 0 && (
          <p className="empty">No players to display.</p>
        )}
      </div>
    </div>
  );
}
