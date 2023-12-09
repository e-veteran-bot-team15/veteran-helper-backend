package com.hackathon.veteranhelper.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity(name = "MenuItemEntity")
@Table(
        name = "menu_items",
        uniqueConstraints = @UniqueConstraint(
                name = "menu_items_name_key",
                columnNames = "name"
        )
)
@Getter
@Setter
@ToString
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition="uuid")
    private UUID id;

    @Column(
            name = "message",
            nullable = false,
            columnDefinition = "varchar(300)"
    )
    @Length(min = 1, max = 300)
    @NotNull
    private String message;

    @Column(
            name = "name",
            columnDefinition = "varchar(300)"
    )
    @Length(min = 1, max = 300)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "parent_id",
            referencedColumnName = "id"
    )
    private MenuItemEntity parentId;

    @Column(
            name = "times_chosen",
            nullable = false,
            columnDefinition = "bigint"
    )
    @NotNull
    private Long timesChosen;

    @Version
    private Long version;

}
