package com.kh.edu.cstad.khotixs.asset_service.feature.file;

import com.kh.edu.cstad.khotixs.asset_service.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long>{

    Optional<File> findByFileName(String fileName);

    boolean existsByFileName(String fileName);
}
