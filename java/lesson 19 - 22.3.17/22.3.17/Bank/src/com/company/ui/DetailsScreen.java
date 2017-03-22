package com.company.ui;

import com.company.infrastructure.Account;
import com.company.infrastructure.BasicScreen;
import com.company.interfaces.ChangeSceneListener;
import javafx.scene.text.Text;

/**
 * Created by hackeru on 15/03/2017.
 */
public class DetailsScreen extends BasicScreen {

    public DetailsScreen(ChangeSceneListener listener, Account account){
        super(listener);
        Text accountNumberLabel = new Text("Account number: " + account.getNumber());
        getChildren().add(0, accountNumberLabel);
    }

}
