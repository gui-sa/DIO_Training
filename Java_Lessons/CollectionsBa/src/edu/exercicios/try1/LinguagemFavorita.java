package edu.exercicios.try1;

import java.util.*;

public class LinguagemFavorita {

        private String nome;
        private int anoDeCriacao;
        private String ide;

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public int getAnoDeCriacao() {
                return anoDeCriacao;
        }

        public void setAnoDeCriacao(int anoDeCriacao) {
                this.anoDeCriacao = anoDeCriacao;
        }

        public String getIde() {
                return ide;
        }

        public void setIde(String ide) {
                this.ide = ide;
        }

        public LinguagemFavorita(String ide) { // Did that just o test overload property
                setIde(ide);
        }

        public LinguagemFavorita(String ide, String nome, int anoDeCriacao) {
                setIde(ide);
                setNome(nome);
                setAnoDeCriacao(anoDeCriacao);
        }

        @Override
        public String toString() {

                return this.getNome() + " usando " + this.getIde() + " surgiu em " + this.getAnoDeCriacao();
        }

        @Override
        public int hashCode() {
                return Objects.hash(this.getNome());
        }

        https:// www.educative.io/answers/what-is-the-hashsethashcode-method-in-java
}