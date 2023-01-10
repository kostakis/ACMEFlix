package com.acmeflix.service;

import com.acmeflix.domain.TvShow;
import com.acmeflix.repository.TvShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TvShowServiceImplementation extends BaseServiceImpl<TvShow>
        implements TvShowService {

    private final TvShowRepository tvshowRepository;

    JpaRepository<TvShow, Long> getRepository() { return tvshowRepository;}
}
