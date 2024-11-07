package com.leave.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emp_leaves_table")
public class EmpLeaves {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "empId", referencedColumnName = "id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "leaveId", referencedColumnName = "id")
    private Leave leave;

    private String leaveDate;
}
