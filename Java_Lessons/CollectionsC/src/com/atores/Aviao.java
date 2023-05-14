package com.atores;

import java.util.*;

public class Aviao implements Comparable {
        private String id;
        private String nome;
        private int nPoltronas;

        private Map<Integer, Clientes> poltCompradas;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public int getnPoltronas() {
                return nPoltronas;
        }

        public void setnPoltronas(int nPoltronas) {
                this.nPoltronas = nPoltronas;
        }

        public Aviao(String Nome, int nPoltronas) {
                UUID uuid = UUID.randomUUID();
                this.setId(uuid.toString());
                this.setNome(Nome);
                this.setnPoltronas(nPoltronas);
                this.poltCompradas = new HashMap<>();
        }

        public boolean addCustomer(int poltrona, Clientes cliente) {
                if ()
                return poltCompradas.put(poltrona, cliente);
        }

        @Override
        public int hashCode() {
                return this.getId().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
                if (this == null)
                        return false;
                if (!(obj instanceof Aviao))
                        return false;
                if (obj == this)
                        return true;
                if (this.hashCode() == ((Aviao)obj).hashCode()
                        return true;
        }

        @Override
        public int compareTo(Object o) {
                return this.getNome().compareToIgnoreCase(((Aviao) o).getNome());
        }

}
