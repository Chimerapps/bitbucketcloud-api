package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public class Branch {

    @SerializedName("name")
    private final String mName;

    public Branch(@NotNull String name) {
        this.mName = name;
    }

    public String getBranchName() {
        return mName;
    }
}
