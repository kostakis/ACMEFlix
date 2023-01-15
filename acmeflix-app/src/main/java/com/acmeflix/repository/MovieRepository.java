package com.acmeflix.repository;

import com.acmeflix.domain.Movie;
import com.acmeflix.transfer.KeyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findBymovieNameStartingWith(String initialMovieName);

    Movie findByMovieName(String movieName);

    //select new gr.codelearn.spring.showcase.app.transfer.KeyValue(concat(c.firstname, ' ', c.lastname), " +
    //        "avg(o.cost))

    //@Query("select new gr.codelearn.spring.showcase.app.transfer.KeyValue(concat(c.firstname, ' ', c.lastname), " +
    //        "avg(o.cost)) from Order o join o.customer c group by c order by c.lastname, c.firstname")

}
