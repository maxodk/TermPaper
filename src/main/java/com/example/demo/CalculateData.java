package com.example.demo;

import database.Select;
import equipment.Equipment;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import knight.Knight;
import weapon.Weapon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculateData implements Initializable {
    private static int KnightID;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Knight> tableView;

    @FXML
    private TableColumn<Knight,String> NameColumn = new TableColumn<>();
    @FXML
    private TableColumn<Knight,Integer> AgeColumn = new TableColumn<>();
    @FXML
    private TableColumn<Knight,Double> MoneyColumn = new TableColumn<>();
    @FXML
    private TableView<Equipment> EquipTable;
    @FXML
    private TableColumn<Equipment,Double> EquipCost = new TableColumn<>();
    @FXML
    private TableColumn<Equipment,Double> EquipWeight = new TableColumn<>();
    @FXML
    private TableColumn<Equipment,String> EquipMat = new TableColumn<>();
    @FXML
    private TableColumn<Equipment,Double> EquipStrength = new TableColumn<>();
    @FXML
    private TableView<Weapon> WeaponTable;
    @FXML
    private TableColumn<Weapon,Double> WepCost = new TableColumn<>();
    @FXML
    private TableColumn<Weapon,Double> WepWeight = new TableColumn<>();
    @FXML
    private TableColumn<Weapon,String> WepType = new TableColumn<>();
    @FXML
    private TableColumn<Weapon,Double> WepStrength = new TableColumn<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        NameColumn.setCellValueFactory(new PropertyValueFactory<Knight,String>("name"));
        AgeColumn.setCellValueFactory(new PropertyValueFactory<Knight,Integer>("age"));
        MoneyColumn.setCellValueFactory(new PropertyValueFactory<Knight,Double>("available_money"));
        EquipCost.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("cost"));
        EquipWeight.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("weight"));
        EquipMat.setCellValueFactory(new PropertyValueFactory<Equipment,String>("material"));
        EquipStrength.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("strength"));
        WepCost.setCellValueFactory(new PropertyValueFactory<Weapon,Double>("cost"));
        WepWeight.setCellValueFactory(new PropertyValueFactory<Weapon,Double>("weight"));
        WepType.setCellValueFactory(new PropertyValueFactory<Weapon,String>("type"));
        WepStrength.setCellValueFactory(new PropertyValueFactory<Weapon,Double>("strength"));
    }
    public void GetKnights(ActionEvent event) throws IOException
    {
        Select select = new Select();
        String login = select.SelectLogin();
        ObservableList<Knight> knights = select.SelectKnights(login);
        tableView.setItems(knights);
    }
    public void SelectKnight(ActionEvent event) throws IOException
    {
        int Id = tableView.getSelectionModel().getSelectedIndex();
        if(Id >= 0)
        {
            KnightID = Id + 1;
            Select select = new Select();
            String login = select.SelectLogin();
            ObservableList<Equipment> Equip = select.KnightEquip(KnightID,login);
            ObservableList<Weapon> Weapon = select.WeaponEquip(KnightID,login);
            EquipTable.setItems(Equip);
            WeaponTable.setItems(Weapon);
        }
        else
        {
            System.out.println("You dont choose Knight");
        }
    }
    public void Return(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("Menu2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu2");
        stage.setScene(scene);
        stage.show();
    }
}
