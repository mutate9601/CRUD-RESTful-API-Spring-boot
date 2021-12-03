package com.yash.db.repositry;

import  org.springframework.data.jpa.repository.JpaRepository;

import com.yash.db.model.student;

public interface studentRepo extends JpaRepository<student,Long> {

}

