package com.mindtree.WebApp;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import com.google.gson.Gson;
import com.mindtree.DAO.DAOImplementation.ImplementationDEOTeam;
import com.mindtree.Entity.Match;
import com.mindtree.Exception.MyException;

public class FootballMatchManager 
{
	Scanner sc=new Scanner(System.in);
	ImplementationDEOTeam im=new ImplementationDEOTeam();
	Match m=new Match();
	public void matchd(String t1,String t2,String t3,String s4,String s5) throws MyException, ParseException
	{
		
		try {
			m.excep2(t1);
		} catch (SQLException e1) {
			
			throw new MyException("DB Exception Found"+e1);
		}
		try {
			m.excep2(t2);
		} catch (SQLException e1) {
			
			throw new MyException("DB Exception Found"+e1);
		}
		SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
		Date dt=format.parse(t3);
		Timestamp ts=new Timestamp(dt.getTime());
		//m.setMatchDate(ts); 
		int t4=Integer.parseInt(s4);
		int t5=Integer.parseInt(s5);
		try {
			im.insertValues(ts,t4,t5,t1,t2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List dtable(String s)
	{
		//String result="";
		List ll = new LinkedList();
		/*System.out.println("Team Name-="+s);
		System.out.println("MATCH_DATE     	 	   OPPONENT       	GOALS");*/
		Gson g=new Gson();
		String r="";
		try {
			ll=im.check(s);
			//r=g.toJson(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ll;
	}
	
}
