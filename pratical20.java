
    
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Pratical20 extends Application {

    private double dx = 2; 
    private boolean running = false;


    public void start(Stage stage) {

        Pane pane = new Pane();

        Circle ball = new Circle(20);
        ball.setCenterX(50);
        ball.setCenterY(100);

        Button startBtn = new Button("Start");
        Button stopBtn = new Button("Stop");

        Slider speedSlider = new Slider(1, 10, 2);

        HBox controls = new HBox(10, startBtn, stopBtn, speedSlider);
        controls.setLayoutY(250);

        pane.getChildren().addAll(ball, controls);

        AnimationTimer timer = new AnimationTimer() {
            
            public void handle(long now) {
                if (!running) return;

                double speed = speedSlider.getValue();
                ball.setCenterX(ball.getCenterX() + dx * speed);

                if (ball.getCenterX() - ball.getRadius() <= 0 ||
                    ball.getCenterX() + ball.getRadius() >= pane.getWidth()) {
                    dx = -dx;
                }
            }
        };

        timer.start();

        startBtn.setOnAction(e -> running = true);
        stopBtn.setOnAction(e -> running = false);

        Scene scene = new Scene(pane, 400, 300);
        stage.setTitle("Bouncing Ball");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
