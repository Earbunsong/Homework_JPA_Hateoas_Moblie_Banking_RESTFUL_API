package co.cstad.song.s_advance_jpa_restful_hw1.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseJpaRepository<T,ID> extends JpaRepository<T,ID> {
    void refresh(T entity);
}
