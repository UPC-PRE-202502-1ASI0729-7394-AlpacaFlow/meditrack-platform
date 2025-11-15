package com.alpacaflow.meditrackplatform.relatives.domain.model.aggregates;

import com.alpacaflow.meditrackplatform.relatives.domain.model.entities.SeniorCitizen;
import com.alpacaflow.meditrackplatform.relatives.domain.model.valueobjects.PlanType;
import com.alpacaflow.meditrackplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Relative extends AuditableAbstractAggregateRoot<Relative> {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlanType plan = PlanType.FREEMIUM;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "senior_citizen_id", nullable = false)
    private SeniorCitizen seniorCitizen;

    protected Relative() {
        super();
    }

    public Relative(
        String firstName,
        String lastName,
        String phoneNumber,
        SeniorCitizen seniorCitizen
    ) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.seniorCitizen = seniorCitizen;
    }
}
