package com.itransition.guide.entity;

import com.itransition.guide.entity.enums.ElementType;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;

@Indexed
@Entity
public class Element {
    private Long id;
    private String value;
    private ElementType type;
    private Long position;
    private Step step;

    public Element() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_element", nullable = false, insertable = true, updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "position_element", nullable = false, insertable = true, updatable = true)
    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    @Field
    @Column(name= "element_value", nullable = false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "element_type", nullable = false, updatable = false)
    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    @ContainedIn
    @ManyToOne
    @JoinColumn(name="step_id")
    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }
}
