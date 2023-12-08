package com.hackathon.veteranhelper.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity(name = "CustomerEntity")
@Table(
        name = "customers",
        uniqueConstraints = @UniqueConstraint(
                name = "customers_email_key",
                columnNames = "email"
        )
)
@Getter
@Setter
@ToString
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition="uuid")
    private UUID id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    @Length(min = 1, max = 100)
    @NotNull
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    @Length(min = 1, max = 100)
    @NotNull
    private String lastName;

    @Column(
            name = "surname",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    @Length(min = 1, max = 100)
    @NotNull
    private String surname;

    @Column(
            name = "phone_number",
            columnDefinition = "varchar(15)"
    )
    @Length(min = 4, max = 15)
    private String phoneNumber;

    @Column(
            name = "age",
            columnDefinition = "INTEGER",
            nullable = false
    )
    @NotNull
    private Integer age;

    @Column(
            name = "region",
            columnDefinition = "varchar(300)",
            nullable = false
    )
    @NotNull
    @Length(min = 1, max = 300)
    private String region;

    @Column(
            name = "customer_type",
            nullable = false
    )
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private CustomerType customerType;

    @Column(
            name = "chat_id",
            nullable = false,
            columnDefinition = "varchar(300)"
    )
    @NotNull
    @Length(min = 1, max = 300)
    private String chatId;

    @Column(
            name = "times_entered_menu",
            nullable = false,
            columnDefinition = "bigint"
    )
    @NotNull
    private Long timesEnteredMenu;

    @Column(
            name = "times_found_typical_response",
            nullable = false,
            columnDefinition = "bigint"
    )
    @NotNull
    private Long timesFoundTypicalResponse;

    @Column(
            name = "gender",
            nullable = false,
            columnDefinition = "varchar(300)"
    )
    @NotNull
    @Length(min = 1, max = 300)
    private String gender;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "varchar(320)"
    )
    @Length(min = 3, max = 320)
    @NotNull
    private String email;

    @Column(
            name = "education",
            nullable = false,
            columnDefinition = "varchar(320)"
    )
    @Length(min = 3, max = 320)
    @NotNull
    private String education;
}
