package com.qiao.graber.repository;

import com.qiao.graber.domain.Baike;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author qiao
 * email tyrantqiao@icloud.com
 * 13:12
 */
public interface BaikeRepository extends JpaRepository<Baike,Integer>{
    Baike getBaikeByTitle(String title);

    /**
     * Returns a single entity matching the given {@link Example} or {@literal null} if none was found.
     *
     * @param example can be {@literal null}.
     * @return a single entity matching the given {@link Example} or {@literal null} if none was found.
     * @throws org.springframework.dao.IncorrectResultSizeDataAccessException if the Example yields more than one result.
     */
//    <S extends T> S findOne(Example<S> example);
}
