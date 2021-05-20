package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import sample.Metods.*;

public class Controller {
    public AnchorPane ap2;
    @FXML
    public TextField dindon, timer, image, coll, repeat;
    public Canvas can;

    Subject subject = new Subject();
    ComponentText ct;
    Signal sl;
    ConImage ck;
    GraphicsContext gr;


    @FXML
    public void initialize(){
        gr = can.getGraphicsContext2D();
        addObs();
        dindon.setEditable(false);
        dindon.setText("Прошло _ с");
        Stone stone = new Stone();
        Paint p = Color.KHAKI;
        stone.draw(gr,p,190,190,95,95,105);

    }

    public void start(){
        subject.go(Integer.parseInt(timer.getText()),Integer.parseInt(repeat.getText()));
        ct.onComp();
        sl.onComp(5);
        ck.onComp(10);
    }

    public void stop(){
        subject.stp();

    }

    public void clean(){

        timer.setText("");
        repeat.setText("");
        coll.setText("");
        image.setText("");
        delObs();
        addObs();
        subject.cln();
    }

    public void addObs(){
        ct = new ComponentText(subject,dindon);
        sl = new Signal(subject);
        ck = new ConImage(subject,gr);
    }

    public void delObs(){
        ct.delComo(subject);
        sl.delComo(subject);
        ck.delComo(subject);
    }


    public void Cl(ActionEvent actionEvent) {
        ap2.setVisible(true);
    }
}
