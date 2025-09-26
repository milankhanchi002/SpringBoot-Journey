package com.milan.RestAPIs.Repositories;

import com.milan.RestAPIs.Controllers.Student;
import com.milan.RestAPIs.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<Students, Long> {
}
