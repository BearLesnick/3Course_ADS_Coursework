package ua.com.khai.zaika.services.ServicesLoader.interfaces;

import javafx.scene.text.Text;

import java.util.List;

public interface RegExpHandler {
   List<Text> findTokens(String text, String regExpression);
}
