package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

/**
 * @author Koen Van Looveren
 */
public class Destination {
    @SerializedName("branch")
    private final Branch mBranch;

    public Destination(@NotNull String branchName) {
        mBranch = new Branch(branchName);
    }

    public Branch getBranch() {
        return mBranch;
    }
}
