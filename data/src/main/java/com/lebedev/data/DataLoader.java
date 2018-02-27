package com.lebedev.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.lebedev.entities.User;
import com.lebedev.utils.config.GlobalConfig;
import com.lebedev.utils.config.TestConfig;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DataLoader {

    @AllArgsConstructor
    public static class EntityFile {
        Class aClass;
        String path;
    }

    private static Map<EntityFile, Type> dataSet = new HashMap<EntityFile, Type>() {{
        put(new EntityFile(User.class, "users"), new TypeToken<Map<String, User>>() {{
        }}.getType());
    }};
    private static Map<Class, Map<String, Object>> collect;

    @SneakyThrows
    private static JsonReader getJReader(String path) {
        return new JsonReader(new FileReader(new File(path)));
    }

    private static void loadResources() {
        collect = dataSet.entrySet().stream().collect(Collectors.toMap(
                e -> e.getKey().aClass,
                e -> new Gson().fromJson(
                        DataLoader.getJReader(String.format("%s/%s.json",GlobalConfig.get().path(), e.getKey().path)),
                        e.getValue()))
        );
    }

    private static Map<String, Object> getCommon(Class aClass) {
        if (Objects.isNull(collect))
            loadResources();
        return collect.get(aClass);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> tClass, String id) {
        return (T) getCommon(tClass).get(id);
    }
}
