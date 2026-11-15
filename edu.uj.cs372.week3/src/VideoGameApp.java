import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.control.ListCell;

public class VideoGameApp extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        VideoGameManager manager = new VideoGameManager();
        loadSampleGames(manager);

        Label titleLabel = new Label("Video Game Library");
        Button testButton = new Button("Click Me!");

        ListView<VideoGame> gameListView = new ListView<>();
        gameListView.getItems().addAll(manager.getAllGames());
        gameListView.setCellFactory(listView -> new ListCell<VideoGame>()
        {
            @Override
            protected void updateItem(VideoGame game, boolean empty)
            {
                super.updateItem(game, empty);

                if (empty || game == null)
                {
                    setText(null);
                }
                else
                {
                    String completionStatus = game.isCompleted()
                        ? "Completed" : "Not Completed";

                    setText(
                        game.getTitle() +
                        " | " + game.getGenre() +
                        " | " + game.getPlatform() +
                        " | Rating: " + game.getRating() + "/10" +
                        " | " + completionStatus
                    );
                }
            }
        });
        
        Label gameDetailsLabel = new Label("Select a game to view its details.");
        gameDetailsLabel.setWrapText(true);
        gameListView.getSelectionModel().selectedItemProperty().addListener
        (
            (observable, oldGame, selectedGame) -> 
            {
                if (selectedGame == null)
                {
                    gameDetailsLabel.setText(
                        "Select a game to view its details."
                    );
                }
                else
                {
                    gameDetailsLabel.setText(
                        "Title: " + selectedGame.getTitle() +
                        "\nDeveloper: " + selectedGame.getDeveloper() +
                        "\nGenre: " + selectedGame.getGenre() +
                        "\nPlatform: " + selectedGame.getPlatform() +
                        "\nRelease Year: " + selectedGame.getReleaseYear() +
                        "\nCompleted: " +
                            (selectedGame.isCompleted() ? "Yes" : "No") +
                        "\nRating: " + selectedGame.getRating() + "/10"
                    );
                }
            }
        );
        
        TextField titleField = new TextField();
        titleField.setPromptText("Enter game title");

        TextField developerField = new TextField();
        developerField.setPromptText("Enter developer");

        ComboBox<String> genreBox = new ComboBox<>();
        genreBox.getItems().addAll
        (
            "RPG",
            "Action-Adventure",
            "Shooter",
            "Sandbox",
            "Metroidvania",
            "Platformer",
            "Simulation",
            "Strategy",
            "Puzzle",
            "Other"
        );
        genreBox.setPromptText("Select a genre");

        TextField platformField = new TextField();
        platformField.setPromptText("Enter platform");

        TextField yearField = new TextField();
        yearField.setPromptText("Enter release year");

        CheckBox completedCheckBox = new CheckBox("Completed");

        TextField ratingField = new TextField();
        ratingField.setPromptText("Enter rating (0-10)");

        GridPane inputGrid = new GridPane();

        inputGrid.setHgap(10);
        inputGrid.setVgap(10);

        inputGrid.add(new Label("Title:"), 0, 0);
        inputGrid.add(titleField, 1, 0);

        inputGrid.add(new Label("Developer:"), 0, 1);
        inputGrid.add(developerField, 1, 1);

        inputGrid.add(new Label("Genre:"), 0, 2);
        inputGrid.add(genreBox, 1, 2);

        inputGrid.add(new Label("Platform:"), 0, 3);
        inputGrid.add(platformField, 1, 3);

        inputGrid.add(new Label("Release Year:"), 0, 4);
        inputGrid.add(yearField, 1, 4);

        inputGrid.add(new Label("Completed:"), 0, 5);
        inputGrid.add(completedCheckBox, 1, 5);

        inputGrid.add(new Label("Rating:"), 0, 6);
        inputGrid.add(ratingField, 1, 6);

        Button addGameButton = new Button("Add Game");   
        addGameButton.setOnAction(event -> 
        {
            try
            {
                // Retrieve user input
                String gameTitle = titleField.getText().trim();
                String developer = developerField.getText().trim();
                String genre = genreBox.getValue();
                String platform = platformField.getText().trim();
                String yearText = yearField.getText().trim();
                boolean completed = completedCheckBox.isSelected();
                String ratingText = ratingField.getText().trim();

                // Check for missing information
                if (gameTitle.isEmpty() || developer.isEmpty() ||
                    genre == null || platform.isEmpty() ||
                    yearText.isEmpty() || ratingText.isEmpty())
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText("Missing Information");
                    alert.setContentText("Please complete all fields.");
                    alert.showAndWait();
                    return;
                }

                // Convert numeric inputs
                int releaseYear = Integer.parseInt(yearText);
                double rating = Double.parseDouble(ratingText);

                // Check for invalid numeric values
                if (releaseYear < 1950 || releaseYear > 2100 ||
                    !Double.isFinite(rating) || rating < 0 || rating > 10)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText("Invalid Year or Rating");
                    alert.setContentText(
                        "Enter a year between 1950 and 2100 " +
                        "and a rating between 0 and 10."
                    );
                    alert.showAndWait();
                    return;
                }

                // Generate a unique ID
                int gameId = manager.getNextGameId();

                // Create the new VideoGame object
                VideoGame newGame = new VideoGame(
                    gameId,
                    gameTitle,
                    developer,
                    genre,
                    platform,
                    releaseYear,
                    completed,
                    rating
                );

                // Add the game to our collection
                manager.addGame(newGame);

                // Update the graphical list
                gameListView.getItems().setAll(manager.getAllGames());

                // Clear the input fields
                titleField.clear();
                developerField.clear();
                genreBox.setValue(null);
                platformField.clear();
                yearField.clear();
                completedCheckBox.setSelected(false);
                ratingField.clear();

                System.out.println("Game added successfully!");
            }
            catch (NumberFormatException e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Invalid Number");
                alert.setContentText(
                    "Release year must be a whole number, " +
                    "and rating must be a valid number."
                );
                alert.showAndWait();
            }
            
        });

        Button removeGameButton = new Button("Remove Selected Game");
        removeGameButton.setOnAction(event -> 
        {
            // Get the currently selected game
            VideoGame selectedGame = gameListView
                .getSelectionModel()
                .getSelectedItem();

            // Check whether a game was selected
            if (selectedGame == null)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Game Selected");
                alert.setHeaderText("Selection Required");
                alert.setContentText(
                    "Please select a game from the list before removing it."
                );
                alert.showAndWait();
                return;
            }

            // Remove the selected game from the manager
            manager.removeGame(selectedGame.getGameId());

            // Refresh the graphical list
            gameListView.getItems().setAll(manager.getAllGames());

            System.out.println(
                "Removed game: " + selectedGame.getTitle()
            );
        });

        //testButton.setOnAction(event -> 
        //{
        //    titleLabel.setText("Welcome to your Video Game Library!");
        //});

        
        ComboBox<String> filterGenreBox = new ComboBox<>();

        filterGenreBox.getItems().addAll
        (
            "RPG",
            "Action-Adventure",
            "Shooter",
            "Sandbox",
            "Metroidvania",
            "Platformer",
            "Simulation",
            "Strategy",
            "Puzzle",
            "Other"
        );

        filterGenreBox.setPromptText("Select genre to filter");

        Button filterButton = new Button("Filter by Genre");
        Button showAllButton = new Button("Show All Games");


        filterButton.setOnAction(event -> 
        {
            String selectedGenre = filterGenreBox.getValue();

            if (selectedGenre == null)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Genre Selected");
                alert.setHeaderText("Selection Required");
                alert.setContentText
                (
                    "Please select a genre before filtering."
                );
                alert.showAndWait();
                return;
            }

            gameListView.getItems().setAll
            (
                manager.filterByGenre(selectedGenre)
            );
        });

        showAllButton.setOnAction(event -> 
        {
            gameListView.getItems().setAll(manager.getAllGames());
            filterGenreBox.setValue(null);
        });

        VBox layout = new VBox(15);
        HBox filterLayout = new HBox(10);
        filterLayout.getChildren().addAll
        (
            filterGenreBox,
            filterButton,
            showAllButton
        );

        layout.getChildren().addAll
        (
            titleLabel,
            gameListView,
            gameDetailsLabel,
            filterLayout,
            inputGrid,
            addGameButton,
            removeGameButton,
            //testButton
        );

        Scene scene = new Scene(layout, 700, 700);
        primaryStage.setTitle("Video Game Library Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


private void loadSampleGames(VideoGameManager manager)
{
    manager.addGame(new VideoGame(1, "Final Fantasy X",
        "Square Enix", "RPG", "PlayStation 2",
        2001, true, 9.5));

    manager.addGame(new VideoGame(2,
        "The Legend of Zelda: Breath of the Wild",
        "Nintendo", "Action-Adventure", "Nintendo Switch",
        2017, false, 9.8));

    manager.addGame(new VideoGame(3, "Overwatch 2",
        "Blizzard Entertainment", "Shooter", "PC",
        2022, false, 8.5));

    manager.addGame(new VideoGame(4, "Minecraft",
        "Mojang Studios", "Sandbox", "PC",
        2011, true, 9.0));

    manager.addGame(new VideoGame(5, "The Witcher 3: Wild Hunt",
        "CD Projekt Red", "RPG", "PC",
        2015, true, 9.7));

    manager.addGame(new VideoGame(6, "Hollow Knight",
        "Team Cherry", "Metroidvania", "PC",
        2017, false, 9.2));

    manager.addGame(new VideoGame(7, "Celeste",
        "Matt Makes Games", "Platformer", "PC",
        2018, true, 9.3));

    manager.addGame(new VideoGame(8, "Stardew Valley",
        "ConcernedApe", "Simulation", "PC",
        2016, false, 9.1));
}

    public static void main(String[] args)
    {
        launch(args);
    }
}
