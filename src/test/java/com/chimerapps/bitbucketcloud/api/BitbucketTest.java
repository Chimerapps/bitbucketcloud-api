package com.chimerapps.bitbucketcloud.api;

import com.chimerapps.bitbucketcloud.api.model.*;
import com.chimerapps.bitbucketcloud.api.model.filter.PropertyCompare;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author nicolaverbeeck
 */
public class BitbucketTest {

    private static final String USERNAME = System.getenv("BITBUCKET_USER");
    private static final String APP_TOKEN = System.getenv("BITBUCKET_APP_TOKEN");

    private static final String repoSlug = "android_gradle_demo";
    private static final String user = "icapps";

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
        final Response<PagedList<BitbucketRepository>> response = mBitbucket.getApi().getRepositories(user,
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
        final String title = "Title " + System.currentTimeMillis();
        final String description = "Description " + System.currentTimeMillis();

        final String branchNameSource = "feature/bitbucket-integration";
        final String branchNameDestination = "develop";

        final Destination source = new Destination(branchNameSource);
        final Destination destination = new Destination(branchNameDestination);

        final PullRequest pullRequest = new PullRequest(title, description, source, destination, null);

        final Response<PullRequest> response = mBitbucket.getApi()
                .postPullRequest(user, repoSlug, pullRequest)
                .execute();

        assertNull(response.errorBody());
        final PullRequest responsePullRequest = response.body();
        assertNotNull(responsePullRequest);
        assertEquals(title, responsePullRequest.getTitle());
        assertEquals(description, responsePullRequest.getDescription());
        assertEquals(branchNameSource, responsePullRequest.getSource().getBranch().getBranchName());
        assertEquals(branchNameDestination, responsePullRequest.getDestination().getBranch().getBranchName());
        assertTrue(responsePullRequest.isCloseSourceBranch());
        assertNull(responsePullRequest.getReviewers());
        System.out.println(responsePullRequest);
    }

    @Test
    public void getDefaultReviewersApi() throws IOException {
        final Response<PagedList<DefaultReviewer>> response = mBitbucket.getApi()
                .getDefaultReviewers(user, repoSlug)
                .execute();
        assertNull(response.errorBody());
        final PagedList<DefaultReviewer> defaultReviewers = response.body();
        assertNotNull(defaultReviewers);
        assertEquals(2, defaultReviewers.getSize());
        DefaultReviewer reviewer = defaultReviewers.getValues().get(0);
        assertNotNull(reviewer);
        assertEquals("user", reviewer.getType());
    }

    @Test
    public void getCreatePRWithDefaultReviewersApi() throws IOException {
        /*GET Default Reviewers*/
        final Response<PagedList<DefaultReviewer>> responseDefaultReviewers = mBitbucket.getApi()
                .getDefaultReviewers(user, repoSlug)
                .execute();
        assertNull(responseDefaultReviewers.errorBody());
        final PagedList<DefaultReviewer> defaultReviewers = responseDefaultReviewers.body();
        assertNotNull(defaultReviewers);
        assertEquals(2, defaultReviewers.getSize());
        DefaultReviewer reviewer = defaultReviewers.getValues().get(0);
        assertNotNull(reviewer);
        assertEquals("user", reviewer.getType());

        List<DefaultReviewer> filteredList = defaultReviewers.getValues()
                .stream()
                .filter(r -> !r.getUsername().equals(USERNAME))
                .collect(Collectors.toList());

        /*POST PR*/
        final String title = "Title " + System.currentTimeMillis();
        final String description = "Description " + System.currentTimeMillis();

        final String branchNameSource = "feature/bitbucket-integration";
        final String branchNameDestination = "develop";

        final Destination source = new Destination(branchNameSource);
        final Destination destination = new Destination(branchNameDestination);

        final PullRequest pullRequest = new PullRequest(title, description, source, destination, filteredList);

        final Response<PullRequest> responsePr = mBitbucket.getApi()
                .postPullRequest(user, repoSlug, pullRequest)
                .execute();

        assertNull(responsePr.errorBody());
        final PullRequest responsePullRequest = responsePr.body();
        assertNotNull(responsePullRequest);
        assertEquals(title, responsePullRequest.getTitle());
        assertEquals(description, responsePullRequest.getDescription());
        assertEquals(branchNameSource, responsePullRequest.getSource().getBranch().getBranchName());
        assertEquals(branchNameDestination, responsePullRequest.getDestination().getBranch().getBranchName());
        assertNotNull(responsePullRequest.getReviewers());
        assertEquals(1, responsePullRequest.getReviewers().size());

        DefaultReviewer defaultReviewer = responsePullRequest.getReviewers().get(0);
        assertEquals(reviewer.getUsername(), defaultReviewer.getUsername());
        assertEquals(reviewer.getDisplayName(), defaultReviewer.getDisplayName());
        assertEquals(reviewer.getType(), defaultReviewer.getType());
        assertEquals(reviewer.getUuid(), defaultReviewer.getUuid());
        System.out.println(responsePullRequest);
    }
}