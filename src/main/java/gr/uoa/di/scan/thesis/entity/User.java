package gr.uoa.di.scan.thesis.entity;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table( name="Users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=true)
	private String name;
	
	@Column(nullable=true)
	private String surname;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	@Column(nullable=false,unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@OneToMany(mappedBy="created_by",cascade=CascadeType.PERSIST)
	private List<Post> posts = new ArrayList<Post>();
	
	@OneToMany(mappedBy="posted_by",cascade=CascadeType.PERSIST)
	private List<Comment> comments = new ArrayList<Comment>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
