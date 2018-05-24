package ua.com.khai.zaika.UI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ua.com.khai.zaika.services.ServicesLoader.ServicesLoadeFactory.implementation.ServicesLoaderFactoryImpl;
import ua.com.khai.zaika.services.ServicesLoader.ServicesLoadeFactory.interfaces.ServicesLoaderFactory;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.PatternSyntaxException;

public class RegularExpressionsUtilityMainForm implements Initializable {
    private ServicesLoaderFactory factory = new ServicesLoaderFactoryImpl();
    private static final String INFO_MESSAGE = "This is the regular expression helper made by Zaika Vladimir Igorevich from 603th department of 6th faculty of Khai also known as LesnickBear";
    private static final String INFO_TITLE = "About";
    private Stage stage;
    private File regexpFile;
    private File textFile;
    @FXML
    private Label errorLabel;
    @FXML
    private TextArea regularExpressionTextField;
    @FXML
    private TextArea operatedTextTextField;
    @FXML
    private TextFlow tokensTextFlow;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        regularExpressionTextField.textProperty().addListener((observable, oldValue, newValue) -> findTokens(operatedTextTextField.getText(), regularExpressionTextField.getText()));
        operatedTextTextField.textProperty().addListener((observable, oldValue, newValue) -> findTokens(operatedTextTextField.getText(), regularExpressionTextField.getText()));
    }

    public RegularExpressionsUtilityMainForm(Stage stage) {
        this.stage = stage;
    }

    private void findTokens(final String text, final String regExpression) {
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
        stage.hide();
    }

    private void onAboutHidden() {
        stage.show();
    }

    @FXML
    void onTextSave() {
        if (textFile == null) {
            onTextSaveAs();
        } else {
            factory.getBinarySerializer().saveText(operatedTextTextField.getText(), textFile);
        }
    }

    @FXML
    void onTextLoad() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load text");
        fileChooser.setInitialDirectory(new File("D:/"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        textFile = fileChooser.showOpenDialog(stage);
        if (textFile != null) {
            operatedTextTextField.setText(factory.getBinarySerializer().loadRegExp(textFile));
        }
    }

    @FXML
    void onTextSaveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save text");
        fileChooser.setInitialDirectory(new File("D:/"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        textFile = fileChooser.showOpenDialog(stage);
        if (textFile != null) {
            onExpressionSave();
        }
    }

    @FXML
    void onExpressionLoad() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load regular expression");
        fileChooser.setInitialDirectory(new File("D:/"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("RegExp files (*.regex)", "*.regex"));
        regexpFile = fileChooser.showOpenDialog(stage);
        if (regexpFile != null) {
            regularExpressionTextField.setText(factory.getBinarySerializer().loadRegExp(regexpFile));
        }
    }

    @FXML
    void onExpressionSave() {
        if (regexpFile == null) {
            onExpressionSaveAs();
        } else {
            factory.getBinarySerializer().saveRegExp(regularExpressionTextField.getText(), regexpFile);
        }
    }

    @FXML
    void onExpressionSaveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save regular expression");
        fileChooser.setInitialDirectory(new File("D:/"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("RegExp files (*.regex)", "*.regex"));
        regexpFile = fileChooser.showOpenDialog(stage);
        if (regexpFile != null) {
            onExpressionSave();
        }
    }


}
