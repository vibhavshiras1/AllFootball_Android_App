package com.example.football_app;

public class UserProfile {
    public String userName;
    public String userEmail;
    public String userClub;
    public String userTeam;
    public String userPlayer;

    public UserProfile(){
    }

    public UserProfile(String userName, String userEmail, String userClub, String userTeam, String userPlayer) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userClub = userClub;
        this.userTeam = userTeam;
        this.userPlayer = userPlayer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserClub() {
        return userClub;
    }

    public void setUserClub(String userClub) {
        this.userClub = userClub;
    }

    public String getUserTeam() {
        return userTeam;
    }

    public void setUserTeam(String userTeam) {
        this.userTeam = userTeam;
    }

    public String getUserPlayer() {
        return userPlayer;
    }

    public void setUserPlayer(String userPlayer) {
        this.userPlayer = userPlayer;
    }
}
