import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        VideoGameManager manager = new VideoGameManager();

        VideoGame game1 = new VideoGame(1, "Final Fantasy X", "Square Enix", "RPG", "PlayStation 2", 2001, true, 9.5);
        VideoGame game2 = new VideoGame(2, "The Legend of Zelda: Breath of the Wild", "Nintendo", "Action-Adventure", "Nintendo Switch", 2017, false, 9.8);
        VideoGame game3 = new VideoGame(3, "Overwatch 2", "Blizzard Entertainment", "Shooter", "PC", 2022, false, 8.5);
        VideoGame game4 = new VideoGame(4, "Minecraft", "Mojang Studios", "Sandbox", "PC", 2011, true, 9.0);
        VideoGame game5 = new VideoGame(5, "The Witcher 3: Wild Hunt", "CD Projekt Red", "RPG", "PC", 2015, true, 9.7);
        VideoGame game6 = new VideoGame(6, "Hollow Knight", "Team Cherry", "Metroidvania", "PC", 2017, false, 9.2);
        VideoGame game7 = new VideoGame(7, "Celeste", "Matt Makes Games", "Platformer", "PC", 2018, true, 9.3);
        VideoGame game8 = new VideoGame(8, "Stardew Valley", "ConcernedApe", "Simulation", "PC", 2016, false, 9.1);

        manager.addGame(game1);
        manager.addGame(game2);
        manager.addGame(game3);
        manager.addGame(game4);
        manager.addGame(game5);
        manager.addGame(game6);
        manager.addGame(game7);
        manager.addGame(game8);

        System.out.println("All Games in the Library:");
        manager.displayAllGames();

        System.out.println("\nFinding game with ID 3:");
        VideoGame foundGame = manager.getGame(3);
        if (foundGame != null)
        {
            System.out.println(foundGame);
        }
        else
        {
            System.out.println("Game not found.");
        }
        
        System.out.println("\nGames filtered by genre 'RPG':");
        List<VideoGame> rpgGames = manager.filterByGenre("RPG");
        for (VideoGame game : rpgGames)
        {
            System.out.println(game);
        }

        System.out.println("\nGames filtered by platform 'PC':");
        List<VideoGame> pcGames = manager.filterByPlatform("PC");
        for (VideoGame game : pcGames)
        {
            System.out.println(game);
        }

        System.out.println("\nTotal completed games: " + manager.getCompletedGameCount());
        System.out.println("\nTotal games in the library: " + manager.getTotalGameCount());

    }
}