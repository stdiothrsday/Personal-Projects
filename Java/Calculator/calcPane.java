import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class calcPane extends GridPane
{
    Button c = new Button("C");
    Button num7 = new Button("7");
    Button num8 = new Button("8");
    Button num9 = new Button("9");
    Button div = new Button("%");
    Button num4 = new Button("4");
    Button num5 = new Button("5");
    Button num6 = new Button("6");
    Button mult = new Button("x");
    Button num1 = new Button("1");
    Button num2 = new Button("2");
    Button num3 = new Button("3");
    Button minus = new Button("-");
    Button num0 = new Button("0");
    Button per = new Button(".");
    Button equal = new Button("=");
    Button plus = new Button("+");

    private TextField screen;

    double inp1=0;
    double inp2=0;
    double result=0;
    String op="";

    Boolean arith = false;
    public calcPane()
    {
        Font font = new Font(18);

        screen = new TextField("");
        screen.setFont(font);
        screen.setPrefWidth(90);
        screen.setStyle("-fx-background-color:white");
        screen.setAlignment(Pos.BOTTOM_LEFT);

        c.setOnAction(this::clear);
        num7.setOnAction(this::num7);
        num8.setOnAction(this::num8);
        num9.setOnAction(this::num9);
        div.setOnAction(this::div);

        num4.setOnAction(this::num4);
        num5.setOnAction(this::num5);
        num6.setOnAction(this::num6);
        mult.setOnAction(this::mult);

        num1.setOnAction(this::num1);
        num2.setOnAction(this::num2);
        num3.setOnAction(this::num3);
        minus.setOnAction(this::minus);

        num0.setOnAction(this::num0);
        per.setOnAction(this::per);
        equal.setOnAction(this::equal);
        plus.setOnAction(this::plus);

        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setStyle("-fx-background-color: lightblue");

        add(c, 0, 0);
        add(screen,1,0);
        setColumnSpan(screen,3);

        add(num7,0,1);
        add(num8,1,1);
        add(num9,2,1);
        add(div,3,1);

        add(num4,0,2);
        add(num5,1,2);
        add(num6,2,2);
        add(mult,3,2);

        add(num1,0,3);
        add(num2,1,3);
        add(num3,2,3);
        add(minus,3,3);

        add(num0,0,4);
        add(per,1,4);
        add(equal,2,4);
        add(plus,3,4);
    }

    public boolean full()
    {
        boolean result=false;
        if(screen.getLength()>5)
            result=true;
        return result;
    }

    public void process()
    {
        if(arith==true){
            num7.setDisable(true);
            num8.setDisable(true);
            num9.setDisable(true);
            div.setDisable(true);
            num4.setDisable(true);
            num5.setDisable(true);
            num6.setDisable(true);
            mult.setDisable(true);
            num1.setDisable(true);
            num2.setDisable(true);
            num3.setDisable(true);
            minus.setDisable(true);
            num0.setDisable(true);
            per.setDisable(true);
            equal.setDisable(true);
            plus.setDisable(true);
            arith=false;
        }

        inp1=0;
        inp2=0;
    }

    private void clear(ActionEvent event)
    {
        screen.setText("");

        if(arith==false){
            num7.setDisable(false);
            num8.setDisable(false);
            num9.setDisable(false);
            div.setDisable(false);
            num4.setDisable(false);
            num5.setDisable(false);
            num6.setDisable(false);
            mult.setDisable(false);
            num1.setDisable(false);
            num2.setDisable(false);
            num3.setDisable(false);
            minus.setDisable(false);
            num0.setDisable(false);
            per.setDisable(false);
            equal.setDisable(false);
            plus.setDisable(false);
        }

        inp1=0;
        inp2=0;
    }

    private void num7(ActionEvent event)
    {
        if(full()==false)
            screen.setText(screen.getText()+"7");
    }

    private void num8(ActionEvent event)
    {
        if(full()==false)
            screen.setText(screen.getText()+"8");
    }

    private void num9(ActionEvent event)
    {
        if(full()==false)
            screen.setText(screen.getText()+"9");
    }

    private void div(ActionEvent event)
    {
        inp1=Double.parseDouble(screen.getText());
        screen.setText("");
        op="/";
    }

    private void num4(ActionEvent event)
    {
        if(full()==false)
            screen.setText(screen.getText()+"4");
    }

    private void num5(ActionEvent event)
    {
        if(full()==false)
            screen.setText(screen.getText()+"5");
    }

    private void num6(ActionEvent event)
    {
        if(full()==false)
            screen.setText(screen.getText()+"6");
    }

    private void mult(ActionEvent event)
    {
        inp1=Double.parseDouble(screen.getText());
        screen.setText("");
        op="x";
    }

    private void num1(ActionEvent event)
    {
        if(full()==false)
            screen.setText(screen.getText()+"1");
    }

    private void num2(ActionEvent event)
    {
        if(full()==false)
            screen.setText(screen.getText()+"2");
    }

    private void num3(ActionEvent event)
    {
        if(full()==false)
            screen.setText(screen.getText()+"3");
    }

    private void minus(ActionEvent event)
    {
        inp1=Double.parseDouble(screen.getText());
        screen.setText("");
        op="minus";
    }

    private void num0(ActionEvent event)
    {
        if(full()==false)
            screen.setText(screen.getText()+"0");
    }

    private void per(ActionEvent event)
    {
        if(full()==false)
            screen.setText(screen.getText()+".");
    }

    private void equal(ActionEvent event)
    {
        try
        {
            inp2=Double.parseDouble(screen.getText());
        }
        catch(NumberFormatException bh)
        {
            screen.setText("Enter Input");
        }
        screen.setText("");
        arith=true;
        switch(op)
        {
            case "/":
            try
            {
                result= inp1/inp2;
                screen.setText(""+result);
            }
            catch (ArithmeticException gh)
            {
                screen.setText("Error!");
            }
            break;

            case "x":
            result= inp1*inp2;
            screen.setText(""+result);
            break;

            case "minus":
            result= inp1-inp2;
            screen.setText(""+result);
            break;

            case "plus":
            result= inp1+inp2;
            screen.setText(""+result);
            break;
        }
        process();
    }

    private void plus(ActionEvent event)
    {
        inp1=Integer.parseInt(screen.getText());
        screen.setText("");
        op="plus";
    }
}