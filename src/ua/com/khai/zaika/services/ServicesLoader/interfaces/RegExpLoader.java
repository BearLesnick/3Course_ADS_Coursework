package ua.com.khai.zaika.services.ServicesLoader.interfaces;

import java.io.File;

public interface RegExpLoader {
    boolean saveRegExpIntoFile (File file);
    boolean loadRegExpFromFile( File file);
}
