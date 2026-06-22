module lk.ijse.studentattendancemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports lk.ijse.studentattendancemanagementsystem;
    opens lk.ijse.studentattendancemanagementsystem to javafx.fxml, javafx.graphics;
    opens lk.ijse.studentattendancemanagementsystem.controller to javafx.fxml;
    opens lk.ijse.studentattendancemanagementsystem.dto to javafx.base;
    opens lk.ijse.studentattendancemanagementsystem.model to javafx.base;
    opens lk.ijse.studentattendancemanagementsystem.BO to javafx.base;
    opens lk.ijse.studentattendancemanagementsystem.BO.custom to javafx.base;
    opens lk.ijse.studentattendancemanagementsystem.BO.custom.impl to javafx.base;
    opens lk.ijse.studentattendancemanagementsystem.dao to javafx.base;
    opens lk.ijse.studentattendancemanagementsystem.dao.custom to javafx.base;
    opens lk.ijse.studentattendancemanagementsystem.dao.custom.impl to javafx.base;
    opens lk.ijse.studentattendancemanagementsystem.entity to javafx.base;
    opens lk.ijse.studentattendancemanagementsystem.db to javafx.base;
    
}