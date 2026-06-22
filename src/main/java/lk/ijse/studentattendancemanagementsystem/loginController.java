package lk.ijse.studentattendancemanagementsystem;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class loginController {

    @FXML
    private Button adminBtn;

    @FXML
    private Button lecturerBtn;

    @FXML
    private Label loginLbl;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private void adminBtnOnAction() throws IOException {
         
       Parent root = FXMLLoader.load(App.class.getResource("security.fxml"));
       Stage stage = new Stage();
       stage.setScene(new Scene(root));
       stage.show();

       Stage currentStage=(Stage)adminBtn.getScene().getWindow();
       currentStage.close();
       
    }

    @FXML
   private void lecturerBtnOnAction() throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource("security.fxml"));
       Stage stage = new Stage();
       stage.setScene(new Scene(root));
       stage.show();

       Stage currentStage=(Stage)adminBtn.getScene().getWindow();
       currentStage.close();
       

    }

}
