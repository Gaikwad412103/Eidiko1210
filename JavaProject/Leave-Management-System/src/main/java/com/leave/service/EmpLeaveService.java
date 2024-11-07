package com.leave.service;

import com.leave.dto.EmpLeaveDetails;
import com.leave.entity.Leave;

public interface EmpLeaveService {

    public EmpLeaveDetails getEmpLeaveDetails(int id);
}
