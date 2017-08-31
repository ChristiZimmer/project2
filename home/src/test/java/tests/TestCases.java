package tests;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Tournament;
import com.revature.data.TennisDAO;

public class TestCases {

	@Ignore
	@Test
	public void testTournamentListAll(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dao-beans.xml");
		TennisDAO dao = (TennisDAO) applicationContext.getBean(TennisDAO.class);
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
	
	/*
	@Ignore
	@Test
	public void testListAllRequests() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dao-beans.xml");
		TennisDAO dao = (TennisDAO) applicationContext.getBean(TennisDAO.class);
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
	*/
	
}
