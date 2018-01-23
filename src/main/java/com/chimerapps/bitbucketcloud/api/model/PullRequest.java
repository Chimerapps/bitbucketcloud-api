package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
    @SerializedName("close_source_branch")
    private final boolean mCloseSourceBranch;
    @SerializedName("source")
    private final Destination mSource;
    @Nullable
    @SerializedName("reviewers")
    private final List<DefaultReviewer> mReviewers;

    public PullRequest(@NotNull String title,
                       @NotNull String description,
                       @NotNull Destination source,
                       @NotNull Destination destination,
                       @Nullable List<DefaultReviewer> reviewers) {
        mTitle = title;
        mDescription = description;
        mSource = source;
        mDestination = destination;
        mReviewers = reviewers;
        mCloseSourceBranch = true;
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

    @Nullable
    public List<DefaultReviewer> getReviewers() {
        return mReviewers;
    }

    public boolean isCloseSourceBranch() {
        return mCloseSourceBranch;
    }

    @Override
    public String toString() {
        return "PullRequest{" +
                "title='" + mTitle + '\'' +
                ", description='" + mDescription + '\'' +
                ", destination=" + mDestination +
                ", source=" + mSource +
                ", reviewers=" + mReviewers +
                ", closeSourceBranch=" + mCloseSourceBranch +
                '}';
    }
}
