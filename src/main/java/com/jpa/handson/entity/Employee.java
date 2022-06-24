package com.jpa.handson.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jpa.handson.validator.FieldsValueMatch;
import lombok.*;

import javax.persistence.*;

@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "firstName",
                fieldMatch = "lastName",
                message = "firstName and LastName should not Match!"
        )
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "employee")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private Integer salary;

//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Department department;
}
