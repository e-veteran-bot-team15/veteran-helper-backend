package com.hackathon.veteranhelper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity(name = "HelperRegistrationRequestEntity")
@Table(
        name = "helper_registration_requests",
        uniqueConstraints = @UniqueConstraint(
                name = "helper_registration_requests_email_key",
                columnNames = "email"
        )
)
@Getter
@Setter
@ToString
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class HelperRegistrationRequestEntity {

    @Id
    @Column(name = "chat_id", nullable = false, columnDefinition = "bigint")
    private Long chatId;

    @Length(min = 10, max = 10)
    @Column(
            name = "rnocpp",
            columnDefinition = "varchar(10)"
    )

    private String rnocpp;

    @Length(min = 3, max = 200)
    @Column(
            name = "full_name",
            columnDefinition = "varchar(200)"
    )
    private String fullName;

    @Column(
            name = "birth_date"
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime birthDate;

    @Length(min = 1, max = 200)
    @Column(
            name = "gender",
            columnDefinition = "varchar(200)"
    )
    private String gender;

    @Length(min = 2, max = 2)
    @Column(
            name = "passport_series",
            columnDefinition = "varchar(2)"
    )
    private String passportSeries;

    @Column(
            name = "passport_number",
            columnDefinition = "INTEGER"
    )
    private Integer passportNumber;

    @Column(
            name = "passport_date_of_giveaway"
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime passportDateOfGiveaway;

    @Length(min = 1, max = 200)
    @Column(
            name = "passport_granted_from",
            columnDefinition = "varchar(200)"
    )
    private String passportGrantedFrom;

    @Length(min = 1, max = 200)
    @Column(
            name = "declared_place_of_residence",
            columnDefinition = "varchar(200)"
    )
    private String declaredPlaceOfResidence;

    @Column(
            name = "phone_number",
            columnDefinition = "varchar(15)"
    )
    @Length(min = 4, max = 15)
    private String phoneNumber;

    @Column(
            name = "email",
            columnDefinition = "varchar(320)"
    )
    @Length(min = 3, max = 320)
    private String email;

    @Length(min = 1, max = 200)
    @Column(
            name = "actual_place_of_residence",
            columnDefinition = "varchar(200)"
    )
    private String actualPlaceOfResidence;

    @Length(min = 1, max = 200)
    @Column(
            name = "degree",
            columnDefinition = "varchar(200)"
    )
    private String degree;

    @Length(min = 1, max = 200)
    @Column(
            name = "branch_of_knowledge",
            columnDefinition = "varchar(200)"
    )
    private String branchOfKnowledge;

    @Length(min = 1, max = 200)
    @Column(
            name = "specialty",
            columnDefinition = "varchar(200)"
    )
    private String specialty;

    @Length(min = 1, max = 200)
    @Column(
            name = "employment_region",
            columnDefinition = "varchar(200)"
    )
    private String employmentRegion;

    @Length(min = 1, max = 200)
    @Column(
            name = "priority_terromads_for_employment",
            columnDefinition = "varchar(200)"
    )
    private String priorityTerromadsForEmployment;

    @Column(
            name = "creation_timestamp",
            nullable = false
    )
    @JsonIgnore
    private LocalDateTime creationTimestamp;

    @Version
    private Long version;

    public void copyAllNonNullFields(HelperRegistrationRequestEntity e) {
        if (e.getRnocpp() != null) {
            this.setRnocpp(e.getRnocpp());
        }
        if (e.getBirthDate() != null) {
            this.setBirthDate(e.getBirthDate());
        }
        if (e.getFullName() != null) {
            this.setFullName(e.getFullName());
        }
        if (e.getGender() != null) {
            this.setGender(e.getGender());
        }
        if (e.getPassportSeries() != null) {
            this.setPassportSeries(e.getPassportSeries());
        }
        if (e.getPassportNumber() != null) {
            this.setPassportNumber(e.getPassportNumber());
        }
        if (e.getPassportDateOfGiveaway() != null) {
            this.setPassportDateOfGiveaway(e.getPassportDateOfGiveaway());
        }
        if (e.getPassportGrantedFrom() != null) {
            this.setPassportGrantedFrom(e.getPassportGrantedFrom());
        }
        if (e.getDeclaredPlaceOfResidence() != null) {
            this.setDeclaredPlaceOfResidence(e.getDeclaredPlaceOfResidence());
        }
        if (e.getPhoneNumber() != null) {
            this.setPhoneNumber(e.getPhoneNumber());
        }
        if (e.getEmail() != null) {
            this.setEmail(e.getEmail());
        }
        if (e.getActualPlaceOfResidence() != null) {
            this.setActualPlaceOfResidence(e.getActualPlaceOfResidence());
        }
        if (e.getDegree() != null) {
            this.setDegree(e.getDegree());
        }
        if (e.getBranchOfKnowledge() != null) {
            this.setBranchOfKnowledge(e.getBranchOfKnowledge());
        }
        if (e.getSpecialty() != null) {
            this.setSpecialty(e.getSpecialty());
        }
        if (e.getEmploymentRegion() != null) {
            this.setEmploymentRegion(e.getEmploymentRegion());
        }
        if (e.getPriorityTerromadsForEmployment() != null) {
            this.setPriorityTerromadsForEmployment(e.getPriorityTerromadsForEmployment());
        }
    }

    public boolean allFieldNotNull() {
        return getRnocpp() != null &&
                getBirthDate() != null &&
                getFullName() != null &&
                getGender() != null &&
                getPassportSeries() != null &&
                getPassportNumber() != null &&
                getPassportDateOfGiveaway() != null &&
                getPassportGrantedFrom() != null &&
                getDeclaredPlaceOfResidence() != null &&
                getPhoneNumber() != null &&
                getEmail() != null &&
                getActualPlaceOfResidence() != null &&
                getDegree() != null &&
                getBranchOfKnowledge() != null &&
                getSpecialty() != null &&
                getEmploymentRegion() != null &&
                getPriorityTerromadsForEmployment() != null;
    }

}
