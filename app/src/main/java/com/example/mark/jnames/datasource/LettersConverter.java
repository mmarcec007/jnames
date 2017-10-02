package com.example.mark.jnames.datasource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mark on 02.10.2017..
 */

public class LettersConverter {
    Map<String, String> map = new HashMap<String, String>();

    public LettersConverter(Map<String, String> map) {
        map.put("Color1","Red");
        map.put("Color2","Blue");
        map.put("Color3","Green");
        map.put("Color4","White");
        this.map = map;
    }
}
