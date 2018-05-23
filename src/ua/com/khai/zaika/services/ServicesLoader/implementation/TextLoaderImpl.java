package ua.com.khai.zaika.services.ServicesLoader.implementation;

import ua.com.khai.zaika.services.ServicesLoader.interfaces.TextLoader;

import java.io.File;

public class TextLoaderImpl implements TextLoader {
    @Override
    public boolean saveTextIntoFile(String text, File file) {
        return false;
    }

    @Override
    public String loadTextFromFile(File file) {
        return null;
    }
}
