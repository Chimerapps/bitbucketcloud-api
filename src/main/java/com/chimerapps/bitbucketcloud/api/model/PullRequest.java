package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Koen Van Looveren
 */
public class PullRequest {

    @NotNull
    @SerializedName("id")
    private final int mId;

    @NotNull
    @SerializedName("title")
    private final String mTitle;

    @NotNull
    @SerializedName("description")
    private final String mDescription;

    @NotNull
    @SerializedName("destination")
    private final Destination mDestination;

    @SerializedName("close_source_branch")
    private final boolean mCloseSourceBranch;

    @NotNull
    @SerializedName("source")
    private final Destination mSource;

    @Nullable
    @SerializedName("reviewers")
    private final List<DefaultReviewer> mReviewers;

    public PullRequest(@NotNull int id,
                       @NotNull String title,
                       @NotNull String description,
                       @NotNull Destination source,
                       @NotNull Destination destination,
                       @Nullable List<DefaultReviewer> reviewers) {
        mId = id;
        mTitle = title;
        mDescription = description;
        mSource = source;
        mDestination = destination;
        mReviewers = reviewers;
        mCloseSourceBranch = true;
    }

    @NotNull
    public int getId() {
        return mId;
    }

    @NotNull
    public String getTitle() {
        return mTitle;
    }

    @NotNull
    public String getDescription() {
        return mDescription;
    }

    @NotNull
    public Destination getDestination() {
        return mDestination;
    }

    @NotNull
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
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mDestination=" + mDestination +
                ", mCloseSourceBranch=" + mCloseSourceBranch +
                ", mSource=" + mSource +
                ", mReviewers=" + mReviewers +
                '}';
    }
}
