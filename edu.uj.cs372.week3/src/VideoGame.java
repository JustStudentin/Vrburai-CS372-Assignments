public class VideoGame
{
    //Fields
    private int gameId;
    private String title;
    private String developer;
    private String genre;
    private String platform;
    private int releaseYear;
    private boolean isCompleted;
    private double rating;

    //Constructor
    public VideoGame(int gameId, String title, String developer, 
                String genre, String platform, int releaseYear,
                boolean isCompleted, double rating)
    {
        this.gameId = gameId;
        this.title = title;
        this.developer = developer;
        this.genre = genre;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.isCompleted = isCompleted;
        this.rating = rating; 
    }

    //Stringify the games
    @Override
    public String toString()
    {
        return "Game ID: " + gameId +
               ", Title: " + title +
               ", Developer: " + developer +
               ", Genre: " + genre +
               ", Platform: " + platform +
               ", Release Year: " + releaseYear +
               ", Completed: " + isCompleted +
               ", Rating: " + rating + "/10";
    }

    //Getters
    
    public int getGameId()
    {
        return gameId;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDeveloper()
    {
        return developer;
    }

    public String getGenre()
    {
        return genre;
    }

    public String getPlatform()
    {
        return platform;
    }

    public int getReleaseYear()
    {
        return releaseYear;
    }

    public boolean isCompleted()
    {
        return isCompleted;
    }

    public double getRating()
    {
        return rating;
    }

}