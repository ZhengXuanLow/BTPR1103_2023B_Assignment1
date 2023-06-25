package com.example.gamemenu;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.stage.StageStyle;

import java.io.IOException;

public class gameMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {

       //Set the window cant be resize by user
       stage.setResizable(false);

       //Turn off the window bar
       //stage.initStyle(StageStyle.UNDECORATED);

       //Set the background image for the application.
       Image backgroundImage = new Image(gameMenu.class.getResource("reso.png").toString());
       ImageView BGimageView = new ImageView(backgroundImage);

       //Create a stackPane for further use
       StackPane stackPane =new StackPane();

       //Setting Resolution
       Scene scene = new Scene(stackPane, 1280, 720);

       //Setting the background image
       BGimageView.fitWidthProperty().bind(stackPane.widthProperty());
       BGimageView.fitHeightProperty().bind(stackPane.heightProperty());

       //Setting the Start Button
       Button startButton = new Button("Start");
       //Setting the button style
       startButton.setFont(Font.font("Garamond",18));
       startButton.setStyle("-fx-translate-x: 440px; -fx-translate-y: -45px;-fx-background-color: #f2f3f5;");
       //Set the button size
       startButton.setPrefWidth(350);
       startButton.setPrefHeight(20);

       //Insert the background image, title, description,title image, 3 social media icon, menuBoxMiddle, start button.
       stackPane.getChildren().addAll(BGimageView,titleLabel(),titleImage(),socialMediaBox(),menuBoxMiddle(),startButton);

       stage.setTitle("Resonark v4.0");
       stage.setScene(scene);
       stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public HBox menuBoxMiddle()
    {
        //Create the MenuBar
        MenuBar menuBar = new MenuBar();

        //Create the menu
        Menu menuMenu = new Menu("Setting");
        Menu docsMenu = new Menu("Help");
        Menu whitePaperMenu = new Menu("Exit");

        //Set the font colour to make it visible
        menuMenu.setStyle("-fx-color:#000000");
        docsMenu.setStyle("-fx-color:#000000");
        whitePaperMenu.setStyle("-fx-color:#000000");

        //Insert the menu element
        menuBar.getMenus().addAll(menuMenu,docsMenu,whitePaperMenu);
        //Set MenuBar Background Transparent
        menuBar.setStyle("-fx-background-color: transparent;");

        //Create a Horizontal Box to control to align
        HBox menuMiddleBox = new HBox(menuBar);
        menuMiddleBox.setAlignment(Pos.TOP_CENTER);

        //Set the style for the MenuBox including background colour, padding and size.
        menuMiddleBox.setStyle("-fx-background-color: transparent; -fx-padding: 10px;-fx-font-size: 14px;");

        return menuMiddleBox;

    }

    public VBox titleLabel()
    {
        //Setting the game title and the style.
        Label titleLabel = new Label("RESONARK 4");
        titleLabel.setTextFill(Color.rgb(242, 243, 245,0.87));
        titleLabel.setFont(Font.font("Garamond", FontWeight.BOLD,70));

        //Setting the game description and the style.
        Label descLabel = new Label(" Resonark is an unprecedented rhythm game \n that offers a different way to play on the " +
                "desktop \n and in VR. In desktop mode, players use 7 lanes \n + alpha and corresponding keyboard keys. " +
                "\n In VR mode, you use a two-handed hand controller \n to clap your hands and manipulate six \n strings as you play.");
        descLabel.setTextFill(Color.rgb(242, 243, 245,0.87));
        descLabel.setFont(Font.font("Garamond",18));

        //Create a VBox to insert game title and description
        VBox titleVBox = new VBox(titleLabel, descLabel);
        titleVBox.setAlignment(Pos.TOP_RIGHT);
        titleVBox.setStyle("-fx-padding: 50px 10px 0px 0px; -fx-font-size: 70px;");

        return titleVBox;
    }

    public HBox socialMediaBox()
    {
        //Define all the ImageView
        ImageView imageFB = new ImageView(new Image(gameMenu.class.getResource("Facebook.png").toString()));
        ImageView imageINS = new ImageView(new Image(gameMenu.class.getResource("Instagram.png").toString()));
        ImageView imageTW = new ImageView(new Image(gameMenu.class.getResource("Twitter.png").toString()));

        imageFB.setFitWidth(30);
        imageFB.setFitHeight(30);
        imageINS.setFitWidth(30);
        imageINS.setFitHeight(30);
        imageTW.setFitWidth(30);
        imageTW.setFitHeight(30);

        // Create an HBox to hold the ImageViews
        HBox imageBox = new HBox(20); // Adjust spacing between images if needed
        imageBox.setAlignment(Pos.TOP_RIGHT);
        imageBox.getChildren().addAll(imageFB,imageINS,imageTW);
        imageBox.setStyle("-fx-padding: 10px;");

        return imageBox;

    }

    public HBox titleImage()
    {
        //Define the image and imageview
        Image titleImage = new Image(gameMenu.class.getResource("title.png").toString());
        ImageView titleImageView = new ImageView(titleImage);

        // Create an HBox to hold the ImageViews
        HBox titleBox = new HBox(titleImageView);
        titleBox.setAlignment(Pos.TOP_LEFT);
        titleBox.setStyle("-fx-padding: 10px;");

        return titleBox;



    }
}