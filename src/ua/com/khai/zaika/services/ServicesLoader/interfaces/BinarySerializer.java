package ua.com.khai.zaika.services.ServicesLoader.interfaces;

import java.io.File;

public interface BinarySerializer {
    boolean saveText(String text, File file);
    boolean saveRegExp(String text, File file);
    String loadRegExp(File file);
    String loadText (File file);
}
