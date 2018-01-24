package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Koen Van Looveren
 */
public class DefaultReviewer {

    @NotNull
    @SerializedName("username")
    private final String mUsername;

    @Nullable
    @SerializedName("display_name")
    private final String mDisplayName;

    @Nullable
    @SerializedName("type")
    private final String mType;

    @Nullable
    @SerializedName("uuid")
    private final String mUuid;

    public DefaultReviewer(@NotNull String username) {
        this(username, null, null, null);
    }

    public DefaultReviewer(@NotNull String username, @Nullable String displayName, @Nullable String type, @Nullable String uuid) {
        this.mUsername = username;
        this.mDisplayName = displayName;
        this.mType = type;
        this.mUuid = uuid;
    }

    @NotNull
    public String getUsername() {
        return mUsername;
    }

    @Nullable
    public String getDisplayName() {
        return mDisplayName;
    }

    @Nullable
    public String getType() {
        return mType;
    }

    @Nullable
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
