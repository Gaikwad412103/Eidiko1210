package com.leave.service.implementation;

import com.leave.dto.EmpLeaveDetails;
import com.leave.entity.EmpLeaves;
import com.leave.entity.Employee;
import com.leave.entity.Leave;
import com.leave.repository.EmpLeavesRepository;
import com.leave.repository.EmployeeRepository;
import com.leave.repository.LeaveRepository;
import com.leave.service.EmpLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpLeaveServiceImp implements EmpLeaveService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmpLeavesRepository empLeavesRepository;
    @Autowired
    LeaveRepository leaveRepository;

    @Override
    public EmpLeaveDetails getEmpLeaveDetails(int id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        List<Leave> leaveList=leaveRepository.findAll();
        List<EmpLeaves> empLeavesList=empLeavesRepository.findAll();

        EmpLeaveDetails details=new EmpLeaveDetails();
        details.setEmpId(id);
        details.setEmpName(employee.getEmpName());
        int leaveTaken=0;
        Map<String,Integer> leaveTypes=new LinkedHashMap<>();
        for(EmpLeaves empLeaves:empLeavesList){

            if(empLeaves.getEmployee().getId()==id){
                leaveTaken++;
                if(leaveTypes.containsKey(empLeaves.getLeave().getLeaveType())){
                    int count=leaveTypes.get(empLeaves.getLeave().getLeaveType())+1;
                    leaveTypes.put(empLeaves.getLeave().getLeaveType(),count);
                }else{
                    leaveTypes.put(empLeaves.getLeave().getLeaveType(),1);
                }
            }
        }
        details.setLeaveTaken(leaveTaken);
        details.setLeaveBalance(10-leaveTaken);
        details.setLeaveType(leaveTypes);
        return details;
    }
}
