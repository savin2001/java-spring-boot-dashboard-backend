package com.osukatech.adminDashboard.CustomerRepo;

import com.osukatech.adminDashboard.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Employee, Integer> {
}
