package home;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Tournament;
import com.revature.data.TennisDAO;

public class TestCases {

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
			System.out.println(t);
		}
	}
	
}
