package com.stadiumbooking.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.stadiumbooking.connection.ConnectionUtill;
import com.stadiumbooking.dao.MatchDao;
import com.stadiumbooking.module.Match;

public class MatchDaoImpl implements MatchDao {

	@Override
	public void insertMatchDetalis(Match match) throws ClassNotFoundException, SQLException {
		
		System.out.println(match.getMatch_date());
		ConnectionUtill conUtil=new ConnectionUtill();
		Connection con=conUtil.getDBConnect();
		
		String query="insert into match_info(sportsId,stadium_name, location,match_date,teamA,teamB,teamAlogo, teamBlogo, totalseats, availableSeats, firstClass_Seats_price, secondClass_seats_price) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt=con.prepareStatement(query);
//		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy ");  
//		String strDate = dateFormat.format(match.getMatch_date());  
//		String date=dateFormat.format(match.getMatch_date());
		
//		String Date = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(match.getMatch_date());
	
//		String Date = String.format("%1$tY %1$tI:%1$tM %1$Tp", match.getMatch_date());

//		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
//		String Date=df.format(match.getMatch_date());
//		System.out.println(Date);
		
	    stmt.setInt(1, match.getSportsId());
		stmt.setString(2, match.getStadium_name());
		stmt.setString(3, match.getLocation());
		stmt.setDate(4, java.sql.Date.valueOf(match.getMatch_date()));
		stmt.setString(5, match.getTeamA());
		stmt.setString(6, match.getTeamB());
		stmt.setString(7, match.getTeamAlogo());
		stmt.setString(8, match.getTeamBlogo());
		stmt.setInt(9, match.getTotalseats());
		stmt.setInt(10, match.getAvailableSeats());
		stmt.setInt(11, match.getFirstClass_Seats_price());
		stmt.setInt(12, match.getSecondClass_seats_price());
	
		System.out.println(stmt.executeUpdate()+" row inserted");
		System.out.println("Value Inserted Successfully");
		
	}

	@Override
	public ResultSet getAllMatchDetalis() throws ClassNotFoundException, SQLException {
		ConnectionUtill conUtil=new ConnectionUtill();
		Connection con=conUtil.getDBConnect();
		Statement stmt=con.createStatement();
		String query="Select * from match_info";
		
		ResultSet rs=stmt.executeQuery(query);

		
		return rs;
	}

	@Override
	public ResultSet getDate() throws ClassNotFoundException, SQLException {
		ConnectionUtill conUtil=new ConnectionUtill();
		Connection con=conUtil.getDBConnect();
		Statement stmt=con.createStatement();
         String query="select to_char(sysdate,'yyyy-mm-dd')  as today  from dual";
		
		ResultSet rs=stmt.executeQuery(query);
		return rs;
		
	}

}
