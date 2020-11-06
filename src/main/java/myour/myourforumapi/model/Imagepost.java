package myour.myourforumapi.model;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Imagepost {
    private int id;
    private int postId;
    private String filePath;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "postId")
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "url")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String url) {
        this.filePath = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imagepost imagepost = (Imagepost) o;
        return id == imagepost.id &&
                postId == imagepost.postId &&
                Objects.equals(filePath, imagepost.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postId, filePath);
    }
}
