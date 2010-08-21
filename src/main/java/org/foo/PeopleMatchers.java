package org.foo;
import org.hamcrest.*;
final class PeopleMatchers
{
    private PeopleMatchers(){}

    public static Matcher<Person> hasLastName(final String lastName)
    {
        return new TypeSafeMatcher<Person>() {
            @Override
            public boolean matchesSafely(final Person toMatch) { return lastName.equalsIgnoreCase(toMatch.lastName()); }

            @Override
            public void describeTo(final Description desc) { desc.appendText("last name is ").appendValue(lastName); }
        };
    }

    public static Matcher<Person> isOlderThan(final Integer age)
    {
        return new TypeSafeMatcher<Person>() {
            @Override
            public boolean matchesSafely(final Person toMatch) { return toMatch.age() > age; }

            @Override
            public void describeTo(final Description desc) { desc.appendText("age is").appendValue(age); }
        };
    }

    public static Matcher<Person> salaryGreaterThan(final double salary)
    {
        return new TypeSafeMatcher<Person>() {
            @Override
            public boolean matchesSafely(final Person toMatch) { return toMatch.salary() > salary; }

            @Override
            public void describeTo(final Description desc) { desc.appendText("salary is").appendValue(salary); }
        };
    }
}
