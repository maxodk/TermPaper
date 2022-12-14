package com.example.demo;

import database.Delete;
import database.Insert;
import database.Select;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField textField;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;
    @FXML
    private TextField textField4;
    @FXML
    private TextField textField5;
    @FXML
    private Label label;
    public void exit(ActionEvent event) throws  IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Тут вирішується доля людства");
        alert.setContentText("Do you want to exit?");
        if(alert.showAndWait().get() == ButtonType.OK)
        {
            System.out.println("You are exited");
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
    public void Help(ActionEvent event) throws IOException
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Help");
        alert.setHeaderText("Тут вирішується доля людства");
        alert.setContentText("Перейти в довідку?");
        if(alert.showAndWait().get() == ButtonType.OK)
        {
            root = FXMLLoader.load(getClass().getResource("Help.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Help");
            stage.setScene(scene);
            stage.show();
        }

    }
    public void Return(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Programm 'Knight Equip'");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSceneRegister(ActionEvent event) throws  IOException {
        root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSceneLogin(ActionEvent event) throws  IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Log in");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMenu2(ActionEvent event) throws  IOException {
        label.setText("  ");
        String email = textField.getText();
        String login = textField2.getText();
        String password = textField3.getText();
        String password2 = textField4.getText();
        Select select = new Select();
        Delete delete = new Delete();
        Insert insert = new Insert();
        if(password.equals(password2))
        {
            if(select.SelectUser(email,login,password))
            {
                delete.deleteActUser();
                insert.actUser(email,login,password);
                root = FXMLLoader.load(getClass().getResource("Menu2.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Menu2");
                stage.setScene(scene);
                stage.show();
            }
            else
            {
                label.setText("Cannot found this akk in BD");
            }
        }
    }
    public void Register(ActionEvent event) throws  IOException {
        label.setText("  ");
        String email = textField.getText();
        String login = textField2.getText();
        String password = textField3.getText();
        String password2 = textField4.getText();
        Insert insert = new Insert();
        Select select = new Select();
        if(password.equals(password2))
        {
            if(select.SelectUser(email,login,password))
            {
                label.setText("This account is in BD");
            }
            else
            {
                insert.InsertUser(email,login,password);
                root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Menu2");
                stage.setScene(scene);
                stage.show();
            }
        }
    }
}