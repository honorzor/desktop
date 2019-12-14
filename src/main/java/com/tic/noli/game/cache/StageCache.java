package com.tic.noli.game.cache;

import com.tic.noli.game.enums.ViewPath;
import javafx.stage.Stage;

import java.util.LinkedHashMap;
import java.util.Map;

public class StageCache {

    private final Map<ViewPath, Stage> lastStages = new LinkedHashMap<>();


    public void closeOtherStages(ViewPath besides) {
        lastStages
                .entrySet()
                .stream()
                .filter(viewPathStageEntry -> viewPathStageEntry.getKey() != besides)
                .forEach(viewPathStageEntry -> viewPathStageEntry.getValue().close());
    }

    public Stage get(ViewPath viewPath) {
        return lastStages.get(viewPath);
    }

    public void put(ViewPath viewPath, Stage stage) {
        lastStages.put(viewPath, stage);
    }
}
