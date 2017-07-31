package com.itransition.guide.entity;

import com.itransition.guide.entity.enums.ElementType;

import javax.persistence.*;

@Entity
public class Element {
    Long id;
    Long stepId;
    String value;
    ElementType type;
    Step step;

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

    @Column(name= "id_step", nullable = false, insertable = true, updatable = false)
    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    @Column(name= "step_value", nullable = false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "step_type", nullable = false, updatable = false)
    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name="step_id")
    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }
}
