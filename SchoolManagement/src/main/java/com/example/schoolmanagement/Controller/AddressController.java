package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.DTO.DtoAddressInsert;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressservice;

    @PostMapping("/add")
    public ResponseEntity addaddress(@Valid @RequestBody DtoAddressInsert dto, Error errors){
        addressservice.add(dto, errors);
        return ResponseEntity.status(200).body("success");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateaddress(@PathVariable int id, @Valid @RequestBody DtoAddressInsert dto, Error errors){
        addressservice.update(id, dto, errors);
        return ResponseEntity.status(200).body("success");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteaddress(@PathVariable int id){
        addressservice.delete(id);
        return ResponseEntity.status(200).body("success");
    }

}