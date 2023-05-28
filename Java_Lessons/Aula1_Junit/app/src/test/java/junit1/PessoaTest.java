/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package junit1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PessoaTest {

    @Test
    void validarEquals() {
        Pessoa teste0 = new Pessoa("Ricardo", LocalDate.of(2000, 1, 25));
        Pessoa teste1 = new Pessoa("Ricardo", LocalDate.of(2000, 1, 25));
        Assertions.assertEquals(teste0, teste1);
        Pessoa teste2 = new Pessoa("Ricardo", LocalDate.of(1999, 1, 25));
        Assertions.assertNotEquals(teste0, teste2);
    }

    @Test
    void validarCalculoIdade() {
        Pessoa teste0 = new Pessoa("Ricardo", LocalDate.of(2000, 1, 25));
        Assertions.assertEquals(23, teste0.getIdade());
    }

}