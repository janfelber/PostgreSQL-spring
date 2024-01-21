package com.example.app.module;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "comments", schema = "App")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comments")
    private int id;

    @Column(name = "user_id_user")
    private int userId;

    @Column(name = "recipe_id_recipe")
    private int recipeId;

    @NotEmpty
    @Size(min = 3, max = 255)
    @Column(name = "comment_text")
    private String commentText;

    @NotEmpty
    @Column(name = "comment_date")
    private Date create_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @PrePersist
    protected void onCreate() {
        create_date = new Date();
    }


}
