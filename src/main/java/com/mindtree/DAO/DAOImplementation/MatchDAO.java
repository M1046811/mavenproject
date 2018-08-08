package com.mindtree.DAO.DAOImplementation;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface MatchDAO 
{
		void display() throws SQLException;
		void insertValues(Timestamp matchDate,int firstTeamScore,int secondTeamScore,String firstName,String secondName) throws SQLException;
		List check(String s)throws SQLException;
}
