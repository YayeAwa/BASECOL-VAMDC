package org.vamdc.BasecolTest.dao;

import org.vamdc.basecolTest.dao.auto._BasecolTestMap;

public class BasecolTestMap extends _BasecolTestMap {

    private static BasecolTestMap instance;

    private BasecolTestMap() {}

    public static BasecolTestMap getInstance() {
        if(instance == null) {
            instance = new BasecolTestMap();
        }

        return instance;
    }
}
