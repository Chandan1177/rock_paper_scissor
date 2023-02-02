package com.example.papergamefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

import static java.lang.Thread.sleep;

public class HelloController {
    public Label lbPoint,congratiTxt;
    int i=1,img=0,userPoint=0;
    public ImageView img1,img2,img3,imgrock,img11,img22,img33;

    public void onRock(MouseEvent mouseEvent) throws InterruptedException {
        setImg(i,0);i++;systemTurn();
    }

    public void onPaper(MouseEvent mouseEvent) throws InterruptedException {
       setImg(i,1);i++;img=1;
       systemTurn();
    }

    public void onScissor(MouseEvent mouseEvent) throws InterruptedException {
       setImg(i,2);i++;img=2;systemTurn();
    }
    public void systemTurn() throws InterruptedException {
        sleep(500);
        int j= (int) (Math.random()*3);
        if(img!=j) {setImg(i,j);i++;}
        else{systemTurn();}

        switch (j) {
            case 0:{switch (img) {
                case 1: userPoint++; break;
                case 2:break;}
            }break;

            case 1:{switch (img) {
                case 0: break;
                case 2:userPoint++;break;}
            }break;

            case 2:{switch (img) {
                case 0:userPoint++; break;
                case 1:break;}
            }break;
        }
        if(i==7){lbPoint.setText("You got "+ userPoint+" points");if(userPoint>=2){congratiTxt.setText("Congratulation You Won!");}else{
            congratiTxt.setText("Better luck next time");
        }}
    }

    public void setImg(int imgindex,int imgtype) throws InterruptedException {
        switch (imgindex) {
            case 1:{switch (imgtype) {
                case 0: img1.setImage(new Image(new File("src/main/resources/rock.jpg").toURI().toString()));;break;
                case 1:  img1.setImage(new Image(new File("src/main/resources/paper.jpg").toURI().toString()));break;
                case 2: img1.setImage(new Image(new File("src/main/resources/scissor.jpg").toURI().toString()));break;}
            }break;

            case 3:{switch (imgtype) {
                case 0: img2.setImage(new Image(new File("src/main/resources/rock.jpg").toURI().toString())); break;
                case 1:  img2.setImage(new Image(new File("src/main/resources/paper.jpg").toURI().toString()));break;
                case 2: img2.setImage(new Image(new File("src/main/resources/scissor.jpg").toURI().toString()));break;}
            }break;

            case 5:{switch (imgtype) {
                case 0: img3.setImage(new Image(new File("src/main/resources/rock.jpg").toURI().toString())); break;
                case 1:  img3.setImage(new Image(new File("src/main/resources/paper.jpg").toURI().toString()));break;
                case 2: img3.setImage(new Image(new File("src/main/resources/scissor.jpg").toURI().toString()));break;}
            }break;

            case 2:{switch (imgtype) {
                case 0: img11.setImage(new Image(new File("src/main/resources/rock.jpg").toURI().toString())); break;
                case 1:  img11.setImage(new Image(new File("src/main/resources/paper.jpg").toURI().toString()));break;
                case 2: img11.setImage(new Image(new File("src/main/resources/scissor.jpg").toURI().toString()));break;}
            }break;

            case 4:{switch (imgtype) {
                case 0: img22.setImage(new Image(new File("src/main/resources/rock.jpg").toURI().toString())); break;
                case 1:  img22.setImage(new Image(new File("src/main/resources/paper.jpg").toURI().toString()));break;
                case 2: img22.setImage(new Image(new File("src/main/resources/scissor.jpg").toURI().toString()));break;}
            }break;

            case 6:{switch (imgtype) {
                case 0: img33.setImage(new Image(new File("src/main/resources/rock.jpg").toURI().toString())); break;
                case 1:  img33.setImage(new Image(new File("src/main/resources/paper.jpg").toURI().toString()));break;
                case 2: img33.setImage(new Image(new File("src/main/resources/scissor.jpg").toURI().toString()));break;}
            }break;
        }
    }

    public void onRestart(ActionEvent actionEvent) {
        i=1;img=0;userPoint=0;img1.setImage(null);img2.setImage(null);img3.setImage(null);
        img11.setImage(null);img22.setImage(null);img33.setImage(null);
        lbPoint.setText("point:");congratiTxt.setText("");
    }
}