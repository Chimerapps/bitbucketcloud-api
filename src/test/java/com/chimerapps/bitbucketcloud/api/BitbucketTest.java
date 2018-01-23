package com.chimerapps.bitbucketcloud.api;

import com.chimerapps.bitbucketcloud.api.model.*;
import com.chimerapps.bitbucketcloud.api.model.filter.PropertyCompare;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author nicolaverbeeck
 */
public class BitbucketTest {

    private static final String USERNAME = System.getenv("BITBUCKET_USER");
    private static final String APP_TOKEN = System.getenv("BITBUCKET_APP_TOKEN");

    private Bitbucket mBitbucket;

    @Before
    public void setUp() throws Exception {
        mBitbucket = new Bitbucket(USERNAME, APP_TOKEN);
    }

    @After
    public void tearDown() throws Exception {
        mBitbucket.shutdown();
    }

    @Test
    public void getUserApi() throws IOException {
        final Response<BitbucketUser> response = mBitbucket.getApi().getUser().execute();

        assertNull(response.errorBody());

        final BitbucketUser bitbucketUser = response.body();
        assertNotNull(bitbucketUser);
        assertEquals(USERNAME, bitbucketUser.getUsername());
        System.out.println(bitbucketUser);
    }

    @Test
    public void getReposApi() throws IOException {
        final String repoSlug = "android_gradle_demo";
        final Response<PagedList<BitbucketRepository>> response = mBitbucket.getApi().getRepositories("icapps",
                PropertyCompare.eq("name", repoSlug)).execute();

        assertNull(response.errorBody());

        final PagedList<BitbucketRepository> pagedList = response.body();
        assertNotNull(pagedList);
        assertEquals(1, pagedList.getSize());
        assertEquals(repoSlug, pagedList.getValues().get(0).getSlug());
        System.out.println(pagedList);
    }

    @Test
    public void getCreatePRApi() throws IOException {
        final String repoSlug = "android_gradle_demo";
        final String title = "Title " + System.currentTimeMillis();
        final String description = "Description " + System.currentTimeMillis();

        final String branchNameSource = "feature/bitbucket-integration";
        final String branchNameDestination = "develop";

        final Destination source = new Destination(branchNameSource);
        final Destination destination = new Destination(branchNameDestination);

        final PullRequest pullRequest = new PullRequest(title, description, source, destination);

        final Response<PullRequest> response = mBitbucket.getApi()
                .postPullRequest("icapps", repoSlug, pullRequest)
                .execute();

        assertNull(response.errorBody());
        final PullRequest responsePullRequest = response.body();
        assertNotNull(responsePullRequest);
        assertEquals(title, responsePullRequest.getTitle());
        assertEquals(description, responsePullRequest.getDescription());
        assertEquals(branchNameSource, responsePullRequest.getSource().getBranch().getBranchName());
        assertEquals(branchNameDestination, responsePullRequest.getDestination().getBranch().getBranchName());
        System.out.println(responsePullRequest);
    }
}