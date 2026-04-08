package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s26-teams>
        assertEquals("Alexandru", Developer.getName());
    }
    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("alexandrugherghescu01", Developer.getGithubId());
    }

    @Test
public void getTeam_returns_team_with_correct_members() {
    Team t = Developer.getTeam();
    assertTrue(t.getMembers().contains("Alexandru"), "Team should contain Alexandru");
    assertTrue(t.getMembers().contains("Alex Yu Xuan"), "Team should contain Alex Yu Xuan");
    assertTrue(t.getMembers().contains("Raymond"), "Team should contain Raymond");
    assertTrue(t.getMembers().contains("BRIAN W"), "Team should contain BRIAN W");
    assertTrue(t.getMembers().contains("Kalyan"), "Team should contain Kalyan");
    assertTrue(t.getMembers().contains("Hrithik Chandra"), "Team should contain Hrithik Chandra");
}
@Test
public void getTeam_returns_team_with_correct_name() {
    Team t = Developer.getTeam();
    assertEquals("s26-03", t.getName());
}


    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
