package com.company.interfaces;

import com.company.infrastructure.Account;
import javafx.scene.layout.VBox;

/**
 * Created by hackeru on 15/03/2017.
 */
public interface ChangeSceneListener {

    void changeScene(VBox layout);
    void addAccount(Account a);

}
