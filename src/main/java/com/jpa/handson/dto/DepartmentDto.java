package com.jpa.handson.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "department")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DepartmentDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Employee> employeeList = new ArrayList();

//    public void addEmployee(Employee employee) {
//        employeeList.add(employee);
//        employee.setDepartment(this);
//    }
//
//    public void removeEmployee(Employee employee) {
//        employeeList.remove(employee);
//        employee.setDepartment(null);
//    }

}
