package home;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Coach;
import com.revature.beans.Player;
import com.revature.beans.Request;
import com.revature.beans.Tournament;
import com.revature.data.TennisDAO;

import oracle.sql.TIMESTAMP;

public class TestCases {
	
	@Ignore
	@Test
	public void testHi() {
		System.out.println("Hi Christie. We're Friends now, even though I can't spell your name, or just spell in general!");
	}

/*
	@Ignore
	@Test
	public void testTournamentListAll(){
		TennisDAO dao = setApplicationContext();
		List<Tournament> list = null;
		try{
			list = dao.findAllTournaments();
		}catch(Exception e){
			e.printStackTrace();
		}
		for(Tournament t : list){
			//System.out.println(t);
		}
	}

	@Ignore
	@Test
	public void testRequestCoach() {
		TennisDAO dao = setApplicationContext();
		Request request = new Request(
				2, 
				null, 
				null, 
				new Player(2, "Rafael Nadal", "Spain"), 
				new Coach(2, "Jim Beam Nadal"), 
				"PENDING", 
				"Forehand is LITTTT!!!!!");
		try {
			dao.requestCoach(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		testListAllRequests();
	}
	
	@Ignore
	@Test
	public void testListAllRequests() {
		TennisDAO dao = setApplicationContext();
		List<Request> list = null;
		try {
			list = dao.listAllRequests();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Request r: list) {
			System.out.println(r);
		}
	}
	
	@Ignore
	@Test
	public void testValidateCoachingRequest() {
		TennisDAO dao = setApplicationContext();
		Request request = new Request(1, 
				null, 
				Timestamp.valueOf("2017-08-30 01:00:00.0"), 
				new Player(1, "Roger Federer", "Switzerland"), 
				new Coach(1, "Patrick Rafter"), 
				"PENDING", 
				null);
		request.setStatus("ACCEPTED");
		try {
			dao.validateCoachingRequest(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		testListAllRequests();
	}
	
	@Ignore
	@Test
	public void testDeleteRequest() {
		TennisDAO dao = setApplicationContext();
		Request request = new Request(2, 
				Timestamp.valueOf("2017-08-31 14:34:31.177"), 
				Timestamp.valueOf("2017-08-31 14:34:21.38"),
				new Player(1, "Roger Federer", "Switzerland"),
				new Coach(1, "Patrick Rafter"),
				"PENDING",
				"backhand is bad");
		try {
			dao.deleteRequest(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		testListAllRequests();
	}
	
	public TennisDAO setApplicationContext() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dao-beans.xml");
		TennisDAO dao = (TennisDAO) applicationContext.getBean(TennisDAO.class);
		return dao;
	}
	*/
}
