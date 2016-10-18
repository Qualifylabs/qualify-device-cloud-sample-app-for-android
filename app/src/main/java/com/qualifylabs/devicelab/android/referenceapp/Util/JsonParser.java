package com.qualifylabs.devicelab.android.referenceapp.Util;

import android.content.Context;

import com.qualifylabs.devicelab.android.referenceapp.Models.DrawerCategoryModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Parses Json into the data models
 */
public class JsonParser {

    private Context context;
    private int resId;

    public JsonParser(Context context, int resId) {
        this.context = context;
        this.resId = resId;
    }

    /**
     * Parses the JSON file into data models
     * @return List of DrawerCategory Models
     */
    public List<DrawerCategoryModel> serializeJson(){
        try {
            Reader reader = new InputStreamReader(context.getResources().openRawResource(resId));
            Gson gson = new GsonBuilder().create();
            Type listType = new TypeToken<List<DrawerCategoryModel>>(){}.getType();
            List<DrawerCategoryModel> list = gson.fromJson(reader,listType);
            reader.close();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
