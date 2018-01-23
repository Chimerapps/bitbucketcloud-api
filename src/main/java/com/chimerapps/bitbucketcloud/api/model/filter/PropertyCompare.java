package com.chimerapps.bitbucketcloud.api.model.filter;

import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * @author nicolaverbeeck
 */
public class PropertyCompare implements Query {

    public static final String OP_EQ = "=";
    public static final String OP_NEQ = "!=";
    public static final String OP_CONTAINS_INSENTIIVE = "~";
    public static final String OP_NOT_CONTAINS_INSENTIIVE = "!~";
    public static final String OP_GT = ">";
    public static final String OP_GE = ">=";
    public static final String OP_LT = "<";
    public static final String OP_LE = "<=";

    public static PropertyCompare eq(@NotNull final String property, @NotNull final Object value) {
        return new PropertyCompare(property, value, OP_EQ);
    }

    public static PropertyCompare neq(@NotNull final String property, @NotNull final Object value) {
        return new PropertyCompare(property, value, OP_NEQ);
    }

    public static PropertyCompare contains(@NotNull final String property, @NotNull final Object value) {
        return new PropertyCompare(property, value, OP_CONTAINS_INSENTIIVE);
    }

    public static PropertyCompare doesntContain(@NotNull final String property, @NotNull final Object value) {
        return new PropertyCompare(property, value, OP_NOT_CONTAINS_INSENTIIVE);
    }

    public static PropertyCompare greaterThan(@NotNull final String property, @NotNull final Object value) {
        return new PropertyCompare(property, value, OP_GT);
    }

    public static PropertyCompare greatherThanOrEqual(@NotNull final String property, @NotNull final Object value) {
        return new PropertyCompare(property, value, OP_GE);
    }

    public static PropertyCompare lessThan(@NotNull final String property, @NotNull final Object value) {
        return new PropertyCompare(property, value, OP_LT);
    }

    public static PropertyCompare lessThanOrEqual(@NotNull final String property, @NotNull final Object value) {
        return new PropertyCompare(property, value, OP_LE);
    }

    @NotNull
    private final String mProperty;
    @NotNull
    private final Object mValue;
    @NotNull
    private final String mOperation;

    public PropertyCompare(@NotNull final String property,
                           @NotNull final Object value,
                           @NotNull final String operation) {

        mProperty = property;
        mValue = value;
        mOperation = operation;
    }

    @NotNull
    @Override
    public String toQueryExpression() {
        return mProperty + mOperation + encodeValue(mValue);
    }

    @NotNull
    private static String encodeValue(@NotNull final Object object) {
        if (object instanceof String) {
            return '"' + object.toString() + '"';
        } else if (object instanceof Date) {
            return DateTimeFormatter.ISO_DATE_TIME.format(((Date) object).toInstant());
        } else if (object instanceof Calendar) {
            return DateTimeFormatter.ISO_DATE_TIME.format(((Calendar) object).toInstant());
        } else if (object instanceof TemporalAccessor) {
            return DateTimeFormatter.ISO_DATE_TIME.format((TemporalAccessor) object);
        }
        return object.toString();
    }

    @Override
    public String toString() {
        return toQueryExpression();
    }
}
