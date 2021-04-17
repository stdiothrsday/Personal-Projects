import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import java.util.*;
import javafx.scene.transform.Rotate;
import javafx.scene.layout.Pane;
import javafx.scene.Group;
import javafx.scene.layout.VBox;

public class binary extends Pane
{
    Label title = new Label("Decimal to Binary");

    TextField dec = new TextField("");
    TextField bin = new TextField("");
    Button conv = new Button("convert");
    Button reset = new Button("reset");

    String result = "";
    
    public binary()
    {
        Font font = new Font(15);

        setStyle("-fx-background-color:lightgrey");

        title.setFont(font);
        title.setLayoutX(150);
        title.setLayoutY(75);
        title.setMinWidth(200);
        title.setAlignment(Pos.CENTER);
        title.setStyle("-fx-background-color:white");

        dec.setFont(font);
        dec.setLayoutX(100);
        dec.setLayoutY(150);
        dec.setMaxWidth(100);
        dec.setMinHeight(100);
        dec.setAlignment(Pos.CENTER);
        dec.setStyle("-fx-background-color:white");

        bin.setFont(font);
        bin.setLayoutX(300);
        bin.setLayoutY(150);
        bin.setMaxWidth(100);
        bin.setMinHeight(100);
        bin.setAlignment(Pos.CENTER);
        bin.setStyle("-fx-background-color:white");

        conv.setFont(font);
        conv.setLayoutX(100);
        conv.setLayoutY(275);
        conv.setMinWidth(100);
        conv.setMinHeight(50);
        conv.setAlignment(Pos.CENTER);
        conv.setStyle("-fx-background-color:white");

        reset.setFont(font);
        reset.setLayoutX(300);
        reset.setLayoutY(275);
        reset.setMinWidth(100);
        reset.setMinHeight(50);
        reset.setAlignment(Pos.CENTER);
        reset.setStyle("-fx-background-color:white");

        getChildren().addAll(title,dec,bin,conv,reset);

        dec.requestFocus();

        conv.setOnAction(this::conv);
        reset.setOnAction(this::reset);
    }

    private void conv(ActionEvent event)
    {
        try
        {
            int temp = Integer.parseInt(dec.getText());
            while(temp!=0)
            {
                result=Integer.toString((temp%2))+result;
                temp=temp/2;
            }
            bin.setText(result);
            dec.setDisable(true);
            bin.setDisable(true);
            conv.setDisable(true);
            reset.requestFocus();
            temp=0;
            result="";
        }
        catch(NumberFormatException ew)
        {
            dec.setAlignment(Pos.CENTER);
            dec.setText("Enter a #");
            conv.setDisable(true);
        }
    }

    private void reset(ActionEvent event)
    {
        result="";
        dec.setText("");
        bin.setText("");
        dec.setDisable(false);
        bin.setDisable(false);
        conv.setDisable(false);
        dec.requestFocus();
    }
}