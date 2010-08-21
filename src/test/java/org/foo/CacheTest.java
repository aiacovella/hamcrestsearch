package org.foo;

import com.google.common.collect.Iterables;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.greaterThan;

public class CacheTest
{
    @Test
    public void testNameMatcher()
    {
        final Iterable<Person> results = PeopleCache.instance().queryForPeople(PeopleMatchers.hasLastName("Smith"));
        assertThat(Iterables.size(results), is(2));

        for (Person person : results) {
            assertThat(person.lastName(),is("Smith"));
        }
    }

    @Test
    public void testAgeMatcher()
    {
        final Iterable<Person> results = PeopleCache.instance().queryForPeople(PeopleMatchers.isOlderThan(35));
        assertThat(Iterables.size(results), is(3));

        for (final Person person : results) {
            assertThat(person.age(),greaterThan(35));
        }
    }

    @Test
    public void testAgeSalaryMatcher()
    {
        final Iterable<Person> results = PeopleCache.instance().queryForPeople(allOf(PeopleMatchers.isOlderThan(35), PeopleMatchers.salaryGreaterThan(80000)));
        assertThat(Iterables.size(results), is(2));

        for (final Person person : results) {
            assertThat(person.age(),greaterThan(35));
            assertThat(person.salary(),greaterThan(80000D));
        }
    }
}
