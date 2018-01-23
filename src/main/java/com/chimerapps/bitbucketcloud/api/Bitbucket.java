package com.chimerapps.bitbucketcloud.api;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * @author nicolaverbeeck
 */
public class Bitbucket {

    private final BitbucketApi mApi;
    private final OkHttpClient mOkHttpClient;

    public Bitbucket(@NotNull final String username, @NotNull final String appToken) {
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AuthenticationInterceptor(username, appToken))
                .build();
        final Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl("https://api.bitbucket.org/2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApi = retrofit.create(BitbucketApi.class);
    }

    public BitbucketApi getApi() {
        return mApi;
    }

    public void shutdown() {
        mOkHttpClient.dispatcher().executorService().shutdown();
        mOkHttpClient.connectionPool().evictAll();
        try {
            final Cache cache = mOkHttpClient.cache();
            if (cache != null)
                cache.close();
        } catch (final IOException ignored) {
        }
    }
}
