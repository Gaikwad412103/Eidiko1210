package com.leave.controller;

import com.leave.dto.EmpLeaveDetails;
import com.leave.entity.Leave;
import com.leave.service.EmpLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpLeavesController {
    @Autowired
    EmpLeaveService empLeaveService;

    @GetMapping("/getEmpLeaveDetailsById/{id}")
    public EmpLeaveDetails getEmpLeaveDetails(@PathVariable int id){
        return empLeaveService.getEmpLeaveDetails(id);
    }

}
