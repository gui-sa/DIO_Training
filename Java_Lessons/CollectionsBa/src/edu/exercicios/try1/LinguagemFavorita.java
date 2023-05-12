package edu.exercicios.try1;

public class LinguagemFavorita implements Comparable {

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
        public boolean equals(Object obj) { // true for the same; false for diferent
                if (obj == null)
                        return false; // it needs to be an object
                if (!(obj instanceof LinguagemFavorita)) // It needs to be object of that class
                        return false;
                if (obj == this) // If it is compared with itsef... return true because it is the same
                        return true;
                return (this.getNome() + this.getIde()).equalsIgnoreCase(
                                ((LinguagemFavorita) obj).getNome() + ((LinguagemFavorita) obj).getIde()); // getIDE
                                                                                                           // must be
                                                                                                           // the same
                                                                                                           // when
                                                                                                           // casted to
                // the same class
        }

        @Override
        public int hashCode() {
                return (this.getNome() + this.getIde()).hashCode();
        }

        @Override
        public int compareTo(Object o) {
                return (this.getNome() + this.getIde()).compareToIgnoreCase(
                                ((LinguagemFavorita) o).getNome() + ((LinguagemFavorita) o).getIde());
        }

}