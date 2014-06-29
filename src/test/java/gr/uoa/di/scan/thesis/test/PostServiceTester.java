package gr.uoa.di.scan.thesis.test;


import gr.uoa.di.scan.thesis.dto.PostDTO;
import gr.uoa.di.scan.thesis.dto.UserDTO;
import gr.uoa.di.scan.thesis.exception.EntityNotFoundException;
import gr.uoa.di.scan.thesis.service.PostService;
import gr.uoa.di.scan.thesis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@ContextConfiguration(locations={"classpath:app-context.xml"})
@TransactionConfiguration(defaultRollback = true)
public class PostServiceTester extends AbstractTestNGSpringContextTests {

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;

	private PostDTO testPost;
	private UserDTO testUser;

	@BeforeClass
	public void beforeClass() {
		testPost = new PostDTO();
		testPost.setTitle("Test title");
		testPost.setBody("Test body");

		testUser = new UserDTO();
		testUser.setEmail("test@test.gr");
		testUser.setPassword("test");
		testUser.setUsername("tester1");
	}

	@Test(priority=1, expectedExceptions = EntityNotFoundException.class)
	@Transactional
	public void testCreatePostWithNonExistentUser() throws EntityNotFoundException {
		testUser.setId((long) 9999);
		testPost.setCreatedBy(testUser);
		postService.create(testPost);
	}

	@Test(priority=2)
	@Transactional
	public void testCreatePost() throws EntityNotFoundException {
		testUser = userService.create(testUser);
		Assert.assertNotNull(testUser.getId());

		testPost.setCreatedBy(testUser);
		testPost = postService.create(testPost);

		Assert.assertNotNull(testPost.getId());
	}

	@Test(priority=3)
	@Transactional
	public void testFindPost() {
		PostDTO foundPost = postService.findByID(testPost.getId());
		Assert.assertEquals(foundPost.getId(), testPost.getId());
	}

	@Test(priority=4)
	@Transactional
	public void testUpdatePost() throws EntityNotFoundException {

		testPost = postService.findByID(testPost.getId());
		testPost.setBody("Test updated body");
		testPost = postService.update(testPost);

		Assert.assertEquals(testPost.getBody(), "Test updated body");
	}

	@Test(priority=5, expectedExceptions = EntityNotFoundException.class)
	@Transactional
	public void testUpdateNonExistentPost() throws EntityNotFoundException {

		PostDTO nonExistentPost = new PostDTO();
		nonExistentPost.setId((long) 9999);
		nonExistentPost.setTitle("Mpla");
		nonExistentPost.setBody("Mpla mpla");

		nonExistentPost = postService.update(nonExistentPost);
	}

	@Test(priority=6)
	@Transactional
	public void testDeletePost() throws EntityNotFoundException {
		
		Assert.assertNotNull(postService.findByID(testPost.getId()));
		postService.delete(testPost.getId());
		Assert.assertNull(postService.findByID(testPost.getId()));
	}

	@Test(priority=7, expectedExceptions = EntityNotFoundException.class)
	@Transactional
	public void testDeleteNonExistentPost() throws EntityNotFoundException {
		postService.delete(testPost.getId());
	}

//	@AfterClass
//	public void afterClass() {
//		if (testPost.getId() != null)
//			postService.delete(testPost.getId());
//		if (testUser.getId() != null)
//			userService.delete(testUser.getId());
//	}

}
