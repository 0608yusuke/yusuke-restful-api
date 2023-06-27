package com.study.skillup.restfulapi.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileForm {
  private MultipartFile file;
}
