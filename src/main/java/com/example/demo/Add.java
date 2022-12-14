package com.example.demo;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import knight.Knight;
import weapon.Bow;
import weapon.HeavyWeapon;
import weapon.Spear;
import weapon.Sword;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Add implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private ArrayList<Integer> IdList = new ArrayList<>();
    private static int KnightID;
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
    @FXML
    TableView<Bow> BowTable;
    @FXML
    TableColumn<Bow,Double> BowCost = new TableColumn<>();
    @FXML
    TableColumn<Bow,Double> BowWeight = new TableColumn<>();
    @FXML
    TableColumn<Bow,String> BowType = new TableColumn<>();
    @FXML
    TableColumn<Bow,Double> BowStrength = new TableColumn<>();
    @FXML
    TableColumn<Bow,Integer> BowCount = new TableColumn<>();
    @FXML
    TableColumn<Bow,Boolean> BowIsLong = new TableColumn<>();
    @FXML
    TableView<HeavyWeapon> HeavyWeaponTable;
    @FXML
    TableColumn<HeavyWeapon,Double> HeavyWeaponCost = new TableColumn<>();
    @FXML
    TableColumn<HeavyWeapon,Double> HeavyWeaponWeight = new TableColumn<>();
    @FXML
    TableColumn<HeavyWeapon,String> HeavyWeaponType = new TableColumn<>();
    @FXML
    TableColumn<HeavyWeapon,Double> HeavyWeaponStrength = new TableColumn<>();
    @FXML
    TableColumn<HeavyWeapon,Boolean> HeavyWeaponIsSpiked = new TableColumn<>();
    @FXML
    TableView<Spear> SpearTable;
    @FXML
    TableColumn<Spear,Double> SpearCost = new TableColumn<>();
    @FXML
    TableColumn<Spear,Double> SpearWeight = new TableColumn<>();
    @FXML
    TableColumn<Spear,String> SpearType = new TableColumn<>();
    @FXML
    TableColumn<Spear,Double> SpearStrength = new TableColumn<>();
    @FXML
    TableColumn<Spear,Double> SpearLength = new TableColumn<>();
    @FXML
    TableView<Sword> SwordTable;
    @FXML
    TableColumn<Sword,Double> SwordCost = new TableColumn<>();
    @FXML
    TableColumn<Sword,Double> SwordWeight = new TableColumn<>();
    @FXML
    TableColumn<Sword,String> SwordType = new TableColumn<>();
    @FXML
    TableColumn<Sword,Double> SwordStrength = new TableColumn<>();

    @FXML
    TableColumn<Sword,Boolean> SwordIsCrooked = new TableColumn<>();
    @FXML
    TableColumn<Sword,Double> SwordSharpness = new TableColumn<>();

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
        BowCost.setCellValueFactory(new PropertyValueFactory<Bow,Double>("cost"));
        BowWeight.setCellValueFactory(new PropertyValueFactory<Bow,Double>("weight"));
        BowType.setCellValueFactory(new PropertyValueFactory<Bow,String>("type"));
        BowStrength.setCellValueFactory(new PropertyValueFactory<Bow,Double>("strength"));
        BowCount.setCellValueFactory(new PropertyValueFactory<Bow,Integer>("countofarrows"));
        BowIsLong.setCellValueFactory(new PropertyValueFactory<Bow,Boolean>("isLong"));
        HeavyWeaponCost.setCellValueFactory(new PropertyValueFactory<HeavyWeapon,Double>("cost"));
        HeavyWeaponWeight.setCellValueFactory(new PropertyValueFactory<HeavyWeapon,Double>("weight"));
        HeavyWeaponType.setCellValueFactory(new PropertyValueFactory<HeavyWeapon,String>("type"));
        HeavyWeaponStrength.setCellValueFactory(new PropertyValueFactory<HeavyWeapon,Double>("strength"));
        HeavyWeaponIsSpiked.setCellValueFactory(new PropertyValueFactory<HeavyWeapon,Boolean>("isSpiked"));
        SpearCost.setCellValueFactory(new PropertyValueFactory<Spear,Double>("cost"));
        SpearWeight.setCellValueFactory(new PropertyValueFactory<Spear,Double>("weight"));
        SpearType.setCellValueFactory(new PropertyValueFactory<Spear,String>("type"));
        SpearStrength.setCellValueFactory(new PropertyValueFactory<Spear,Double>("strength"));
        SpearLength.setCellValueFactory(new PropertyValueFactory<Spear,Double>("length"));
        SwordCost.setCellValueFactory(new PropertyValueFactory<Sword,Double>("cost"));
        SwordWeight.setCellValueFactory(new PropertyValueFactory<Sword,Double>("weight"));
        SwordType.setCellValueFactory(new PropertyValueFactory<Sword,String>("type"));
        SwordStrength.setCellValueFactory(new PropertyValueFactory<Sword,Double>("strength"));
        SwordIsCrooked.setCellValueFactory(new PropertyValueFactory<Sword,Boolean>("isCrooked"));
        SwordSharpness.setCellValueFactory(new PropertyValueFactory<Sword,Double>("sharpness"));
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
    public void Return(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("Menu2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu2");
        stage.setScene(scene);
        stage.show();
    }
    public void AddEquip(ActionEvent event) throws IOException
    {
        IdList.clear();
        Select select = new Select();
        String login = select.SelectLogin();
        if (!select.isEquip(KnightID,login))
        {
            root = FXMLLoader.load(getClass().getResource("AddEquip.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("AddEquip");
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.show();
        }
    }
    public void AddWeapon(ActionEvent event) throws IOException
    {
        IdList.clear();
        Select select = new Select();
        String login = select.SelectLogin();
        if (!select.isWeapon(KnightID,login))
        {
            root = FXMLLoader.load(getClass().getResource("AddWeapon.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("AddWeapon");
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.show();
        }
    }
    public void ReturnToChoose(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("ChooseKnight.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Choose Knight");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void GetData1(ActionEvent event) throws IOException
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
    @FXML
    public void GetData2(ActionEvent event) throws IOException
    {
        Select select = new Select();
        ObservableList<Bow> BowList = select.BowList();
        ObservableList<HeavyWeapon> HeavyWeaponList = select.HeavyWeaponList();
        ObservableList<Spear> SpearList = select.SpearList();
        ObservableList<Sword> SwordList = select.SwordList();
        BowTable.setItems(BowList);
        HeavyWeaponTable.setItems(HeavyWeaponList);
        SpearTable.setItems(SpearList);
        SwordTable.setItems(SwordList);
    }
    public void SelectHelmet(ActionEvent event) throws IOException
    {
        int Id = HelmetView.getSelectionModel().getSelectedIndex();
        Select select = new Select();
        String login = select.SelectLogin();
        double money = select.GetKnightMoney(KnightID,login);
        Insert insert = new Insert();
        Update update = new Update();
        if(Id >= 0)
        {
            Id++;
            System.out.println(Id);
            if(select.isHelmet(KnightID,login))
            {
                money -= select.GetHelmetMoney(Id);
                if(money > 0)
                {
                    insert.KnightHelmetList(Id,KnightID,login);
                    Knight knight = select.GetKnight(KnightID,login);
                    update.UpdateKnightMoney(login,money,knight);
                }
            }
        }
    }
    public void SelectBreastplate(ActionEvent event) throws IOException
    {
        int Id = BreastplateView.getSelectionModel().getSelectedIndex();
        Select select = new Select();
        String login = select.SelectLogin();
        double money = select.GetKnightMoney(KnightID,login);
        Insert insert = new Insert();
        Update update = new Update();
        if(Id >= 0)
        {
            Id += 251;
            System.out.println(Id);
            if(select.isBreastplate(KnightID,login))
            {
                money -= select.GetBreastplateMoney(Id);
                if(money > 0)
                {
                    insert.KnightBreastplateList(Id,KnightID,login);
                    Knight knight = select.GetKnight(KnightID,login);
                    update.UpdateKnightMoney(login,money,knight);
                }
            }
        }
    }
    public void SelectBoots(ActionEvent event) throws IOException
    {
        int Id = BootsView.getSelectionModel().getSelectedIndex();
        Select select = new Select();
        String login = select.SelectLogin();
        double money = select.GetKnightMoney(KnightID,login);
        Insert insert = new Insert();
        Update update = new Update();
        if(Id >= 0)
        {
            Id += 501;
            System.out.println(Id);
            if(select.isBoots(KnightID,login))
            {
                money -= select.GetBootsMoney(Id);
                if(money > 0)
                {
                    insert.KnightBootsList(Id,KnightID,login);
                    Knight knight = select.GetKnight(KnightID,login);
                    update.UpdateKnightMoney(login,money,knight);
                }
            }
        }
    }
    public void SelectShield(ActionEvent event) throws IOException
    {
        int Id = ShieldView.getSelectionModel().getSelectedIndex();
        Select select = new Select();
        String login = select.SelectLogin();
        double money = select.GetKnightMoney(KnightID,login);
        Insert insert = new Insert();
        Update update = new Update();
        if(Id >= 0)
        {
            Id += 751;
            System.out.println(Id);
            if(select.isShield(KnightID,login))
            {
                money -= select.GetShieldMoney(Id);
                if(money > 0)
                {
                    insert.KnightShieldList(Id,KnightID,login);
                    Knight knight = select.GetKnight(KnightID,login);
                    update.UpdateKnightMoney(login,money,knight);
                }
            }
        }
    }
    public void SelectBow(ActionEvent event) throws IOException
    {
        int Id = BowTable.getSelectionModel().getSelectedIndex();
        Select select = new Select();
        String login = select.SelectLogin();
        double money = select.GetKnightMoney(KnightID,login);
        Insert insert = new Insert();
        Update update = new Update();
        if(Id >= 0)
        {
            Id++;
            System.out.println(Id);
            if(select.isBow(KnightID,login))
            {
                money -= select.GetBowMoney(Id);
                if(money > 0)
                {
                    insert.KnightBowList(Id,KnightID,login);
                    Knight knight = select.GetKnight(KnightID,login);
                    update.UpdateKnightMoney(login,money,knight);
                }
            }
        }
    }
    public void SelectHeavyWeapon(ActionEvent event) throws IOException
    {
        int Id = HeavyWeaponTable.getSelectionModel().getSelectedIndex();
        Select select = new Select();
        String login = select.SelectLogin();
        double money = select.GetKnightMoney(KnightID,login);
        Insert insert = new Insert();
        Update update = new Update();
        if(Id >= 0)
        {
            Id += 251;
            System.out.println(Id);
            if(select.isHeavyWeapon(KnightID,login))
            {
                money -= select.GetHeavyWeaponMoney(Id);
                if(money > 0)
                {
                    insert.KnightHeavyWeaponList(Id,KnightID,login);
                    Knight knight = select.GetKnight(KnightID,login);
                    update.UpdateKnightMoney(login,money,knight);
                }
            }
        }
    }
    public void SelectSpear(ActionEvent event) throws IOException
    {
        int Id = SpearTable.getSelectionModel().getSelectedIndex();
        Select select = new Select();
        String login = select.SelectLogin();
        double money = select.GetKnightMoney(KnightID,login);
        Insert insert = new Insert();
        Update update = new Update();
        if(Id >= 0)
        {
            Id += 501;
            System.out.println(Id);
            if(select.isSpear(KnightID,login))
            {
                money -= select.GetSpearMoney(Id);
                if(money > 0)
                {
                    insert.KnightSpearList(Id,KnightID,login);
                    Knight knight = select.GetKnight(KnightID,login);
                    update.UpdateKnightMoney(login,money,knight);
                }
            }
        }
    }
    public void SelectSword(ActionEvent event) throws IOException
    {
        int Id = SwordTable.getSelectionModel().getSelectedIndex();
        Select select = new Select();
        String login = select.SelectLogin();
        double money = select.GetKnightMoney(KnightID,login);
        Insert insert = new Insert();
        Update update = new Update();
        if(Id >= 0)
        {
            Id += 751;
            System.out.println(Id);
            if(select.isSword(KnightID,login))
            {
                money -= select.GetSwordMoney(Id);
                if(money > 0)
                {
                    insert.KnightSwordList(Id,KnightID,login);
                    Knight knight = select.GetKnight(KnightID,login);
                    update.UpdateKnightMoney(login,money,knight);
                }
            }
        }
    }
}
