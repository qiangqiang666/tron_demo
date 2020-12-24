package com.tron.demo.util;

import com.google.gson.*;

import java.sql.Date;

/**
 * 描述:
 * 〈〉
 *
 * @author Monkey
 * @create 2020/12/2 15:01
 */
public class GsonUtil {

    public static Gson getGson(){
        GsonBuilder builder = new GsonBuilder();
        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement json, java.lang.reflect.Type arg1, JsonDeserializationContext arg2)
                    throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        Gson gson = builder.create();
       return gson;
    }
}