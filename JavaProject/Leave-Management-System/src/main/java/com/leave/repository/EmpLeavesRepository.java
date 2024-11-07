package com.leave.repository;

import com.leave.entity.EmpLeaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpLeavesRepository extends JpaRepository<EmpLeaves,Integer> {

}
