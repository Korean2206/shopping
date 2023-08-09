package com.asm.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asm.entity.Product;
import com.asm.entity.Size;
import com.asm.service.SizeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/sizes")
public class SizeRestController {
    
    @Autowired
    SizeService sizeService;
    @PostMapping("")
    public List<Size> create(@RequestBody List<Size> size){
        return sizeService.create(size);
    }
}
