package com.chimerapps.bitbucketcloud.api;

import com.chimerapps.bitbucketcloud.api.model.BitbucketRepository;
import com.chimerapps.bitbucketcloud.api.model.BitbucketUser;
import com.chimerapps.bitbucketcloud.api.model.PagedList;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

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

}
