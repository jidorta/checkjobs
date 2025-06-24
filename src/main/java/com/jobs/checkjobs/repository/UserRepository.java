package com.jobs.checkjobs.repository;

import com.jobs.checkjobs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
