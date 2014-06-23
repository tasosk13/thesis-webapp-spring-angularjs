package gr.uoa.di.scan.thesis.dto;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.*;

@SuppressWarnings("restriction")
@XmlRootElement
public class UserDTO {

	private Long id;

	private String name;
	
	private String surname;
	
	private String email;
	
	private String username;
	
	private String password;
	
	private Set<PostDTO> posts = new HashSet<PostDTO>();
	
	private Set<CommentDTO> comments = new HashSet<CommentDTO>();

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

	public Set<PostDTO> getPosts() {
		return posts;
	}

	public void setPosts(Set<PostDTO> posts) {
		this.posts = posts;
	}

	public Set<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDTO> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
