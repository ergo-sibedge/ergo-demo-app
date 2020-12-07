package com.sibedge.ergo.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

/**
 * Converts pattern
 * {@literal *}
 */
@UtilityClass
public class WildcardConverter {

    public static final String[] STANDARD_SIMPLE_WILDCARD = new String[] { "*", "?", "%", "_" };
    public static final String[] STANDARD_SQL_LIKE_WILDCARD = new String[] { "%", "_", "\\%", "\\_" };

    public String asSqlLikeWildcard(String text) {
        return StringUtils.replaceEach(text, STANDARD_SIMPLE_WILDCARD, STANDARD_SQL_LIKE_WILDCARD);
    }

}
