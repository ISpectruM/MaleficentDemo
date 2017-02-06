//package sample;
//
//import javafx.application.Application;
//import javafx.geometry.Rectangle2D;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.Group;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.Image;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.animation.AnimationTimer;
//import javafx.event.EventHandler;
//import javafx.scene.input.KeyEvent;
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Iterator;
//
//
//// Collect the Money Bags!
//public class Main extends Application
//{
//    public static void main(String[] args)
//    {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage theStage)
//    {
//        theStage.setTitle( "Collect the Money Bags!" );
//
//        Group root = new Group();
//
//        Scene theScene = new Scene( root );
//        theStage.setScene( theScene );
//
//        Canvas canvas = new Canvas( 512, 512 );
//        root.getChildren().add( canvas );
//
//        ArrayList<String> input = new ArrayList<String>();
//
//        theScene.setOnKeyPressed(
//                new EventHandler<KeyEvent>()
//                {
//                    public void handle(KeyEvent e)
//                    {
//                        String code = e.getCode().toString();
//                        if ( !input.contains(code) )
//                            input.add( code );
//                    }
//                });
//
//        theScene.setOnKeyReleased(
//                new EventHandler<KeyEvent>()
//                {
//                    public void handle(KeyEvent e)
//                    {
//                        String code = e.getCode().toString();
//                        input.remove( code );
//                    }
//                });
//
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//
////        Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 24 );
////        gc.setFont( theFont );
////        gc.setFill( Color.GREEN );
////        gc.setStroke( Color.BLACK );
////        gc.setLineWidth(1);
//
//
//        Sprite briefcase = new Sprite();
//        briefcase.setImage("resources/redSq.png");
//        briefcase.setPosition(200, 100);
//
//        ArrayList<Sprite> moneybagList = new ArrayList<Sprite>();
//
//        Sprite sofa = new Sprite();
//        sofa.setImage("resources/blackSq.png");
//        sofa.setPosition(200,200);
//
////        for (int i = 0; i < 15; i++)
////        {
////            Sprite moneybag = new Sprite();
////            moneybag.setImage("resources/sun.png");
////            double px = 350 * Math.random() + 50;
////            double py = 350 * Math.random() + 50;
////            moneybag.setPosition(px,py);
////            moneybagList.add( moneybag );
////        }
//
//        LongValue lastNanoTime = new LongValue( System.nanoTime() );
//        IntValue score = new IntValue(0);
//
//        new AnimationTimer() {
//            public void handle(long currentNanoTime) {
//                // calculate time since last update.
//                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
//                lastNanoTime.value = currentNanoTime;
//
//                Rectangle2D so = sofa.getBoundary();
//
////                    String currMove="";
////                    if (!input.isEmpty()){
////                        currMove = input.get(0);
////                    }
//
//                // game logic
//                briefcase.setVelocity(0, 0);
//                if (input.contains("LEFT")){
//                    if (briefcase.leftBoundary().intersects(so)) {
//                        briefcase.addVelocity(0, 0);
//                    }else {
//                        briefcase.addVelocity(-50, 0);
//                    }
//                }
//                if (input.contains("RIGHT")){
//                    if (briefcase.rightBoundary().intersects(so)){
//                        briefcase.addVelocity(0, 0);
//                    }else {
//                        briefcase.addVelocity(50, 0);
//                    }
//                }
//                if (input.contains("UP")){
//                    if (briefcase.upperBoundary().intersects(so)){
//                        briefcase.addVelocity(0, 0);
//
//                    }else{
//                        briefcase.addVelocity(0, -50);
//                    }
//                }
//                if (input.contains("DOWN")){
//                    if (briefcase.bottomBoundary().intersects(so)){
//                        briefcase.addVelocity(0, 0);
//                    }else {
//                        briefcase.addVelocity(0, 50);
//                    }
//                }
//                briefcase.update(elapsedTime);
//
//                // collision detection
//                //isIntersected=false;
//
//                Iterator<Sprite> moneybagIter = moneybagList.iterator();
//                while (moneybagIter.hasNext()) {
//                    Sprite moneybag = moneybagIter.next();
//                    if (briefcase.intersects(sofa)) {
//                        moneybagIter.remove();
//                        score.value++;
//                    }
//                }
//
//                // render
//
//                gc.clearRect(0, 0, 512, 512);
//                briefcase.render(gc);
//                sofa.render(gc);
//
//                for (Sprite moneybag : moneybagList)
//                    moneybag.render(gc);
//
//                String pointsText = "Cash: $" + (100 * score.value);
//                gc.fillText(pointsText, 360, 36);
//                gc.strokeText(pointsText, 360, 36);
//            }
//        }.start();
//
//
//        theStage.show();
//    }
//}