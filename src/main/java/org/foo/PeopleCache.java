package org.foo;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.hamcrest.Matcher;
import java.util.*;

final class PeopleCache {
    private static final PeopleCache instance = new PeopleCache();
    private final List<Person> people = buildCache();

    private PeopleCache() {}

    public static PeopleCache instance() {return instance;}

    public Iterable<Person> queryForPeople(Matcher<Person> matcher){
        return (matcher == null ? people : Iterables.filter(people, new MatchingPredicate<Person>(matcher)));
    }

    private List<Person> buildCache() {
        final List<Person> people = new ArrayList<Person>();
        people.add(new Person("John", "Smith", 45, 150000));
        people.add(new Person("Bob", "Smith", 35, 75000));
        people.add(new Person("Bob", "Gordon", 37, 80000));
        people.add(new Person("Tom", "Barry", 54, 100000));
        return people;
    }

    class MatchingPredicate<Person> implements Predicate<Person>
    {
        private final Matcher<Person> matcher;

        MatchingPredicate(final Matcher<Person> matcher) { this.matcher = matcher;}

        public boolean apply(final Person input) { return matcher.matches(input); }
    }
}



