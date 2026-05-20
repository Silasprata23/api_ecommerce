package com.list.ecommerce.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class FotoService {

    @Value("${upload.dir}")
    private String upload;

    public String saveFoto (MultipartFile foto ) throws IOException{

        String NomeOriginal = foto.getOriginalFilename();
        String extensao = NomeOriginal.substring(NomeOriginal.lastIndexOf("."));
        String NovoNome = UUID.randomUUID() + extensao;

        Path diretorio = Path.of(upload);
        Files.createDirectories(diretorio);

        Path pathUrl = diretorio.resolve(NovoNome);

        Files.copy(foto.getInputStream(), pathUrl);

        return upload + "/" + NovoNome;
    }


}
