package com.company;

import com.company.infrastructure.Account;
import com.company.interfaces.ChangeSceneListener;
import com.company.ui.MainScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application implements ChangeSceneListener {

    private Stage window;
    private ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
	    launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        this.window = window;
        changeScene(new MainScreen(this));
        window.show();
    }

    @Override
    public void changeScene(VBox layout){
        window.setScene(new Scene(layout, 600, 400));
    }

    @Override
    public void addAccount(Account a) {
        accounts.add(a);
    }


}
