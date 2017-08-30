package home;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Coach;
import com.revature.beans.Player;
import com.revature.beans.Request;
import com.revature.beans.Tournament;
import com.revature.controllers.PlayerCoachController;
import com.revature.data.TennisDAO;

//@ContextConfiguration(classes = {TennisDAO.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@TransactionConfiguration
//@Transactional
public class TestCases /*extends AbstractTransactionalJUnit4SpringContextTests */{
	
	@Test
	public void trueTest() {
		System.out.println("HelloWorld");
	}
	/*
	@Autowired
	private TennisDAO tennisDAO;
	
	//private MockMvc mockMvc;
	
	@Ignore
	public void trueIsTrue() {
		boolean expected = true;
		assertEquals(expected, true);
	}

	@Ignore
	@Transactional
	@Rollback(true)
	public void getRequest() {
		
		
		List<Request> requests = tennisDAO.listAllRequests();
		for (Request r: requests) {
			System.out.println(r);
		}
	}
	*/
	
}
