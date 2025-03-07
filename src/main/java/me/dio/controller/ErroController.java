package me.dio.controller;


import me.dio.model.Erro;
import me.dio.service.ErroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/erro")
public class ErroController {

    @Autowired
    private ErroService erroService;

    @PostMapping("/create-erro")
    public ResponseEntity<Erro> createErro(@RequestBody Erro erro){
        var erroCreated = erroService.create(erro);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(erroCreated)
                .toUri();
        return ResponseEntity.created(location).body(erroCreated);
    }

    @PutMapping("/update-erro")
    public ResponseEntity<Erro> updtareErro(@RequestBody Erro erro){
        var erroUpdated = erroService.update(erro);
        return ResponseEntity.ok(erroUpdated);
    }

    @GetMapping("lista-erro")
    public ResponseEntity<List<Erro>> getErro(){
        List<Erro> errosListados = erroService.getErro();
        return ResponseEntity.ok(errosListados);
    }

    @DeleteMapping("erro/{id}")
    public ResponseEntity<Erro> deleteErro(@PathVariable Long id){
        erroService.delete(id);
        return ResponseEntity.ok().build();
    }
}
