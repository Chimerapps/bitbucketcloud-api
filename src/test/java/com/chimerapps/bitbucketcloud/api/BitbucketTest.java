package com.chimerapps.bitbucketcloud.api;

import com.chimerapps.bitbucketcloud.api.model.BitbucketUser;
import com.chimerapps.bitbucketcloud.api.model.filter.PropertyCompare;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

/**
 * @author nicolaverbeeck
 */
public class BitbucketTest {

    private Bitbucket mBitbucket;

    @Before
    public void setUp() throws Exception {
        mBitbucket = new Bitbucket(System.getenv("BITBUCKET_USER"), System.getenv("BITBUCKET_APP_TOKEN"));
    }

    @After
    public void tearDown() throws Exception {
        mBitbucket.shutdown();
    }

    @Test
    public void getApi() throws IOException {
        final Response<BitbucketUser> response = mBitbucket.getApi().getUser().execute();
        System.out.println(response.body());

        System.out.println(mBitbucket.getApi().getRepositories("icapps",
                PropertyCompare.eq("name", "androidtv_horizon_go")).execute().body());
    }

}