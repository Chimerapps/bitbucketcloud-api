package com.chimerapps.bitbucketcloud.api;

import com.chimerapps.bitbucketcloud.api.model.*;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * @author nicolaverbeeck
 */
public interface BitbucketApi {

    @GET("user")
    Call<BitbucketUser> getUser();

    @GET("repositories/{user}")
    Call<PagedList<BitbucketRepository>> getRepositories(@Path("user") final String user,
                                                         @Nullable @Query("q") final com.chimerapps.bitbucketcloud.api.model.filter.Query search);

    @GET
    Call<PagedList<BitbucketRepository>> getRepositoriesPage(@Url final String pageUrl);

    @GET("repositories/{user}/{repoSlug}/default-reviewers")
    Call<PagedList<DefaultReviewer>> getDefaultReviewers(@Path("user") final String user,
                                          @Path("repoSlug") final String repoSlug);

    @POST("repositories/{user}/{repoSlug}/pullrequests")
    Call<PullRequest> postPullRequest(@Path("user") final String user,
                                      @Path("repoSlug") final String repoSlug,
                                      @Body final PullRequest pullRequest);
}
