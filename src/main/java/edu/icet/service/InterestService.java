package edu.icet.service;

import edu.icet.repository.CategoryRepository;
import edu.icet.repository.UserInterestRepository;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterestService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final UserInterestRepository userInterestRepository;


}
