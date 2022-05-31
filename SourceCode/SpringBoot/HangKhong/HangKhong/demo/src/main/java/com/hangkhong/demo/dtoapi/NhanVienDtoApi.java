package com.hangkhong.demo.dtoapi;

import com.hangkhong.demo.dto.NhanVienDto;
import com.hangkhong.demo.entity.NhanVien;
import com.hangkhong.demo.exception.ResourseNotFound;
import com.hangkhong.demo.service.impl.nhanVienServiceImpl;
import com.hangkhong.demo.service.nhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/nhanvienDTO")

public class NhanVienDtoApi {
    @Autowired
    private nhanVienService nhanVienService;

    @GetMapping
    public List<NhanVienDto> getAll() {
        return nhanVienService.toNhanVienDTO(nhanVienService.getAllNhanVien());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVienDto> getNhanVienById(@PathVariable(value = "id") Integer id)
            throws ResourseNotFound {
        NhanVien nhanVien = nhanVienService.findNhanVienById(id).
                orElseThrow(() -> new ResourseNotFound("Nhan vien id not exist " + id));
        return ResponseEntity.ok(nhanVienService.toNhanVienDTO(nhanVien));
    }

    @PostMapping("/add")
    public  NhanVien create(@RequestBody NhanVienDto nhanVienDto){
        nhanVienService.save(nhanVienService.toNhanVienEntity(nhanVienDto));
        return  nhanVienService.toNhanVienEntity(nhanVienDto);
    }
    @PutMapping("id")
    public ResponseEntity<NhanVien> update(@PathVariable(value = "id")Integer id,
        @RequestBody NhanVienDto nhanVienDto)throws ResourseNotFound{
        NhanVien nhanVien=nhanVienService.findNhanVienById(id)
                .orElseThrow(()->new ResourseNotFound("Id does not exist "+id));
        nhanVien.setName(nhanVienDto.getName());
        return ResponseEntity.ok(nhanVien);
    }
    @DeleteMapping("/delete")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Integer id) throws Exception {
        NhanVien nhanVien = nhanVienService.findNhanVienById(id)
                .orElseThrow(() -> new ResourseNotFound("NhanVien not found: " + id));
        nhanVienService.deleteNhanVienById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
