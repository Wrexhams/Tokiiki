package com.edujoy.cats.hockey.elo;

import java.util.HashMap;
import java.util.Map;

public class StatsManager {
    private Map<String, PlayerStats> stats;

    public StatsManager() {
        stats = new HashMap<>();
    }

    public void addPlayer(String playerId) {
        if (!stats.containsKey(playerId)) {
            stats.put(playerId, new PlayerStats());
        }
    }

    public void recordMatch(String playerId, int goals, int assists) {
        if (stats.containsKey(playerId)) {
            PlayerStats playerStats = stats.get(playerId);
            playerStats.addGoals(goals);
            playerStats.addAssists(assists);
        }
    }

    public PlayerStats getPlayerStats(String playerId) {
        return stats.get(playerId);
    }

    public static class PlayerStats {
        private int goals;
        private int assists;

        public PlayerStats() {
            this.goals = 0;
            this.assists = 0;
        }

        public void addGoals(int goals) {
            this.goals += goals;
        }

        public void addAssists(int assists) {
            this.assists += assists;
        }

        public int getGoals() {
            return goals;
        }

        public int getAssists() {
            return assists;
        }

        @Override
        public String toString() {
            return "Goals: " + goals + ", Assists: " + assists;
        }
    }
}
