package org.foo;

/**
 * Created by IntelliJ IDEA.
 * User: al
 * Date: Aug 4, 2010
 * Time: 5:28:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class PeopleCache {
    private static PeopleCache ourInstance = new PeopleCache();

    public static PeopleCache getInstance() {
        return ourInstance;
    }

    private PeopleCache() {
    }
}
