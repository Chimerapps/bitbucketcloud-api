package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koen Van Looveren
 */
public class PullRequest {
    @SerializedName("title")
    private final String mTitle;
    @SerializedName("description")
    private final String mDescription;
    @SerializedName("destination")
    private final Destination mDestination;
    @SerializedName("source")
    private final Destination mSource;

    public PullRequest(@NotNull String title,
                       @NotNull String description,
                       @NotNull Destination source,
                       @NotNull Destination destination) {
        mTitle = title;
        mDescription = description;
        mSource = source;
        mDestination = destination;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public Destination getDestination() {
        return mDestination;
    }

    public Destination getSource() {
        return mSource;
    }
}
