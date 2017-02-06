package sample;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;


public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage)
    {
        theStage.setTitle( "Team Maleficent" );

        Group root = new Group();

        Scene theScene = new Scene(root, 640, 480, Color.WHITESMOKE);
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 640, 480 );
        root.getChildren().add( canvas );

        // Create Image and ImageView objects
        Image parquet = new Image("resources/parquete.jpg");
        Image tiles = new Image("resources/tiles.jpg");
        Image carpet = new Image("resources/carpet.jpg");
        Image carpet2 = new Image("resources/carpet03.jpg");
        Image toilet = new Image("resources/toilet.png");
        Image bed = new Image("resources/bed_burned.png");
        Image painting = new Image("resources/painting.jpg");
        Image wardrobe = new Image("resources/wardrobe_burned1.png");
        Image sink = new Image("resources/sink_burned.png");
        Image bathtub = new Image("resources/bathtub_burned.png");
        Image studentTable = new Image("resources/studentTable_burned.png");
        Image chair = new Image("resources/chair_burned.png");
        Image siphon = new Image("resources/siphon_burned.png");
        Image brickVertical = new Image("resources/brickVertical.png");
        Image brickHorizontal = new Image("resources/brickHorizontal.png");
        Image brickShort = new Image("resources/brickShort.png");
        Image brickShortVert = new Image("resources/brickShortVert.png");
        Image brickSingleVert = new Image("resources/brickSingleVert.png");
        Image wallShort = new Image("resources/wallShort.png");
        Image wall = new Image("resources/wall.png");
        Image wallColon = new Image("resources/wallColon.png");

        Image playerRight0 = new Image("resources/playerRight0.png");
        Image playerRight1 = new Image("resources/playerRight1.png");
        Image playerRight2 = new Image("resources/playerRight2.png");
        ArrayDeque<Image> playerRightImages = new ArrayDeque<>();
        playerRightImages.addLast(playerRight0);
        playerRightImages.addLast(playerRight1);
        playerRightImages.addLast(playerRight2);

        Image playerLeft0 = new Image("resources/playerLeft0.png");
        Image playerLeft1 = new Image("resources/playerLeft1.png");
        Image playerLeft2 = new Image("resources/playerLeft2.png");
        ArrayDeque<Image> playerLeftImages = new ArrayDeque<>();
        playerLeftImages.addLast(playerLeft0);
        playerLeftImages.addLast(playerLeft1);
        playerLeftImages.addLast(playerLeft2);

        Image playerDown0 = new Image("resources/playerFront0.png");
        Image playerDown1 = new Image("resources/playerFront1.png");
        Image playerDown2 = new Image("resources/playerFront2.png");
        ArrayDeque<Image> playerDownImages = new ArrayDeque<>();
        playerDownImages.addLast(playerDown0);
        playerDownImages.addLast(playerDown1);
        playerDownImages.addLast(playerDown2);

        Image playerUp0 = new Image("resources/playerBack0.png");
        Image playerUp1 = new Image("resources/playerBack1.png");
        Image playerUp2 = new Image("resources/playerBack2.png");
        ArrayDeque<Image> playerUpImages = new ArrayDeque<>();
        playerUpImages.addLast(playerUp0);
        playerUpImages.addLast(playerUp1);
        playerUpImages.addLast(playerUp2);


        //Take the keys inputs
        ArrayList<String> input = new ArrayList<String>();

        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        if ( !input.contains(code) )
                            input.add( code );
                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        input.remove( code );
                    }
                });

        // Display the graphics and movement
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //The player object
        Sprite player = new Sprite();
        player.setImage("resources/playerFront0.png");
        player.setPosition(500, 150);

        //The sofa object
        Sprite sofa = new Sprite();
        sofa.setImage("resources/sofa.png");
        sofa.setPosition(220,240);

        LongValue lastNanoTime = new LongValue( System.nanoTime() );
        IntValue score = new IntValue(0);

            new AnimationTimer() {
                public void handle(long currentNanoTime) {
                    // calculate time since last update.
                    double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                    lastNanoTime.value = currentNanoTime;

                    Rectangle2D so = sofa.getBoundary();

                    // Player movement
                    player.setVelocity(0, 0);
                    if (input.contains("LEFT")){
                        if (player.leftBoundary().intersects(so)||
                                player.leftBoundary().intersects(0,0,140,40)||
                                player.leftBoundary().intersects(0,0,20,480)||
                                player.leftBoundary().intersects(0,270,140,8)||
                                player.leftBoundary().intersects(402,270,20,240)||
                                player.leftBoundary().intersects(440,270,20,8)||
                                player.leftBoundary().intersects(302,200,20,80)||
                                player.leftBoundary().intersects(302,0,20,144)) {
                            player.addVelocity(0, 0);
                        }else {
                            player.addVelocity(-90, 0);
                        }
                    }
                    if (input.contains("RIGHT")){
                        if (player.rightBoundary().intersects(so)||
                                player.rightBoundary().intersects(220,0,20,40)||
                                player.rightBoundary().intersects(302,0,20,144)||
                                player.rightBoundary().intersects(620,0,20,480)||
                                player.rightBoundary().intersects(402,270,20,220)||
                                player.rightBoundary().intersects(220,270,20,8)||
                                player.rightBoundary().intersects(302,200,20,80)||
                                player.rightBoundary().intersects(540,270,20,8)){
                            player.addVelocity(0, 0);
                        }else {
                            player.addVelocity(90, 0);
                        }
                    }
                    if (input.contains("UP")){
                        if (player.upperBoundary().intersects(so)||
                                player.upperBoundary().intersects(0,0,140,50)||
                                player.upperBoundary().intersects(0,260,140,20)||
                                player.upperBoundary().intersects(220,0,420,50)||
                                player.upperBoundary().intersects(220,260,240,20)||
                                player.upperBoundary().intersects(302,140,20,4)||
                                player.upperBoundary().intersects(540,260,60,20)){
                            player.addVelocity(0, 0);
                        }else{
                            player.addVelocity(0, -90);
                        }
                    }
                    if (input.contains("DOWN")){
                        if (player.bottomBoundary().intersects(so)||
                                player.bottomBoundary().intersects(0,460,640,20)||
                                player.bottomBoundary().intersects(0,270,140,20)||
                                player.bottomBoundary().intersects(220,270,240,20)||
                                player.bottomBoundary().intersects(302,200,20,20)||
                                player.bottomBoundary().intersects(540,270,60,20)){

                            player.addVelocity(0, 0);
                        }else {
                            player.addVelocity(0, 90);
                        }
                    }
                    player.update(elapsedTime);

                    // Render the image objects

                    gc.clearRect(0, 0, 640, 480);
                    gc.drawImage(parquet,20,40,302,250);
                    gc.drawImage(carpet2,320,62,300,230);
                    gc.drawImage(chair,382,172);
                    gc.drawImage(studentTable,330,160);
                    gc.drawImage(tiles,422,290,198,172);
                    gc.drawImage(carpet,20,290,382,170);

                    //Draw upper walls and bricks
                    gc.drawImage(brickHorizontal,220,0);
                    gc.drawImage(brickHorizontal,460,0);
                    gc.drawImage(wall,220,20);
                    gc.drawImage(brickShortVert,302,0);
                    gc.drawImage(brickShort,20,0);
                    gc.drawImage(wallShort,0,20);
                    gc.drawImage(wallColon,302,120);

                    //Draw the player if it`s in the first half of the screen(above the top walls
                    // and behind the middle walls)
                    if (player.bottomBoundary().intersects(0,0,640,290)){
                        player.render(gc);
                    }

                    //render the  middle walls
                    gc.drawImage(wallShort,0,250);
                    gc.drawImage(wallShort,220,250);
                    gc.drawImage(wallShort,320,250);
                    gc.drawImage(wallShort,540,250);

                    //Render the bricks
                    gc.drawImage(brickVertical,0,0);
                    gc.drawImage(brickVertical,0,240);

                    gc.drawImage(brickSingleVert,302,180);
                    gc.drawImage(brickVertical,402,230);

                    gc.drawImage(brickHorizontal,0,480);
                    gc.drawImage(brickShort,20,230);
                    gc.drawImage(brickHorizontal,220,230);
                    gc.drawImage(brickShort,540,230);
                    gc.drawImage(brickHorizontal,20,460);
                    gc.drawImage(brickHorizontal,260,460);
                    gc.drawImage(brickHorizontal,500,460);
                    gc.drawImage(brickVertical,620,0);
                    gc.drawImage(brickVertical,620,240);

                    sofa.render(gc);
                    if (player.bottomBoundary().intersects(0,280,640,210)){
                        player.render(gc);
                    }

                }
            }.start();


        theStage.show();
    }
}