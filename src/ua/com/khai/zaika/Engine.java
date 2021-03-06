package ua.com.khai.zaika;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ua.com.khai.zaika.UI.RegularExpressionsUtilityMainForm;

import java.io.IOException;

public class Engine extends Application {
    public static void main(String[] args) {
        Application.launch(Engine.class);

    }
    private void launchForm() throws IOException {
        FXMLLoader loader = new FXMLLoader(RegularExpressionsUtilityMainForm.class.getResource("RegularExpressionsUtilityMainForm.fxml"));
        Stage stage = new Stage();
        loader.setControllerFactory( le-> new RegularExpressionsUtilityMainForm(stage));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene( scene);
        stage.show();

    }
    @Override
    public void start(Stage primaryStage){
        try {
            launchForm();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
