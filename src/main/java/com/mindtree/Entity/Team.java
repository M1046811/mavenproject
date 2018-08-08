package com.mindtree.Entity;

public class Team {
		public String teamId;
		public String teamName;
		public Team() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Team(String teamId, String teamName) {
			super();
			this.teamId = teamId;
			this.teamName = teamName;
		}
		public String getTeamId() {
			return teamId;
		}
		public void setTeamId(String teamId) {
			this.teamId = teamId;
		}
		public String getTeamName() {
			return teamName;
		}
		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}
		
	}


