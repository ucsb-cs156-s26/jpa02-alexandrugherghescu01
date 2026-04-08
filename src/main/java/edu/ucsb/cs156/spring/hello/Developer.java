package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        

        return "Alexandru";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        // TODO: Change this to your github id
        return "alexandrugherghescu01";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
    Team team = new Team("s26-03");
    team.addMember("Alexandru");
    team.addMember("Alex Yu Xuan");
    team.addMember("Raymond");
    team.addMember("Brian W");
    team.addMember("Kalyan");
    team.addMember("Hrithik Chandra");
    return team;

}
}
