package inicioDeSesión;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private User user1;
    private User user2;

    public MainFrame(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.setTitle("Statistics");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        displayStatistics();
    }

    private void displayStatistics() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        panel.add(new JLabel("Name: " + user1.getUserName()));
        panel.add(new JLabel("Matches Played: " + user1.getMatchesPlayed()));
        panel.add(new JLabel("Matches Won: " + user1.getMatchesWon()));
        panel.add(new JLabel("Matches Lost: " + user1.getMatchesLost()));
        panel.add(new JLabel("Total Deaths: " + user1.getTotalDeaths()));
        panel.add(new JLabel("Total Tower Kills: " + user1.getTotalTowerKills()));
        panel.add(new JLabel("Total Kills: " + user1.getTotalKills()));
        panel.add(new JLabel("Performance: " + user1.getPerformance() + "%"));
        add(panel);
    }
}
