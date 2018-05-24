package ua.com.khai.zaika.services.ServicesLoader.ServicesLoadeFactory.implementation;

import ua.com.khai.zaika.services.ServicesLoader.ServicesLoadeFactory.interfaces.ServicesLoaderFactory;
import ua.com.khai.zaika.services.ServicesLoader.implementation.BinarySerializerImpl;
import ua.com.khai.zaika.services.ServicesLoader.implementation.RegExpHandlerImpl;
import ua.com.khai.zaika.services.ServicesLoader.implementation.RegExpLoaderImpl;
import ua.com.khai.zaika.services.ServicesLoader.implementation.TextLoaderImpl;
import ua.com.khai.zaika.services.ServicesLoader.interfaces.BinarySerializer;
import ua.com.khai.zaika.services.ServicesLoader.interfaces.RegExpHandler;
import ua.com.khai.zaika.services.ServicesLoader.interfaces.RegExpLoader;
import ua.com.khai.zaika.services.ServicesLoader.interfaces.TextLoader;

public class ServicesLoaderFactoryImpl implements ServicesLoaderFactory {
    @Override
    public RegExpLoader getRegExpLoader() {
        return new RegExpLoaderImpl();
    }

    @Override
    public TextLoader getTextLoader() {
        return new TextLoaderImpl();
    }

    @Override
    public RegExpHandler getRegExpHandler() {
        return new RegExpHandlerImpl();
    }

    @Override
    public BinarySerializer getBinarySerializer() {
        return new BinarySerializerImpl();
    }
}
