package com.example.demo;

import data.EquipmentData;
import data.WeaponData;
import database.Connect;
import database.Delete;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import menu.ConsoleMenu;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.demo.Main.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Programm 'Knight Equip'");
        Image image = new Image("D:\\Sticker.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }
    private static final Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws Exception {
        ConsoleMenu enter = new ConsoleMenu();
        Scanner scanner = new Scanner(System.in);
        File file = new File("D:\\Merchant.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        Delete delete = new Delete();
        delete.DeleteHelmets();
        delete.DeleteBreastplate();
        delete.DeleteBootsList();
        delete.DeleteShieldList();
        delete.DeleteBowList();
        delete.DeleteHeavyWeaponList();
        delete.DeleteSwordList();
        delete.DeleteSpearList();
        EquipmentData list = new EquipmentData();
        WeaponData wlist = new WeaponData();
        wlist.fillList();
        list.fillEquipment();
        clip.start();
        launch();
        log.info("TEST");
        /*EquipmentData list = new EquipmentData();
        list.fillEquipment();
        list.printList();*/
        /*WeaponData list = new WeaponData();
        list.fillList();
        list.printList();*/
        Connect c = new Connect();
        c.method();
        //enter.Menu();


        /*Equipment a = new Equipment(30,15,"Iron",0.5);
        Helmet b = new Helmet(30,50,"Gold",0.3,"Close");
        System.out.println(a.ReturnCost());
        System.out.println(b.ReturnCost());*/
    }
}


