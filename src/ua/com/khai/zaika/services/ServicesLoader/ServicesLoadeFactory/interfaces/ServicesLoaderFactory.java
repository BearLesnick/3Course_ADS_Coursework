package ua.com.khai.zaika.services.ServicesLoader.ServicesLoadeFactory.interfaces;

import ua.com.khai.zaika.services.ServicesLoader.interfaces.RegExpHandler;
import ua.com.khai.zaika.services.ServicesLoader.interfaces.RegExpLoader;
import ua.com.khai.zaika.services.ServicesLoader.interfaces.TextLoader;

public interface ServicesLoaderFactory {
    RegExpLoader getRegExpLoader();
    TextLoader getTextLoader();
    RegExpHandler getRegExpHandler();
}
