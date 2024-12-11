package com.example.mfi.controllers;

import com.example.mfi.dtos.LprRecordDto;
import com.example.mfi.models.LprModel;
import com.example.mfi.repositories.LprRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LprController {

    @Autowired
    LprRepository lprRepository;

    @PostMapping("/lprs")
    public ResponseEntity<LprModel> saveProduct(@RequestBody @Valid LprRecordDto lprRecordDto){ //recebe o dt e passa para model
        var lprModel = new LprModel(); //cria uma variavel para o objeto productmodel
        BeanUtils.copyProperties(lprRecordDto, lprModel); //faz a conversão de dt para model
        return ResponseEntity.status(HttpStatus.CREATED).body(lprRepository.save(lprModel)); //utilizar o http status para retornar uma resposta ao usuário
        // e no body estamos enviando os dados salvos do product model
    }
    @GetMapping("/lprs")
        public ResponseEntity<List<LprModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(lprRepository.findAll());
    }

    @GetMapping("/lprs/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "idLpr") UUID id){
        Optional<LprModel> lpr_ = lprRepository.findById(id);
        if(lpr_.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lpr not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(lpr_.get());
    }
    @PutMapping("/lprs/{id}")
    public ResponseEntity<Object> updateProject(@PathVariable(value = "idLpr") UUID id,
                                                @RequestBody @Valid LprRecordDto lprRecordDto){
        Optional<LprModel> lpr_ = lprRepository.findById(id);
        if(lpr_.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lpr not found");
        }
        var lprModel = lpr_.get();
        BeanUtils.copyProperties(lprRecordDto, lprModel);
        return ResponseEntity.status(HttpStatus.OK).body(lprRepository.save(lprModel));
    }
    @DeleteMapping("/lprs/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "idLpr") UUID id){
        Optional<LprModel> lpr_ = lprRepository.findById(id);
        if(lpr_.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lpr not found");
        }
        lprRepository.delete(lpr_.get());
        return ResponseEntity.status(HttpStatus.OK).body("Lpr deleted successfuly");
    }
}
