package com.example.userapp.repository;

import com.example.userapp.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByAccountIdIn(Collection<Long> accountIds);

    /**
     * TODO Здесь у меня все-таки есть сомнения. Если мы попробуем сделать fetch двух листов, то получим эксепшен.
     *  Если мы заменим листы на сеты, то эксепшена не получим, но получим декартово произведение, что, насколько понимаю,
     *  не только ударит по производительности, но и может выдать неправильный result set в итоге.
     *  https://itnext.io/advantages-of-not-using-spring-data-and-hibernate-with-relational-data-8a509faf0c48
     *  вот здесь в разделе Modern Hibernate incorrectly processes fetch joins. Мне кажется, что EntityGraph может делать
     *  так же, на рабочем проекте я получил несколько тысяч записей вместо примерно двухсот.
     */
//    @EntityGraph(value = "UserPhoneEmailGraph", type = EntityGraph.EntityGraphType.FETCH)
//    List<User> findAllWithPhoneAndEmail();
//
//    List<User> findAllByPhoneIdsIn(Collection<Long> phoneIds);
}
