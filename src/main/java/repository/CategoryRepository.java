package repository;

import model.dto.CategoryDTO;
import model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<CategoryDTO, Long> {

    List<Category> findById(Set<Long> ids);

}
