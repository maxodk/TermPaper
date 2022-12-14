package com.example.demo;

import data.Login;
import database.Delete;
import database.Insert;
import database.Select;
import database.Update;
import equipment.Boots;
import equipment.Breastplate;
import equipment.Helmet;
import equipment.Shield;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import knight.Knight;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Menu2 implements Initializable {

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
    private TableView<Knight> tableView;

    @FXML
    private TableColumn<Knight,String> NameColumn = new TableColumn<>();
    @FXML
    private TableColumn<Knight,Integer> AgeColumn = new TableColumn<>();
    @FXML
    private TableColumn<Knight,Double> MoneyColumn = new TableColumn<>();
    @FXML
    private TableView<Helmet> HelmetView;
    @FXML
    private TableColumn<Helmet,Double> HelmetCost = new TableColumn<>();
    @FXML
    private TableColumn<Helmet,Double> HelmetWeight = new TableColumn<>();
    @FXML
    private TableColumn<Helmet,String> HelmetMat = new TableColumn<>();
    @FXML
    private TableColumn<Helmet,Double> HelmetStreingth = new TableColumn<>();
    @FXML
    private TableColumn<Helmet,String> HelmetType = new TableColumn<>();
    @FXML
    private TableView<Breastplate> BreastplateView;
    @FXML
    private TableColumn<Breastplate,Double> BreastplateCost = new TableColumn<>();
    @FXML
    private TableColumn<Breastplate,Double> BreastplateWeight = new TableColumn<>();
    @FXML
    private TableColumn<Breastplate,String> BreastplateMat = new TableColumn<>();
    @FXML
    private TableColumn<Breastplate,Double> BreastplateStreingth = new TableColumn<>();
    @FXML
    private TableColumn<Breastplate,String> BreastplateArmor = new TableColumn<>();
    @FXML
    private TableView<Boots> BootsView;
    @FXML
    private TableColumn<Boots,Double> BootsCost = new TableColumn<>();
    @FXML
    private TableColumn<Boots,Double> BootsWeight = new TableColumn<>();
    @FXML
    private TableColumn<Boots,String> BootsMat = new TableColumn<>();
    @FXML
    private TableColumn<Boots,Double> BootsStreingth = new TableColumn<>();
    @FXML
    private TableColumn<Boots, Boolean> BootsIsGaiters = new TableColumn<>();
    @FXML
    private TableView<Shield> ShieldView;
    @FXML
    private TableColumn<Shield,Double> ShieldCost = new TableColumn<>();
    @FXML
    private TableColumn<Shield,Double> ShieldWeight = new TableColumn<>();
    @FXML
    private TableColumn<Shield,String> ShieldMat = new TableColumn<>();
    @FXML
    private TableColumn<Shield,Double> ShieldStreingth = new TableColumn<>();
    @FXML
    private TableColumn<Shield, Boolean> ShieldIsCrooked = new TableColumn<>();
    @FXML
    private TableColumn<Shield,Double> ShieldProtection = new TableColumn<>();
    private ArrayList<Integer> IdList = new ArrayList<>();
    private static int KnightID;
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        NameColumn.setCellValueFactory(new PropertyValueFactory<Knight,String>("name"));
        AgeColumn.setCellValueFactory(new PropertyValueFactory<Knight,Integer>("age"));
        MoneyColumn.setCellValueFactory(new PropertyValueFactory<Knight,Double>("available_money"));
        HelmetCost.setCellValueFactory(new PropertyValueFactory<Helmet,Double>("cost"));
        HelmetWeight.setCellValueFactory(new PropertyValueFactory<Helmet,Double>("weight"));
        HelmetMat.setCellValueFactory(new PropertyValueFactory<Helmet,String>("material"));
        HelmetStreingth.setCellValueFactory(new PropertyValueFactory<Helmet,Double>("strength"));
        HelmetType.setCellValueFactory(new PropertyValueFactory<Helmet,String>("typeofarmoring"));
        BreastplateCost.setCellValueFactory(new  PropertyValueFactory<Breastplate,Double>("cost"));
        BreastplateWeight.setCellValueFactory(new PropertyValueFactory<Breastplate,Double>("weight"));
        BreastplateMat.setCellValueFactory(new PropertyValueFactory<Breastplate,String>("material"));
        BreastplateStreingth.setCellValueFactory(new PropertyValueFactory<Breastplate,Double>("strength"));
        BreastplateArmor.setCellValueFactory(new PropertyValueFactory<Breastplate,String>("armor"));
        BootsCost.setCellValueFactory(new PropertyValueFactory<Boots,Double>("cost"));
        BootsWeight.setCellValueFactory(new PropertyValueFactory<Boots,Double>("weight"));
        BootsMat.setCellValueFactory(new PropertyValueFactory<Boots,String>("material"));
        BootsStreingth.setCellValueFactory(new PropertyValueFactory<Boots,Double>("strength"));
        BootsIsGaiters.setCellValueFactory(new PropertyValueFactory<Boots, Boolean>("isGaiters"));
        ShieldCost.setCellValueFactory(new PropertyValueFactory<Shield,Double>("cost"));
        ShieldWeight.setCellValueFactory(new PropertyValueFactory<Shield,Double>("weight"));
        ShieldMat.setCellValueFactory(new PropertyValueFactory<Shield,String>("material"));
        ShieldStreingth.setCellValueFactory(new PropertyValueFactory<Shield,Double>("strength"));
        ShieldIsCrooked.setCellValueFactory(new PropertyValueFactory<Shield, Boolean>("isCrooked"));
        ShieldProtection.setCellValueFactory(new PropertyValueFactory<Shield,Double>("protection"));
    }
    public void Logout(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("LogOut.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Log out");
        stage.setScene(scene);
        stage.show();
    }
    public void LogOut(ActionEvent event) throws IOException
    {
        String email = textField.getText();
        String login = textField2.getText();
        String password = textField3.getText();
        String password2 = textField4.getText();
        Select select = new Select();
        Delete delete = new Delete();
        if(password.equals(password2))
        {
            if(select.SelectActiveUser(email,login,password))
            {
                delete.deleteActUser();
                root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Programm 'Knight Equip'");
                stage.setScene(scene);
                stage.show();
            }
        }
    }
    public void switchToSelectEquip(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("AddKnight.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Select Equip");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void enterKnight(ActionEvent event)
    {
        Knight knight = new Knight(textField.getText(),Integer.parseInt(textField2.getText()),Double.parseDouble(textField3.getText()));
        ObservableList<Knight> knights = tableView.getItems();
        knights.add(knight);
        tableView.setItems(knights);
    }
    @FXML
    public void remove(ActionEvent event)
    {
        int Id = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(Id);
    }
    public void chooseEquipment(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("ChooseEquip.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Select Equip");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.show();
    }
    public void chooseWeapon(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("ChooseWeapon.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Select Weapon");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.show();
    }
    public void Return(ActionEvent event) throws IOException
    {
        Insert insert = new Insert();
        Select select = new Select();
        ObservableList<Knight> knights = tableView.getItems();
        String login = select.SelectLogin();
        System.out.println(login);
        insert.Knight(knights,login);
        root = FXMLLoader.load(getClass().getResource("Menu2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Select Equip");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void GetData(ActionEvent event) throws IOException
    {
        Select select = new Select();
        ObservableList<Helmet> HelmetList = select.HelmetList();
        ObservableList<Breastplate> BreastplateList = select.BreastplateList();
        ObservableList<Boots> BootsList = select.BootsList();
        ObservableList<Shield> ShieldList = select.ShieldList();
        HelmetView.setItems(HelmetList);
        BreastplateView.setItems(BreastplateList);
        BootsView.setItems(BootsList);
        ShieldView.setItems(ShieldList);
    }
    public void ChooseEquipReturn(ActionEvent event) throws IOException
    {
        for(int i = 0;i < IdList.size();i++)
        {
            for (int j = 0;j < IdList.size()-1;j++)
            {
                if(IdList.get(j) > IdList.get(j+1))
                {
                    int t = IdList.get(j);
                    IdList.set(j,IdList.get(j + 1));
                    IdList.set(j + 1,t);
                }
            }
        }
        Select select = new Select();
        String login = select.SelectLogin();
        Insert insert = new Insert();
        double money = select.GetKnightMoney(KnightID,login);
        System.out.println(money);
        for (int i = 0;i < IdList.size();i++)
        {
            if(IdList.get(i) > 0 && IdList.get(i) <= 250)
            {
                money -= select.GetHelmetMoney(IdList.get(i));
                System.out.println(money);
            }
            if(IdList.get(i) > 250 && IdList.get(i) <= 500)
            {
                money -= select.GetBreastplateMoney(IdList.get(i));
                System.out.println(money);
            }
            if(IdList.get(i) > 500 && IdList.get(i) <= 750)
            {
                money -= select.GetBootsMoney(IdList.get(i));
                System.out.println(money);
            }
            if(IdList.get(i) > 750 && IdList.get(i) <= 1000)
            {
                money -= select.GetShieldMoney(IdList.get(i));
                System.out.println(money);
            }
        }
        if(select.isEquip(KnightID,login))
        {
            if(money > 0.0 && KnightID > 0)
            {
                for (int i = 0;i < IdList.size();i++)
                {
                    if(IdList.get(i) > 0 && IdList.get(i) <= 250)
                    {
                        insert.KnightHelmetList(IdList.get(i),KnightID, login);
                    }
                    if(IdList.get(i) > 250 && IdList.get(i) <= 500)
                    {
                        insert.KnightBreastplateList(IdList.get(i),KnightID, login);
                    }
                    if(IdList.get(i) > 500 && IdList.get(i) <= 750)
                    {
                        insert.KnightBootsList(IdList.get(i),KnightID, login);
                    }
                    if(IdList.get(i) > 750 && IdList.get(i) <= 1000)
                    {
                        insert.KnightShieldList(IdList.get(i),KnightID,login);
                    }
                }
                Knight knight = select.GetKnight(KnightID,login);
                System.out.println(knight);
                Update update = new Update();
                update.UpdateKnightMoney(login,money,knight);
            }
            else
            {
                System.out.println("You have not enough money");
            }
        }
        else
        {
            System.out.println("You have equipment for this Knight");
        }
        /*if(select.isKnightId(KnightID))
        {
            insert.InsertKnightEquipment(IdList,login,KnightID);
        }
        else
        {
            System.out.println("You have equip for this knight");
        }*/
        root = FXMLLoader.load(getClass().getResource("Menu2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu2");
        stage.setScene(scene);
        stage.show();
    }
    public void SelectHelmet(ActionEvent event) throws IOException
    {
        int ch = 0;
        int Id = HelmetView.getSelectionModel().getSelectedIndex();
        System.out.println(Id);
        if(Id >= 0)
        {
            for(int i = 0;i < IdList.size();i++)
            {
                if(IdList.get(i) >= 0 && IdList.get(i) < 250)
                {
                    System.out.println("You have Helmet");
                    ch = 1;
                    break;
                }
            }
            if(ch == 0)
            {
                IdList.add(Id + 1);
            }
        }
    }
    public void SelectBreastplate(ActionEvent event) throws IOException
    {
        int ch = 0;
        int Id = BreastplateView.getSelectionModel().getSelectedIndex();
        if(Id >= 0)
        {
            Id += 250;
            System.out.println(Id);
            for(int i = 0;i < IdList.size();i++)
            {
                if(IdList.get(i) >= 250 && IdList.get(i) < 500)
                {
                    System.out.println("You have Breastplate");
                    ch = 1;
                    break;
                }
            }
            if(ch == 0)
            {
                IdList.add(Id + 1);
            }
        }
    }
    public void SelectBoots(ActionEvent event) throws IOException
    {
        int ch = 0;
        int Id = BootsView.getSelectionModel().getSelectedIndex();
        if(Id >= 0)
        {
            Id += 500;
            System.out.println(Id);
            for(int i = 0;i < IdList.size();i++)
            {
                if(IdList.get(i) >= 500 && IdList.get(i) < 750)
                {
                    System.out.println("You have Boots");
                    ch = 1;
                    break;
                }
            }
            if(ch == 0)
            {
                IdList.add(Id + 1);
            }
        }
    }
    public void SelectShield(ActionEvent event) throws IOException
    {
        int ch = 0;
        int Id = ShieldView.getSelectionModel().getSelectedIndex();
        if(Id >= 0)
        {
            Id += 750;
            System.out.println(Id);
            for(int i = 0;i < IdList.size();i++)
            {
                if(IdList.get(i) >= 750 && IdList.get(i) < 1000)
                {
                    System.out.println("You have Shield");
                    ch = 1;
                    break;
                }
            }
            if(ch == 0)
            {
                IdList.add(Id + 1);
            }
        }
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
        }
        else
        {
            System.out.println("You dont choose Knight");
        }
    }
    public void AddEquipment(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("ChooseKnight.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Choose Knight");
        stage.setScene(scene);
        stage.show();
    }
    public void DeleteEquipment(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("ChooseKnight2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Choose Knight");
        stage.setScene(scene);
        stage.show();
    }
    public void CalculateData(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("CalculateData.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("CalculateData");
        stage.setScene(scene);
        stage.show();
    }
}
