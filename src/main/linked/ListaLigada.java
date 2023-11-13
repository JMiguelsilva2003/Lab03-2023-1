package linked;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

    private No cabeca;

    public ListaLigada() {
        cabeca = null;
    }

    @Override
    public boolean buscaElemento(int valor) {
        No atual = cabeca;

        while (atual != null) {
            if (atual.getValor() == valor) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        No atual = cabeca;
        int indice = 0;

        while (atual != null) {
            if (atual.getValor() == valor) {
                return indice;
            }
            atual = atual.getProximo();
            indice++;
        }

        return -1; // Return -1 if the element is not found
    }

    @Override
    public int minimo() {
        if (cabeca == null) {
            throw new IllegalStateException("Empty list");
        }

        No atual = cabeca;
        int minimo = atual.getValor();

        while (atual != null) {
            if (atual.getValor() < minimo) {
                minimo = atual.getValor();
            }
            atual = atual.getProximo();
        }
        return minimo;
    }

    @Override
    public int maximo() {
        if (cabeca == null) {
            throw new IllegalStateException("Empty list");
        }

        No atual = cabeca;
        int maximo = atual.getValor();

        while (atual != null) {
            if (atual.getValor() > maximo) {
                maximo = atual.getValor();
            }
            atual = atual.getProximo();
        }
        return maximo;
    }

    @Override
    public int predecessor(int valor) {
        No atual = cabeca;
        No predecessor = null;

        while (atual != null) {
            if (atual.getValor() == valor) {
                if (predecessor == null) {
                    throw new IllegalArgumentException("No predecessor for the first element");
                }
                return predecessor.getValor();
            }
            predecessor = atual;
            atual = atual.getProximo();
        }

        throw new IllegalArgumentException("Value not found in the list");
    }

    @Override
    public int sucessor(int valor) {
        No atual = cabeca;

        while (atual != null) {
            if (atual.getValor() == valor && atual.getProximo() != null) {
                return atual.getProximo().getValor();
            }
            atual = atual.getProximo();
        }

        throw new IllegalArgumentException("Value not found in the list or has no successor");
    }

    @Override
    public void insereElemento(int valor) {
        insereInicio(valor);
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if (buscaIndice < 0) {
            throw new IllegalArgumentException("Invalid index");
        }

        No novoNo = new No(valor);

        if (buscaIndice == 0) {
            novoNo.setProximo(cabeca);
            cabeca = novoNo;
            return;
        }

        No anterior = null;
        No atual = cabeca;
        int contador = 0;

        while (atual != null && contador < buscaIndice) {
            anterior = atual;
            atual = atual.getProximo();
            contador++;
        }

        if (contador == buscaIndice) {
            anterior.setProximo(novoNo);
            novoNo.setProximo(atual);
        } else {
            throw new IllegalArgumentException("Index out of bounds");
        }
    }

    @Override
    public void insereInicio(int valor) {
        No novoNo = new No(valor);

        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            novoNo.setProximo(cabeca);
            cabeca = novoNo;
        }
    }

    @Override
    public void insereFim(int valor) {
        No novoNo = new No(valor);

        if (cabeca == null) {
            cabeca = novoNo;
            return;
        }

        No andandoNo = cabeca;
        while (andandoNo.getProximo() != null) {
            andandoNo = andandoNo.getProximo();
        }

        andandoNo.setProximo(novoNo);
    }

    @Override
    public void remove(int valor) {
        if (cabeca == null) {
            return;
        }

        if (cabeca.getValor() == valor) {
            removeInicio();
            return;
        }

        No anterior = null;
        No atual = cabeca;

        while (atual != null) {
            if (atual.getValor() == valor) {
                anterior.setProximo(atual.getProximo());
                return;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }

    @Override
    public void removeIndice(int indice) {
        if (cabeca == null) {
            return;
        }

        if (indice == 0) {
            cabeca = cabeca.getProximo();
            return;
        }

        No anterior = null;
        No atual = cabeca;
        int contador = 0;

        while (atual != null && contador < indice) {
            anterior = atual;
            atual = atual.getProximo();
            contador++;
        }

        if (atual != null) {
            anterior.setProximo(atual.getProximo());
        }
    }

    @Override
    public void removeInicio() {
        if (cabeca != null) {
            cabeca = cabeca.getProximo();
        }
    }

    @Override
    public void removeFim() {
        if (cabeca == null) {
            return;
        }

        if (cabeca.getProximo() == null) {
            cabeca = null;
            return;
        }

        No anterior = null;
        No atual = cabeca;

        while (atual.getProximo() != null) {
            anterior = atual;
            atual = atual.getProximo();
        }

        anterior.setProximo(null);
    }

    // Other methods...

    private static class No {
        private int valor;
        private No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }

        public int getValor() {
            return valor;
        }

        public No getProximo() {
            return proximo;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }
    }
}
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFim'");
    }
    
}
