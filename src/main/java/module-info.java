module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires slf4j.api;
    requires java.sql;
    requires java.mail;
    requires java.desktop;
    requires java.datatransfer;
    requires com.microsoft.sqlserver.jdbc;

    opens knight to javafx.fxml;
    opens equipment to javafx.fxml;
opens database to javafx.fxml;
opens data to javafx.fxml;
opens command to javafx.fxml;
opens weapon to javafx.fxml;
    opens com.example.demo to javafx.fxml;
    exports knight;
    exports equipment;
    exports database;
    exports data;
    exports command;
    exports com.example.demo;
    exports weapon;
}