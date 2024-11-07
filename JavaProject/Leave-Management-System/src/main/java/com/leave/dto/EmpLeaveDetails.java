package com.leave.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpLeaveDetails {
    private int empId;
    private String empName;
    private int totalLeaves=10;
    private int leaveTaken;
    private int leaveBalance;
    private Map<String,Integer> leaveType;
}
