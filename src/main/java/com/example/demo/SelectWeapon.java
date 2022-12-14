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

import javax.swing.text.TabableView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SelectWeapon implements Initializable {
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
    public void Return(ActionEvent event) throws IOException
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
                money -= select.GetBowMoney(IdList.get(i));
                System.out.println(money);
            }
            if(IdList.get(i) > 250 && IdList.get(i) <= 500)
            {
                money -= select.GetHeavyWeaponMoney(IdList.get(i));
                System.out.println(money);
            }
            if(IdList.get(i) > 500 && IdList.get(i) <= 750)
            {
                money -= select.GetSpearMoney(IdList.get(i));
                System.out.println(money);
            }
            if(IdList.get(i) > 750 && IdList.get(i) <= 1000)
            {
                money -= select.GetSwordMoney(IdList.get(i));
                System.out.println(money);
            }
        }
        if(select.isWeapon(KnightID,login))
        {
            if(money > 0.0 && KnightID > 0)
            {
                for (int i = 0;i < IdList.size();i++)
                {
                    if(IdList.get(i) > 0 && IdList.get(i) <= 250)
                    {
                        insert.KnightBowList(IdList.get(i),KnightID, login);
                    }
                    if(IdList.get(i) > 250 && IdList.get(i) <= 500)
                    {
                        insert.KnightHeavyWeaponList(IdList.get(i),KnightID, login);
                    }
                    if(IdList.get(i) > 500 && IdList.get(i) <= 750)
                    {
                        insert.KnightSpearList(IdList.get(i),KnightID, login);
                    }
                    if(IdList.get(i) > 750 && IdList.get(i) <= 1000)
                    {
                        insert.KnightSwordList(IdList.get(i),KnightID,login);
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
            System.out.println("You have weapon for this Knight");
        }
        root = FXMLLoader.load(getClass().getResource("Menu2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu2");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void GetData(ActionEvent event) throws IOException
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
    public void GetKnights(ActionEvent event) throws IOException
    {
        Select select = new Select();
        String login = select.SelectLogin();
        ObservableList<Knight> knights = select.SelectKnights(login);
        tableView.setItems(knights);
    }
    public void SelectBow(ActionEvent event) throws IOException
    {
        int ch = 0;
        int Id = BowTable.getSelectionModel().getSelectedIndex();
        System.out.println(Id);
        if(Id >= 0)
        {
            for(int i = 0;i < IdList.size();i++)
            {
                if(IdList.get(i) >= 0 && IdList.get(i) < 250)
                {
                    System.out.println("You have Bow");
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
    public void SelectHeavyWeapon(ActionEvent event) throws IOException
    {
        int ch = 0;
        int Id = HeavyWeaponTable.getSelectionModel().getSelectedIndex();
        if(Id >= 0)
        {
            Id += 250;
            System.out.println(Id);
            for(int i = 0;i < IdList.size();i++)
            {
                if(IdList.get(i) >= 250 && IdList.get(i) < 500)
                {
                    System.out.println("You have HeavyWeapon");
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
    public void SelectSpear(ActionEvent event) throws IOException
    {
        int ch = 0;
        int Id = SpearTable.getSelectionModel().getSelectedIndex();
        if(Id >= 0)
        {
            Id += 500;
            System.out.println(Id);
            for(int i = 0;i < IdList.size();i++)
            {
                if(IdList.get(i) >= 500 && IdList.get(i) < 750)
                {
                    System.out.println("You have Spear");
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
    public void SelectSword(ActionEvent event) throws IOException
    {
        int ch = 0;
        int Id = SwordTable.getSelectionModel().getSelectedIndex();
        if(Id >= 0)
        {
            Id += 750;
            System.out.println(Id);
            for(int i = 0;i < IdList.size();i++)
            {
                if(IdList.get(i) >= 750 && IdList.get(i) < 1000)
                {
                    System.out.println("You have Sword");
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
}
