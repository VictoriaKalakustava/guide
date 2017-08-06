package com.itransition.guide.entity;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.List;

@Indexed
@Entity
public class Instruction {
    private Long id;
    private String title;
    private User user;
    private List<Step> step;
    private List<Comment> comments;
    private List<Tag> tags;

    public Instruction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "instr_id", nullable = false, updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @IndexedEmbedded
    @OneToMany(mappedBy = "instruction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Step> getStep() {
        return step;
    }

    public void setStep(List<Step> step) {
        this.step = step;
    }

    @Field
    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @IndexedEmbedded
    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @IndexedEmbedded
    @OneToMany(mappedBy = "instruction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "instruction_tag",
            joinColumns = { @JoinColumn(name = "id_instruction") },
            inverseJoinColumns = { @JoinColumn(name = "id_tag") })
    @IndexedEmbedded
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
