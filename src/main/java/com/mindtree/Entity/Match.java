package com.mindtree.Entity;

import java.sql.SQLException;

import com.mindtree.DAO.DAOImplementation.ImplementationDEOTeam;
import com.mindtree.Exception.DateFormatException;
import com.mindtree.Exception.InvalidGoalException;
import com.mindtree.Exception.TeamDoesNotExistException;

public class Match {
	
		public int matchid;
		public String matchDate;
		public int firstTeamScore;
		public int secondTeamScore;
		public String firstTeam;
		public String secondTeam;
		public String opp;
		ImplementationDEOTeam it=new ImplementationDEOTeam();
		public Match() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Match(String matchDate, String opponent, int firstTeamScore, int secondTeamScore) {
			super();
			
			this.matchDate = matchDate;
			opp=opponent;
			this.firstTeamScore = firstTeamScore;
			this.secondTeamScore = secondTeamScore;
		}
		public int getMatchid() {
			return matchid;
		}
		public void setMatchid(int matchid) {
			this.matchid = matchid;
		}
		public String getMatchDate() {
			return matchDate;
		}
		public void setMatchDate(String matchDate) {
			this.matchDate = matchDate;
		}
		public int getFirstTeamScore() {
			return firstTeamScore;
		}
		public void setFirstTeamScore(int firstTeamScore) {
			this.firstTeamScore = firstTeamScore;
		}
		public int getSecondTeamScore() {
			return secondTeamScore;
		}
		public void setSecondTeamScore(int secondTeamScore) {
			this.secondTeamScore = secondTeamScore;
		}
		public String getFirstTeam() {
			return firstTeam;
		}
		public void setFirstTeam(String firstTeam) {
			this.firstTeam = firstTeam;
		}
		public String getSecondTeam() {
			return secondTeam;
		}
		public void setSecondTeam(String secondTeam) {
			this.secondTeam = secondTeam;
		}
		public void excep(String a)
		{
			String s1=a.substring(0,2);
			String s2=a.substring(3,5);
			String s3=a.substring(6,10);
			String s4=a.substring(11,13);
			String s5=a.substring(14,16);
			String s6=a.substring(17,19);
			try
			{
				if(Integer.parseInt(s1)<=31 && Integer.parseInt(s2)<=12 && Integer.parseInt(s3)<=9999 && Integer.parseInt(s4)<=24 && Integer.parseInt(s5)<60 &&Integer.parseInt(s6)<60)
				{
				}
				else
				{
					throw new DateFormatException();
				}
			}
			catch(DateFormatException e)
			{
				e.dateformat();
				System.exit(0);
			}
		}
		public void excep1(int t4) 
		{
			try
			{
				if(t4<0)
				{
					throw  new InvalidGoalException();
				}
			}
			catch(InvalidGoalException e1)
			{
				e1.invalidgoal();
				System.exit(0);
			}
		}
		public void excep2(String t1) throws SQLException 
		{
			try
			{
				if(it.checkt(t1)==0)
				{
					throw new TeamDoesNotExistException();
				}
			}
			catch(TeamDoesNotExistException e2)
			{
				e2.teamdnotexist();
				System.exit(0);
			}
		}
	}
