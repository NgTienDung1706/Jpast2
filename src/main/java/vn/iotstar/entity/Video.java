package vn.iotstar.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Videos")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id
	 @Column(name="VideoId")
	 private String videoId;

	 @Column(name="Active")
	 private int active;

	 @Column(name="Description")
	 private String description;

	 @Column(name="Poster")
	 private String poster;

	 @Column(name="Title")
	 private String title;

	 @Column(name="Views")
	 private int views;
	 
	 public Video() {	
		super();
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@ManyToOne
	 @JoinColumn(name="CategoryId")
	 private Category category;
	 public Category getCategory() {
		 return this.category;


		 }

		 public void setCategory(Category category) {
		 this.category = category;
		 }
}
