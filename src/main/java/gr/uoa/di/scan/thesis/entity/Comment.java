package gr.uoa.di.scan.thesis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Comments")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String body;
	
	@Column(nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_created;
	
	@ManyToOne
	@JoinColumn(name="user_id",insertable=false,updatable=false,nullable=false)
	private User posted_by;
	
	@ManyToOne
	@JoinColumn(name="post_id",insertable=false,updatable=false,nullable=true)
	private Post posted_in_post;
	
	@ManyToOne
	@JoinColumn(name="comment_id",insertable=false,updatable=false,nullable=true)
	private Comment posted_in_comment;
	
	@OneToMany(mappedBy="posted_in_comment",cascade=CascadeType.PERSIST)
	private List<Comment> comments = new ArrayList<Comment>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public User getPosted_by() {
		return posted_by;
	}

	public void setPosted_by(User posted_by) {
		this.posted_by = posted_by;
	}

	public Post getPosted_in_post() {
		return posted_in_post;
	}

	public void setPosted_in_post(Post posted_in_post) {
		this.posted_in_post = posted_in_post;
	}

	public Comment getPosted_in_comment() {
		return posted_in_comment;
	}

	public void setPosted_in_comment(Comment posted_in_comment) {
		this.posted_in_comment = posted_in_comment;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
