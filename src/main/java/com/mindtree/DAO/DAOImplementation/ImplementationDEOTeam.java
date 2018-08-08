package com.mindtree.DAO.DAOImplementation;
import java.util.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.*;

import com.google.gson.Gson;
import com.mindtree.Entity.Match;
import com.mindtree.Entity.Team;
import com.mindtree.utility.DbUtility;

public class ImplementationDEOTeam implements MatchDAO
{
	Connection con=DbUtility.createConnection();
	public void display() throws SQLException
	{
		Statement statement=con.createStatement();
		ResultSet res=statement.executeQuery("select * from teams");
		while(res.next())
		{
			System.out.println(res.getString("team_name")+"        "+res.getString("team_city"));
		}
	}
	
	public void insertValues(Timestamp matchDate, int firstTeamScore, int secondTeamScore, String firstTeam,
			String secondTeam) throws SQLException 
	{
		Statement statement=con.createStatement();
		statement.executeUpdate("insert into matches(match_date,first_team_goals,second_team_goals,first_team_name,second_team_name) values ('"+matchDate+"','"+firstTeamScore+"','"+secondTeamScore+"','"+firstTeam+"','"+secondTeam+"')");
	}
	public List check(String tname) throws SQLException 
	{
		Statement statement=con.createStatement();
		LinkedList ll = new LinkedList();
		
		
		  

		  //Assuming you have a user object
		  

		  //ll.add(user);
	
		PreparedStatement st=con.prepareStatement("select MATCH_DATE,SECOND_TEAM_NAME as opponent,FIRST_TEAM_GOALS as team1,SECOND_TEAM_GOALS as team2 from MATCHES where FIRST_TEAM_NAME=? union select MATCH_DATE,FIRST_TEAM_NAME as opponent,SECOND_TEAM_GOALS as team1,FIRST_TEAM_GOALS as team2 from MATCHES where SECOND_TEAM_NAME=? order by (team1-team2) desc , MATCH_DATE");
		st.setString(1, tname);
		st.setString(2, tname);
		ResultSet res=st.executeQuery();
		while(res.next())
		{
			String d=res.getTimestamp(1).toString();
			//String temp=d.substring(8,10)+"-"+d.substring(6,7)+"-"+d.substring(0,4)+"-"+d.substring(11,16);
			Match m=new Match(d,res.getString(2),res.getInt(3),res.getInt(4));
			ll.add(m);
		}
		/*Gson g=new Gson();
		String result=g.toJson(ll);*/
		return ll;
	}

	public int checkt(String t1) throws SQLException 
	{
		Statement statement=con.createStatement();
		ResultSet res=statement.executeQuery("select * from teams where team_name='"+t1+"'");
		if(res.next())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
