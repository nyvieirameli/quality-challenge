package br.com.digitalhouse.bootcamp.qualitychallenge.unit;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.NeighborhoodDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.repositories.impl.NeighborhoodRepositoryImpl;
import br.com.digitalhouse.bootcamp.qualitychallenge.repositories.interfaces.NeighborhoodRepository;
import br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NeighborhoodRepositoryTest {

    NeighborhoodRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new NeighborhoodRepositoryImpl();
    }

    @Test
    public void shouldReturnCorrectNeighborhoodByName() {
        var responseExpected = new NeighborhoodDTO("Veloso", 3000.0);

        var response = repository.getByName("Veloso");

        assertThat(response.toString()).isEqualTo(responseExpected.toString());
    }

    @Test
    public void shouldReturnCorrectNeighborhoodByNameWithoutLowerCase() {
        var responseExpected = new NeighborhoodDTO("Veloso", 3000.0);

        var response = repository.getByName("VeLosO");

        assertThat(response.toString()).isEqualTo(responseExpected.toString());
    }

    @Test
    public void shouldReturnNotFoundExceptionWithFakeName() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.getByName("Teste");
        });
    }

    @Test
    public void shouldReturnNullPointerExceptionWithNullName() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            repository.getByName(null);
        });
    }
}
