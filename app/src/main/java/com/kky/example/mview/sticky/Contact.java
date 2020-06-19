package com.kky.example.mview.sticky;

import android.text.TextUtils;

public class Contact {
    public static final String groupPrefix = "GroupX";
    private String name;
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean isGroup() {
        if (TextUtils.isEmpty(name)) {
            return false;
        } else {
            if (name.contains(groupPrefix)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
