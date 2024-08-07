package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class SampleTests {
	
	@Autowired
	private Restaurant restaurant;
	
	@Test
	public void test() {
		assertNotNull(restaurant);
		log.info(restaurant.toString());
		log.info(restaurant.getChef().toString());
	}
}

//zhem akdcushgrl 
//안녕하세요 귀요미윤채원입니다.
//기름칠이 뭔가요
//아주 괜찮죠
//손목나가요 조심하세요 ^_^
//36분
