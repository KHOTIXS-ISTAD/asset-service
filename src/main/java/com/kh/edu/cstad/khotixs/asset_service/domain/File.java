package com.kh.edu.cstad.khotixs.asset_service.domain;

import com.kh.edu.cstad.khotixs.asset_service.config.jpa.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "files")
@Entity
public class File extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false,unique = true,length = 100)
    String fileName;

    String contentType;

    String folder;

    Long fileSize;

    String extension;

}
