package com.example.robinsprojekt;

import java.util.ArrayList;
import java.util.List;
import org.json.*;

public class JsonString {
    private String rsc;

    public JsonString(String rsc) {
        this.rsc = rsc;
    }

    // Read Json String and convert to data
    public List<String[]> getData() {
        List<String[]> data = new ArrayList<>();
        try {
            JSONArray jArray = new JSONArray((rsc));
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jObject = jArray.getJSONObject(i);
                String id = jObject.getString("ID");
                String name = jObject.getString("name");

                data.add(new String[]{id, name});
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }
}
