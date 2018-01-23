package com.chimerapps.bitbucketcloud.api.model.filter;

import org.jetbrains.annotations.NotNull;

/**
 * @author nicolaverbeeck
 */
public interface Query {

    @NotNull
    String toQueryExpression();

}
