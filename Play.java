import java.util.*;

interface Player {
    void setName(String name);
    String getName();
    void setStatistics(Statistics stats);
    void getStatistics();
}

interface Game {
    void playGame();
}
class Statistics {
    int matches;
    int totalGoalsOrWickets;
    int winsRegional;
    int winsNational;
    int winsInternational;

    public Statistics(int matches, int totalGoalsOrWickets, int winsRegional, int winsNational, int winsInternational) {
        this.matches = matches;
        this.totalGoalsOrWickets = totalGoalsOrWickets;
        this.winsRegional = winsRegional;
        this.winsNational = winsNational;
        this.winsInternational = winsInternational;
    }

    public double getAverage() {
        return matches == 0 ? 0 : (double) totalGoalsOrWickets / matches;
    }
}

class Football implements Player, Game {
    private String name;
    private Statistics stats;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setStatistics(Statistics stats) {
        this.stats = stats;
    }

    @Override
    public void getStatistics() {
        System.out.println("Football Player: " + name);
        System.out.println("Matches Played: " + stats.matches);
        System.out.println("Total Goals: " + stats.totalGoalsOrWickets);
        System.out.println("Average Goals per Match: " + stats.getAverage());
        System.out.println("Wins - Regional: " + stats.winsRegional + ", National: " + stats.winsNational + ", International: " + stats.winsInternational);
    }

    @Override
    public void playGame() {
        System.out.println(name + " is playing Football.");
    }
}

class Cricket implements Player, Game {
    private String name;
    private Statistics stats;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setStatistics(Statistics stats) {
        this.stats = stats;
    }

    @Override
    public void getStatistics() {
        System.out.println("Cricket Player: " + name);
        System.out.println("Matches Played: " + stats.matches);
        System.out.println("Total Wickets: " + stats.totalGoalsOrWickets);
        System.out.println("Average Wickets per Match: " + stats.getAverage());
        System.out.println("Wins - Regional: " + stats.winsRegional + ", National: " + stats.winsNational + ", International: " + stats.winsInternational);
    }

    @Override
    public void playGame() {
        System.out.println(name + " is playing Cricket.");
    }
}

class Basketball implements Player, Game {
    private String name;
    private Statistics stats;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setStatistics(Statistics stats) {
        this.stats = stats;
    }

    @Override
    public void getStatistics() {
        System.out.println("Basketball Player: " + name);
        System.out.println("Matches Played: " + stats.matches);
        System.out.println("Total Points: " + stats.totalGoalsOrWickets);
        System.out.println("Average Points per Match: " + stats.getAverage());
        System.out.println("Wins - Regional: " + stats.winsRegional + ", National: " + stats.winsNational + ", International: " + stats.winsInternational);
    }

    @Override
    public void playGame() {
        System.out.println(name + " is playing Basketball.");
    }
}

class Play {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();

        System.out.println("Enter number of players:");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player's name:");
            String name = scanner.nextLine();

            System.out.println("Select Sport (1: Football, 2: Cricket, 3: Basketball):");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Matches Played:");
            int matches = scanner.nextInt();
            System.out.println("Enter Total Goals (for Football)/ Wickets (for Cricket)/ Points (for Basketball):");
            int totalGoalsOrWickets = scanner.nextInt();
            System.out.println("Enter Wins (Regional, National, International):");
            int winsRegional = scanner.nextInt();
            int winsNational = scanner.nextInt();
            int winsInternational = scanner.nextInt();
            scanner.nextLine();

            Statistics stats = new Statistics(matches, totalGoalsOrWickets, winsRegional, winsNational, winsInternational);
            Player player;

            switch (choice) {
                case 1:
                    player = new Football();
                    break;
                case 2:
                    player = new Cricket();
                    break;
                case 3:
                    player = new Basketball();
                    break;
                default:
                    System.out.println("Invalid choice, skipping player.");
                    continue;
            }

            player.setName(name);
            player.setStatistics(stats);
            players.add(player);
        }

        System.out.println("\nPlayer Statistics:");
        for (Player p : players) {
            p.getStatistics();
            System.out.println("---------------------------");
        }

        scanner.close();
    }
}