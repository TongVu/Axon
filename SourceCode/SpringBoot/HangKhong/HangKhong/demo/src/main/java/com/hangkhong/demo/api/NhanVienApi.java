package com.hangkhong.demo.api;

import com.hangkhong.demo.entity.NhanVien;
import com.hangkhong.demo.exception.ResourseNotFound;
import com.hangkhong.demo.service.nhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge =  3600)
@RequestMapping("/nhanvien")
public class NhanVienApi {
    @Autowired
    private nhanVienService nhanVienService;

    @GetMapping
    private List<NhanVien> getAll() {
        return nhanVienService.getAllNhanVien();
    }

    @GetMapping("/{id}")
    private ResponseEntity<NhanVien> getNhanVienById(@PathVariable(value = "id") Integer id)
            throws ResourseNotFound {
        NhanVien nhanVien = nhanVienService.findNhanVienById(id).orElseThrow(() -> new ResourseNotFound("Id not found" + id));
        return ResponseEntity.ok().body(nhanVien);
    }
    @PostMapping("/add")
    public void create(@RequestBody NhanVien nhanVien){
        nhanVienService.save(nhanVien);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<NhanVien>delete(@PathVariable(value = "id")Integer id)
        throws ResourseNotFound{
        NhanVien nhanVien=nhanVienService.findNhanVienById(id)
                .orElseThrow(()->new ResourseNotFound("Id not found for nhan vien"+id));
        nhanVienService.deleteNhanVienById(id);
        return ResponseEntity.ok(nhanVien);
    }
    @PutMapping("/{id}")
    public ResponseEntity<NhanVien> update(@PathVariable(value = "id")Integer id,
                                           @RequestBody NhanVien nhanVien)throws ResourseNotFound{
        NhanVien nhanVien1=nhanVienService.findNhanVienById(id)
                .orElseThrow(()->new ResourseNotFound("Nhan vien id does not exist"+id));
        nhanVien1.setName(nhanVien.getName());
        nhanVien1.setSalary(nhanVien.getSalary());
        return ResponseEntity.ok(nhanVien1);
    }
}
