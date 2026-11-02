import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoGameManager
{
    //Collection to store video games
    private Map<Integer, VideoGame> gameLibrary;

    //Constructor
    public VideoGameManager()
    {
        gameLibrary = new HashMap<>();
    }

    //Add a new game to the library
    public void addGame(VideoGame game)
    {
        if (!gameLibrary.containsKey(game.getGameId()))
        {
            gameLibrary.put(game.getGameId(), game);
        }

        else
        {
            System.out.println("Game with ID " + game.getGameId() + " already exists.");
        }
    }

    //Remove a game from the library by its ID
    public void removeGame(int gameId)
    {
        gameLibrary.remove(gameId);
    }

    //Get a game by its ID
    public VideoGame getGame(int gameId)
    {
        return gameLibrary.get(gameId);
    }

    //Get all games in the library
    public List<VideoGame> getAllGames()
    {
        return new ArrayList<>(gameLibrary.values());
    }

    public List<VideoGame> filterByGenre(String genre)
    {
        List<VideoGame> filteredGames = new ArrayList<>();

        for (VideoGame game : gameLibrary.values())
        {
            if (game.getGenre().equalsIgnoreCase(genre))
            {
                filteredGames.add(game);
            }
        }

        return filteredGames;
    }

    //Get the total number of games in the library
    public int getTotalGameCount()
    {
        return gameLibrary.size();
    }

    //Display all games in the library
    public void displayAllGames()
    {
        for (VideoGame game : gameLibrary.values())
        {
            System.out.println(game);
        }
    }

    //Filter games by platform
    public List<VideoGame> filterByPlatform(String platform)
    {
        List<VideoGame> filteredGames = new ArrayList<>();

        for (VideoGame game : gameLibrary.values())
        {
            if (game.getPlatform().equalsIgnoreCase(platform))
            {
                filteredGames.add(game);
            }
        }

        return filteredGames;
    }

    public int getCompletedGameCount()
    {
        int completedCount = 0;

        for (VideoGame game : gameLibrary.values())
        {
            if (game.isCompleted())
            {
                completedCount++;
            }
        }

        return completedCount;
    }
}