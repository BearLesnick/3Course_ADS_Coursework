package ua.com.khai.zaika.services.ServicesLoader.implementation;

import javafx.scene.control.Alert;
import ua.com.khai.zaika.services.ServicesLoader.interfaces.BinarySerializer;

import java.io.*;

public class BinarySerializerImpl implements BinarySerializer {
    @Override
    public boolean saveText(String text, File file) {
        try {
            if(!file.createNewFile())
            {
                throw new IOException("Can not create file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(text);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean saveRegExp(String text, File file) {
        try {
            if(!file.createNewFile())
            {
             throw new IOException("Can not create file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(text);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String loadRegExp(File file) {

        try ( InputStream in = new FileInputStream(file)){
            ObjectInputStream out = new ObjectInputStream(in);
            return (String) out.readObject();
        }
        catch ( ClassNotFoundException e )
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Data file was crashed, data recovery is not possible");
            alert.show();
            return "";
        }
        catch (FileNotFoundException e)
        {
            return "";
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.show();
            return "";
        }
    }

    @Override
    public String loadText(File file) {
        return loadRegExp(file);
    }
}
