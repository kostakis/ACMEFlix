package com.acmeflix.service;

import com.acmeflix.domain.TvShow;
import com.acmeflix.repository.TvShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TvShowServiceImplementation extends BaseServiceImpl<TvShow>
        implements TvShowService {

    private final TvShowRepository tvshowRepository;

    JpaRepository<TvShow, Long> getRepository() {
        return tvshowRepository;
    }

    @Override
    public List<TvShow> findByInitialTvShowName(String initialTvShowName) {
        List<TvShow> tvShowList = tvshowRepository.findBytvShowNameStartingWith(initialTvShowName);
        return tvShowList;
    }

    @Override
    public TvShow findByTvShowName(String tvShowName) {
        return tvshowRepository.findByTvShowName(tvShowName);
    }

    @Override
    public List<Long> getAllIds() {
        List<Long> ids = new ArrayList<>();
        var all = findAll();

        for (TvShow show : all) {
            ids.add(show.getId());
        }

        return ids;
    }
}
