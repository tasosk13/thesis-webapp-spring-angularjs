package gr.uoa.di.scan.thesis.test;


import gr.uoa.di.scan.thesis.entity.User;
import gr.uoa.di.scan.thesis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

@ContextConfiguration(locations={"classpath:app-context.xml"})
@TransactionConfiguration(defaultRollback = true)
public class UserServiceTester extends AbstractTestNGSpringContextTests {
	
	@Autowired
	UserService userService;
	
	User testUser;
	
	@BeforeClass
	public void beforeClass() {
		testUser = new User();
		testUser.setEmail("test@test.gr");
		testUser.setPassword("test");
		testUser.setUsername("tester1");
	}
	
	@Test(priority=1)
	@Transactional
	public void testCreateUser() {		
		testUser = userService.create(testUser);
		
		Assert.assertNotNull(testUser.getId());
	}
	
	@Test(priority=2)
	@Transactional
	public void testFindUser() {
		User foundUser = userService.findByID(testUser.getId());
		
		Assert.assertEquals(foundUser.getId(), testUser.getId());
	}
	
	@Test(priority=3)
	@Transactional
	public void testUpdateUser() {
		
		testUser = userService.findByID(testUser.getId());
		testUser.setUsername("tester2");
		testUser = userService.update(testUser);
		
		Assert.assertEquals(testUser.getUsername(), "tester2");
	}
	
	@Test(priority=4)
	@Transactional
	public void testDeleteUser() {
		User deletedUser = userService.delete(testUser.getId());
		
		Assert.assertEquals(testUser.getEmail(), deletedUser.getEmail()); //TODO change with equals
	}
}
