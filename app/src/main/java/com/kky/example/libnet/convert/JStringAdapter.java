package com.kky.example.libnet.convert;/*
 * @description
 * @author Zeus
 * @time 2022/6/9 18:15
 * @change remark
 * @change 2022/6/9 18:15
 */

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

public class JStringAdapter implements JsonSerializer<String>, JsonDeserializer<String> {
    @Override
    public String deserialize(JsonElement json, Type typeOfT,
                              JsonDeserializationContext context)
            throws JsonParseException {
        String rawStr = json.getAsString();
        Log.e("login-or", "typeOfT--" + typeOfT);
        Log.e("login-or", "context--" + context);

        try {
            if (rawStr.equals("") || rawStr.equals(null) || rawStr.equals("null")) {
                return "";
            }
        } catch (Exception ignore) {
        }
        try {
            return "xx-ss--" + rawStr;
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override
    public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src);
    }
}
