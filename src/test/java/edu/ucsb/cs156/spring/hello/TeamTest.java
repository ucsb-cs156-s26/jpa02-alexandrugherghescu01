package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("test-team", team.getName());
    }

    @Test
    public void getMembers_returns_empty_list_initially() {
        assertEquals(new ArrayList<String>(), team.getMembers());
    }

    @Test
    public void addMember_adds_member_to_list() {
        team.addMember("Alexandru");
        assertTrue(team.getMembers().contains("Alexandru"));
    }

    @Test
    public void setMembers_sets_members_correctly() {
        ArrayList<String> members = new ArrayList<>();
        members.add("Alexandru");
        members.add("Alex L");

        team.setMembers(members);

        assertEquals(members, team.getMembers());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_non_team_object() {
        assertFalse(team.equals("not a team"));
    }

    @Test
    public void equals_returns_true_for_same_name_and_members() {
        Team other = new Team("test-team");
        assertTrue(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_name() {
        Team other = new Team("different-team");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        team.addMember("Alexandru");
        Team other = new Team("test-team");
        assertFalse(team.equals(other));
    }

    @Test
    public void toString_returns_expected_string() {
        team.addMember("Alexandru");
        assertEquals("Team(name=test-team, members=[Alexandru])", team.toString());
    }

    @Test
    public void hashCode_returns_same_value_for_equal_objects() {
        Team other = new Team("test-team");
        assertEquals(team.hashCode(), other.hashCode());
    }

    @Test
    public void hashCode_matches_expected_formula() {
        int expected = team.getName().hashCode() | team.getMembers().hashCode();
        assertEquals(expected, team.hashCode());
    }

    @Test
    public void hashCode_changes_when_members_change() {
        Team other = new Team("test-team");
        other.addMember("Alexandru");
        assertNotEquals(team.hashCode(), other.hashCode());
    }
}