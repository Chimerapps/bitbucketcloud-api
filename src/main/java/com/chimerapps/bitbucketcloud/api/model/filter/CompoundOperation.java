package com.chimerapps.bitbucketcloud.api.model.filter;

import org.jetbrains.annotations.NotNull;

/**
 * @author nicolaverbeeck
 */
public class CompoundOperation implements Query {

    public static final String OP_AND = "AND";
    public static final String OP_OR = "OR";

    public static CompoundOperation and(@NotNull final Query left, @NotNull final Query right) {
        return new CompoundOperation(left, OP_AND, right);
    }

    public static CompoundOperation or(@NotNull final Query left, @NotNull final Query right) {
        return new CompoundOperation(left, OP_OR, right);
    }

    @NotNull
    private final String mOperation;
    @NotNull
    private final Query mLeft;
    @NotNull
    private final Query mRight;

    public CompoundOperation(@NotNull final Query left, @NotNull final String operation, @NotNull final Query right) {
        mOperation = operation;
        mLeft = left;
        mRight = right;
    }

    @NotNull
    @Override
    public String toQueryExpression() {
        return '(' + mLeft.toQueryExpression() +
                ' ' +
                mOperation +
                ' ' +
                mRight.toQueryExpression() +
                ')';
    }

    @Override
    public String toString() {
        return toQueryExpression();
    }
}
