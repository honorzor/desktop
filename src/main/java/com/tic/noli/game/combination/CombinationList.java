package com.tic.noli.game.combination;

import com.tic.noli.game.enums.CombinationType;
import javafx.scene.control.TextField;

import java.util.List;

public interface CombinationList {
    List<List<TextField>> getCombinationsList();
    CombinationType getCombinationType();
}
