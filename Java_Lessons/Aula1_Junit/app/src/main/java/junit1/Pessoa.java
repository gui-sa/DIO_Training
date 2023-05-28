package junit1;

import java.time.LocalDate;
import java.util.Objects;
import java.time.temporal.ChronoUnit;

public class Pessoa {
        private String nome;
        private LocalDate nascimento;

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public LocalDate getNascimento() {
                return nascimento;
        }

        public void setNascimento(LocalDate nascimento) {
                this.nascimento = nascimento;
        }

        public Pessoa(String nome, LocalDate nascimento) {
                setNome(nome);
                setNascimento(nascimento);
        }

        public Pessoa(String nome) {
                setNome(nome);
        }

        public int getIdade() {
                return (int) ChronoUnit.YEARS.between(this.getNascimento(), LocalDate.now());
        }

        @Override
        public int hashCode() {
                return Objects.hash(nome, nascimento);
        }

        @Override
        public boolean equals(Object obj) {
                if (obj == null)
                        return false;
                if (!(obj instanceof Pessoa))
                        return false;
                if (obj == this)
                        return true;
                return Objects.equals(this.getNome(), ((Pessoa) obj).getNome())
                                && Objects.equals(this.getNascimento(), ((Pessoa) obj).getNascimento());
        }

        @Override
        public String toString() {
                return this.getNome() + " nasceu em " + this.getNascimento();
        }
}
