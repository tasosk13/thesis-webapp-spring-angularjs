package gr.uoa.di.scan.thesis.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false,unique=true,length=50)
	private String title;

	@Column(nullable=false)
	private String body;
	
	@ManyToOne
	@JoinColumn(name="user_id",insertable=false,updatable=false,nullable=false)
	private User created_by;
	
	@OneToMany(mappedBy="posted_in_post",cascade=CascadeType.PERSIST)
	private List<Comment> comments = new ArrayList<Comment>();
	
	@ManyToMany
	@JoinTable(name="Post_has_Tag",
			joinColumns=@JoinColumn(name="post_id",referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="tag_id",referencedColumnName="id"))
	private List<Tag> tags = new ArrayList<Tag>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getCreated_by() {
		return created_by;
	}

	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
}
