package com.mindtree.WebApp;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import com.mindtree.WebApp.*;

import com.google.gson.Gson;
import com.mindtree.Exception.MyException;

class add {

	public String ftname;
	public String stname;
	public String date;
	public String fgoals;
	public String sgoals;
	public String tname;

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getFtname() {
		return ftname;
	}

	public void setFtname(String ftname) {
		this.ftname = ftname;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFgoals() {
		return fgoals;
	}

	public void setFgoals(String fgoals) {
		this.fgoals = fgoals;
	}

	public String getSgoals() {
		return sgoals;
	}

	public void setSgoals(String sgoals) {
		this.sgoals = sgoals;
	}

}

@EnableAutoConfiguration
@RestController
@CrossOrigin
public class HomeController {
	FootballMatchManager fm = new FootballMatchManager();
	add a = new add();

	@RequestMapping(value = "/addplayer", method = RequestMethod.POST)
	public @ResponseBody String addPlayer(@RequestParam("ftname") String n, @RequestParam("stname") String Stname,
			@RequestParam("date") String date, @RequestParam("fgoals") String fgoal,
			@RequestParam("sgoals") String sgoals) throws MyException, ParseException {
		// a.setFtname(n);
		fm.matchd(n, Stname, date, fgoal, sgoals);
		return n;
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public @ResponseBody List displayDetails(@RequestParam("tname") String teamname) {
		/*System.out.println("teamname " + teamname);
		Gson g=new Gson();*/
		List result = new LinkedList();
		
		result = fm.dtable(teamname);
		//String r=g.toJson(result);
		return result;
	}

}
