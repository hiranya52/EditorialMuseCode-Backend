package edu.icet.controller;

import edu.icet.model.dto.InterestRequestDTO;
import edu.icet.service.InterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interests")
@RequiredArgsConstructor
public class InterestController {

    private final InterestService interestService;

    @PostMapping
    public String saveInterests(@RequestParam Long userId, @RequestBody InterestRequestDTO dto) {

        interestService.saveUserInterests(userId, dto);

        return "Interests Saved Successfully";
    }

}
