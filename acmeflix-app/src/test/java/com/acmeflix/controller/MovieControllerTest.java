package com.acmeflix.controller;

import com.acmeflix.domain.Movie;
import com.acmeflix.domain.enumeration.Category;
import com.acmeflix.service.MovieService;
import com.acmeflix.transfer.resource.MovieResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("MovieController Tests")
class MovieControllerTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(movieController)
                .setControllerAdvice(new GlobalExcpetionHandler())
                .build();
    }

    // ─── Unit-level tests (direct method call) ─────────────────────────────────

    @Test
    @DisplayName("findAll: returns HTTP 200 and non-null body when movies exist")
    void findAll_returnsOkResponseWithData_whenMoviesExist() {
        List<Movie> movies = List.of(
                new Movie(1L, "Inception", Category.SCIFI, "A mind-bending thriller", 2010, 148, 8.8f),
                new Movie(2L, "The Godfather", Category.DRAMA, "A crime dynasty story", 1972, 175, 9.2f)
        );
        List<MovieResource> resources = List.of(
                new MovieResource("Inception", "A mind-bending thriller", 2010, Category.SCIFI, 148, 1L, 8.8f),
                new MovieResource("The Godfather", "A crime dynasty story", 1972, Category.DRAMA, 175, 2L, 9.2f)
        );

        when(movieService.findAll()).thenReturn(movies);
        when(movieService.toMovieResource(movies)).thenReturn(resources);

        var response = movieController.findAll();

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    @DisplayName("findAll: data field contains the mapped movie resources")
    void findAll_dataContainsMovieResources_whenMoviesExist() {
        List<Movie> movies = List.of(
                new Movie(1L, "Inception", Category.SCIFI, "A mind-bending thriller", 2010, 148, 8.8f)
        );
        MovieResource expectedResource = new MovieResource("Inception", "A mind-bending thriller", 2010, Category.SCIFI, 148, 1L, 8.8f);
        List<MovieResource> resources = List.of(expectedResource);

        when(movieService.findAll()).thenReturn(movies);
        when(movieService.toMovieResource(movies)).thenReturn(resources);

        var response = movieController.findAll();
        var body = (com.acmeflix.transfer.ApiResponse<?>) response.getBody();

        assertThat(body).isNotNull();
        assertThat(body.getData()).isEqualTo(resources);
        assertThat(body.getApiError()).isNull();
    }

    @Test
    @DisplayName("findAll: returns HTTP 200 and empty data list when no movies exist")
    void findAll_returnsEmptyList_whenNoMoviesExist() {
        when(movieService.findAll()).thenReturn(Collections.emptyList());
        when(movieService.toMovieResource(Collections.emptyList())).thenReturn(Collections.emptyList());

        var response = movieController.findAll();
        var body = (com.acmeflix.transfer.ApiResponse<List<MovieResource>>) response.getBody();

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(body).isNotNull();
        assertThat(body.getData()).isEmpty();
    }

    @Test
    @DisplayName("findAll: verifies service interactions — findAll() and toMovieResource() are each called once")
    void findAll_callsServiceMethods_exactlyOnce() {
        List<Movie> movies = List.of(new Movie(1L, "Inception", Category.SCIFI, "desc", 2010, 148, 8.8f));
        List<MovieResource> resources = List.of(new MovieResource());

        when(movieService.findAll()).thenReturn(movies);
        when(movieService.toMovieResource(movies)).thenReturn(resources);

        movieController.findAll();

        verify(movieService, times(1)).findAll();
        verify(movieService, times(1)).toMovieResource(movies);
        verifyNoMoreInteractions(movieService);
    }

    @Test
    @DisplayName("findAll: propagates RuntimeException thrown by service")
    void findAll_propagatesException_whenServiceThrows() {
        when(movieService.findAll()).thenThrow(new RuntimeException("Database unavailable"));

        org.assertj.core.api.Assertions.assertThatThrownBy(() -> movieController.findAll())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Database unavailable");
    }

    // ─── HTTP layer tests (MockMvc standalone) ─────────────────────────────────

    @Test
    @DisplayName("GET /movies: returns 200 and JSON content-type when movies exist")
    void getMappingMovies_returns200WithJson_whenMoviesExist() throws Exception {
        List<Movie> movies = List.of(
                new Movie(1L, "Inception", Category.SCIFI, "A mind-bending thriller", 2010, 148, 8.8f)
        );
        List<MovieResource> resources = List.of(
                new MovieResource("Inception", "A mind-bending thriller", 2010, Category.SCIFI, 148, 1L, 8.8f)
        );

        when(movieService.findAll()).thenReturn(movies);
        when(movieService.toMovieResource(movies)).thenReturn(resources);

        mockMvc.perform(get("/movies").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].movieName").value("Inception"))
                .andExpect(jsonPath("$.data[0].movieYear").value(2010))
                .andExpect(jsonPath("$.apiError").doesNotExist());
    }

    @Test
    @DisplayName("GET /movies: returns 200 with empty data array when no movies exist")
    void getMappingMovies_returns200WithEmptyArray_whenNoMoviesExist() throws Exception {
        when(movieService.findAll()).thenReturn(Collections.emptyList());
        when(movieService.toMovieResource(Collections.emptyList())).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/movies").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    @DisplayName("GET /movies: returns 500 with apiError when service throws exception")
    void getMappingMovies_returns500WithApiError_whenServiceThrows() throws Exception {
        when(movieService.findAll()).thenThrow(new RuntimeException("Database unavailable"));

        mockMvc.perform(get("/movies").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.apiError.status").value(500))
                .andExpect(jsonPath("$.apiError.message").value("Database unavailable"));
    }

    @Test
    @DisplayName("GET /movies: returns 404 with apiError when service throws NoSuchElementException")
    void getMappingMovies_returns404WithApiError_whenNoSuchElementThrown() throws Exception {
        when(movieService.findAll()).thenThrow(new java.util.NoSuchElementException("No movies found"));

        mockMvc.perform(get("/movies").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.apiError.status").value(404))
                .andExpect(jsonPath("$.apiError.message").value("No movies found"));
    }
}
