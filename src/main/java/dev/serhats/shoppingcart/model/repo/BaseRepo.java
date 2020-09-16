package dev.serhats.shoppingcart.model.repo;

import dev.serhats.shoppingcart.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepo<Entity extends BaseModel> extends JpaRepository<Entity, Long> {
}
