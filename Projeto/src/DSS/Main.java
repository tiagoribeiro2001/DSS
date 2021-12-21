package DSS;

import DSS.UI.TextUI;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File fich = new File("estadoApp");
        TextUI ti;
        if (!fich.exists()) {
            ti = new TextUI();
            ti.run();
        }
        else {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("estadoApp"));
            ti = (TextUI) is.readObject();
            ti.run();
        }
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("estadoApp"));
        os.writeObject(ti);
    }
}
