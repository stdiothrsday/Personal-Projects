import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class main extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Scene scene = new Scene(new binary(),500,500);
        stage.setTitle("converter");
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}