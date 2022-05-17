package com.axonactive.demo.api;

import com.axonactive.demo.entity.Project;
import com.axonactive.demo.entity.Relative;
import com.axonactive.demo.service.ProjectService;
import com.axonactive.demo.service.RelativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RelativeResources {
    private final RelativeService relativeService;

    @GetMapping("/relative")
    public List<Relative> getAllRelative(){
        List<Relative> allRelative = relativeService.getAll();
        return allRelative;
    }
}
