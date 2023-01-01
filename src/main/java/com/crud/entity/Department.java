package com.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok annotations are used here to create getters, setters and others.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;

    // for auth purpose we use Validator below annotations are related to that further it will connect in controller.
    @NotBlank(message = "Please add DepartmentName")
    // @Length(max = 15, min = 3)
    // @Email @Positive @Negative @PositiveOrZero @NegativeOrZero --check date - @Ffuture @FutureOrPresent @Past
    // we are getting these annotations from validation dependency for validation purpose.
    private String departmentName;
    private String departmentAddress;
    private String departmentCodeNo;

}
