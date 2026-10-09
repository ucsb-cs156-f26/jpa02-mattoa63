package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_boolean() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        Team t3 = new Team();
        t3.setName("foo");
        t3.addMember("foo");
        Team t4 = new Team();
        t4.setName("bar");
        t4.addMember("foo");
        assertEquals(true, t1.equals(t1));
        assertEquals(false, t1.equals(3.14159265));
        assertEquals(true, t1.equals(t2));
        assertEquals(false, t1.equals(t3));
        assertEquals(false, t1.equals(t4));
    }

    @Test
    public void hashCode_returns_correct_hash() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        int result = t1.hashCode();
        int expectedResult = 130294;
        assertEquals(t1.hashCode(), t2.hashCode());
        assertEquals(expectedResult, result);
    }
}
