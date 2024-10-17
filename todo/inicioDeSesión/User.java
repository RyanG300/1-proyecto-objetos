package inicioDeSesión;

import casillaObjetos.Character;
import casillaObjetos.CharacterRepository;

import java.util.HashMap;
import java.util.Map;


public class User {
    private String userName;
    private int matchesPlayed;
    private int matchesWon;
    private int matchesLost;
    private Map<String, CharacterStats> charactersStatsMap;

    public User(String userName) {
        this.userName = userName;
        this.matchesPlayed = 0;
        this.matchesWon = 0;
        this.matchesLost = 0;
        this.charactersStatsMap = new HashMap<>();

        for (Character character : CharacterRepository.CHARACTERS) {
            charactersStatsMap.put(character.getName(), new CharacterStats());
        }
    }



    public void updateCharacterStats(String characterName, boolean kill, boolean towerKill, boolean death) {
        CharacterStats stats = charactersStatsMap.get(characterName);
        if (stats != null) {
            if (kill) stats.incrementKills();
            if (towerKill) stats.incrementTowerKills();
            if (death) stats.incrementDeaths();
        }
    }

    public static User loadOrCreateUser(String userName) {
        User user = JsonHandler.loadUserData(userName);
        if (user == null || !user.userName.equals(userName)) {
            user = new User(userName);
            JsonHandler.saveUserData(user); // Guardar el nuevo jugador
        }

        return user;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public void incrementMatchesPlayed() {
        matchesPlayed++;
    }

    public void incrementMatchesWon() {
        matchesWon++;
    }

    public void incrementMatchesLost() {
        matchesLost++;
    }

    public void incrementCharacterKills(String characterName) {
        CharacterStats stats = charactersStatsMap.get(characterName);
        if (stats != null) {
            stats.incrementKills();
        }
    }

    public void incrementCharacterDeaths(String characterName) {
        CharacterStats stats = charactersStatsMap.get(characterName);
        if (stats != null) {
            stats.incrementDeaths();
        }
    }

    public void incrementCharacterTowerKills(String characterName) {
        CharacterStats stats = charactersStatsMap.get(characterName);
        if (stats != null) {
            stats.incrementTowerKills();
        }
    }

    public String getUserName() {
        return userName;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public CharacterStats getCharacterStats(String characterName) {
        return charactersStatsMap.get(characterName);
    }

    public void initializeCharacterStats(String characterName) {
        charactersStatsMap.putIfAbsent(characterName, new CharacterStats());
    }

    public String getCharacterWithMostKills() {
        return charactersStatsMap.entrySet().stream()
                .max(Map.Entry.comparingByValue((a, b) -> Integer.compare(a.getKills(), b.getKills())))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public String getCharacterWithMostDeaths() {
        return charactersStatsMap.entrySet().stream()
                .max(Map.Entry.comparingByValue((a, b) -> Integer.compare(a.getDeaths(), b.getDeaths())))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public String getCharacterWithMostTowerKills() {
        return charactersStatsMap.entrySet().stream()
                .max(Map.Entry.comparingByValue((a, b) -> Integer.compare(a.getTowerKills(), b.getTowerKills())))
                .map(Map.Entry::getKey)
                .orElse(null);
    }


    public static class CharacterStats implements Comparable<CharacterStats> {
        private int kills;
        private int deaths;
        private int towerKills;

        public CharacterStats() {
            this.kills = 0;
            this.deaths = 0;
            this.towerKills = 0;
        }

        @Override
        public int compareTo(CharacterStats other) {
            return Integer.compare(this.kills, other.kills);
        }

        public int getKills() {
            return kills;
        }

        public void incrementKills() {
            kills++;
        }

        public int getDeaths() {
            return deaths;
        }

        public void incrementDeaths() {
            deaths++;
        }

        public int getTowerKills() {
            return towerKills;
        }

        public void incrementTowerKills() {
            towerKills++;
        }
    }
}