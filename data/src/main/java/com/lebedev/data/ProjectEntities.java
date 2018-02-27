package com.lebedev.data;

import com.lebedev.entities.User;

public class ProjectEntities {
    private ProjectEntities() {
    }

    public static User getUser(String id) {
        return DataLoader.get(User.class, id);
    }
}
