package com.hangkhong.demo.api;

import com.hangkhong.demo.entity.ChuyenBay;
import com.hangkhong.demo.exception.ResourseNotFound;
import com.hangkhong.demo.service.chuyenBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge =  3600)
@RequestMapping("/chuyenbay")
public class ChuyenBayApi {
    @Autowired
    private chuyenBayService chuyenBayService;

    @GetMapping
    private List<ChuyenBay> getAll() {
        return chuyenBayService.getAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<ChuyenBay> getNhanVienById(@PathVariable(value = "id") Integer id)
            throws ResourseNotFound {
        ChuyenBay chuyenBay = chuyenBayService.getById(id).orElseThrow(() -> new ResourseNotFound("Id not found" + id));
        return ResponseEntity.ok().body(chuyenBay);
    }

    @PostMapping("/add")
    public void create(@RequestBody ChuyenBay chuyenBay) {
        chuyenBayService.save(chuyenBay);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ChuyenBay> delete(@PathVariable(value = "id") Integer id)
            throws ResourseNotFound {
        ChuyenBay chuyenBay = chuyenBayService.getById(id)
                .orElseThrow(() -> new ResourseNotFound("Id not found for nhan vien" + id));
        chuyenBayService.deleteById(id);
        return ResponseEntity.ok(chuyenBay);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChuyenBay> update(@PathVariable(value = "id") Integer id,
                                            @RequestBody ChuyenBay chuyenBay) throws ResourseNotFound {
        ChuyenBay chungNhan1 = chuyenBayService.getById(id)
                .orElseThrow(() -> new ResourseNotFound("Nhan vien id does not exist" + id));
        chungNhan1.setChiPhi(chuyenBay.getChiPhi());
        chungNhan1.setDoDai(chuyenBay.getDoDai());
        chungNhan1.setGaDen(chuyenBay.getGaDen());
        chungNhan1.setGaDi(chuyenBay.getGaDi());
        chungNhan1.setGioDi(chuyenBay.getGioDi());
        chungNhan1.setGioDen(chuyenBay.getGioDen());
        return ResponseEntity.ok(chungNhan1);
    }
}