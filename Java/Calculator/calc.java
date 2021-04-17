import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

/**
 * JavaFX class p5 creates a scene with a calculator.
 *
 * @author (Yaw Abaaho)
 * @version (11/24/19)
 */
public class calc extends Application
{
    public void start(Stage stage)
    {
        Scene scene = new Scene(new calcPane(),300,300);
        stage.setTitle("Calculator"); 
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}