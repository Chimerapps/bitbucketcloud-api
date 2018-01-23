package com.chimerapps.bitbucketcloud.api;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author nicolaverbeeck
 */
class AuthenticationInterceptor implements Interceptor {

    private final String mUserName;
    private final String mAppToken;

    public AuthenticationInterceptor(final String userName, final String appToken) {
        mUserName = userName;
        mAppToken = appToken;
    }

    @Override
    public Response intercept(final Chain chain) throws IOException {
        final Request newRequest = chain.request().newBuilder()
                .addHeader("Authorization", Credentials.basic(mUserName, mAppToken))
                .build();
        return chain.proceed(newRequest);
    }
}
