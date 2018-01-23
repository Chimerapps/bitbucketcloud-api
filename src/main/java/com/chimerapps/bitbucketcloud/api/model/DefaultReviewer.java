package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koen Van Looveren
 */
public class DefaultReviewer {

    @NotNull
    @SerializedName("username")
    private final String mUsername;

    @NotNull
    @SerializedName("display_name")
    private final String mDisplayName;

    @NotNull
    @SerializedName("type")
    private final String mType;

    @NotNull
    @SerializedName("uuid")
    private final String mUuid;

    public DefaultReviewer(@NotNull String username, @NotNull String displayName, @NotNull String type, @NotNull String uuid) {
        this.mUsername = username;
        this.mDisplayName = displayName;
        this.mType = type;
        this.mUuid = uuid;
    }

    @NotNull
    public String getUsername() {
        return mUsername;
    }

    @NotNull
    public String getDisplayName() {
        return mDisplayName;
    }

    @NotNull
    public String getType() {
        return mType;
    }

    @NotNull
    public String getUuid() {
        return mUuid;
    }

    @Override
    public String toString() {
        return "DefaultReviewer{" +
                "username='" + mUsername + '\'' +
                ", displayName='" + mDisplayName + '\'' +
                ", type='" + mType + '\'' +
                ", uuid='" + mUuid + '\'' +
                '}';
    }
}
