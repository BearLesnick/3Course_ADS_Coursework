package ua.com.khai.zaika.UI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;
import ua.com.khai.zaika.services.ServicesLoader.ServicesLoadeFactory.implementation.ServicesLoaderFactoryImpl;
import ua.com.khai.zaika.services.ServicesLoader.ServicesLoadeFactory.interfaces.ServicesLoaderFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.PatternSyntaxException;

public class RegularExpressionsUtilityMainForm implements Initializable {
    private ServicesLoaderFactory factory = new ServicesLoaderFactoryImpl();
    private static final String INFO_MESSAGE = "Test Message";
    private static final String INFO_TITLE = "Test Title";
    File regexpFile;
    File textFile;
    @FXML
    Label errorLabel;
    @FXML
    TextArea regularExpressionTextField;
    @FXML
    TextArea operatedTextTextField;
    @FXML
    TextFlow tokensTextFlow;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        regularExpressionTextField.textProperty().addListener((observable, oldValue, newValue) -> findTokens(operatedTextTextField.getText(), regularExpressionTextField.getText()));
        operatedTextTextField.textProperty().addListener((observable, oldValue, newValue) -> findTokens(operatedTextTextField.getText(), regularExpressionTextField.getText()));
    }

    public RegularExpressionsUtilityMainForm() {

    }

    private void findTokens(String text, String regExpression) {
        tokensTextFlow.getChildren().clear();
        errorLabel.setVisible(false);
        try {
            tokensTextFlow.getChildren().setAll(factory.getRegExpHandler().findTokens(text, regExpression));
        } catch (PatternSyntaxException e) {
            errorLabel.setVisible(true);
        }

    }

    @FXML
    void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(INFO_TITLE);
        alert.setContentText(INFO_MESSAGE);
        alert.setOnShowing(le -> this.onAboutShowed());
        alert.setOnHidden(le -> onAboutHidden());
        alert.show();
    }

    private void onAboutShowed() {

    }

    private void onAboutHidden() {
    }

    @FXML
    void onTextSave() {


    }

    @FXML
    void onTextLoad() {
    }

    @FXML
    void onTextSaveAs() {
    }

    @FXML
    void onExpressionLoad() {
    }

    @FXML
    void onExpressionSave() {
    }

    @FXML
    void onExpressionSaveAs() {
    }


}
