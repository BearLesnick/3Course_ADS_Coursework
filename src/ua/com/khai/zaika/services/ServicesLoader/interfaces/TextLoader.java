package ua.com.khai.zaika.services.ServicesLoader.interfaces;

import java.io.File;

public interface TextLoader {
    boolean saveTextIntoFile(String text, File file);
    String loadTextFromFile(File file);
}
