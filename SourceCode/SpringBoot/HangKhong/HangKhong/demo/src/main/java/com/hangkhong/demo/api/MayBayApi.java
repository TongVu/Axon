package com.hangkhong.demo.api;

import com.hangkhong.demo.entity.MayBay;
import com.hangkhong.demo.exception.ResourseNotFound;
import com.hangkhong.demo.service.mayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/maybay")
public class MayBayApi {
    @Autowired
    private mayBayService mayBayService;

    @GetMapping
    private List<MayBay> getAll() {
        return mayBayService.getAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<MayBay> getNhanVienById(@PathVariable(value = "id") Integer id)
            throws ResourseNotFound {
        MayBay mayBay = mayBayService.getById(id).orElseThrow(() -> new ResourseNotFound("Id not found" + id));
        return ResponseEntity.ok().body(mayBay);
    }

    @PostMapping("/add")
    public void create(@RequestBody MayBay mayBay) {
        mayBayService.save(mayBay);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MayBay> delete(@PathVariable(value = "id") Integer id)
            throws ResourseNotFound {
        MayBay mayBay = mayBayService.getById(id)
                .orElseThrow(() -> new ResourseNotFound("Id not found for may bay" + id));
        mayBayService.deleteById(id);
        return ResponseEntity.ok(mayBay);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MayBay> update(@PathVariable(value = "id") Integer id,
                                         @RequestBody MayBay mayBay) throws ResourseNotFound {
        MayBay mayBay1 = mayBayService.getById(id)
                .orElseThrow(() -> new ResourseNotFound("Nhan vien id does not exist" + id));
        mayBay1.setLoaiMayBay(mayBay.getLoaiMayBay());
        mayBay1.setTamBay(mayBay.getTamBay());
        return ResponseEntity.ok(mayBay1);
    }
}