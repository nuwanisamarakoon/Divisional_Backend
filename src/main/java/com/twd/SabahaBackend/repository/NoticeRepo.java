package com.twd.SabahaBackend.repository;

import com.twd.SabahaBackend.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepo extends JpaRepository<Notice, Long> {

}