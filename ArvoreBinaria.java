/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

/**
 *
 * @author kaiof
 */
public class ArvoreBinaria {

    public class No {
        public int dado;
        public No filhoEsq;
        public No filhoDir;
    }
    
    class Arvore {
        private No raiz; 

        public Arvore(){ //Construtor
            raiz=null; 
        }
    
        public void inserir(int d) {
            No novo = new No(); 
            novo.dado = d; 
            novo.filhoEsq = null;
            novo.filhoDir = null;

            if (raiz == null){ 
               raiz = novo;
            } else{
                No atual = raiz;
                No anterior;
                while(true) {
                    anterior = atual;
                    if (d <= atual.dado) { 
                        atual = atual.filhoEsq;
                        if (atual == null) {
                            anterior.filhoEsq = novo;
                            return;
                        } 
                    }else {
                        atual = atual.filhoDir;
                        if (atual == null) {
                            anterior.filhoDir = novo;
                        return;
                        }
                    }
                }
            }
        }

        public No buscar(int key) {
            if (raiz == null) {
                return null;
            } 
            No atual = raiz;  
            while (atual.dado != key) {
                if(key < atual.dado ) atual = atual.filhoEsq;
                else {
                    atual = atual.filhoDir;
                } 
                if (atual == null) {
                    return null;
                }
            } 
            return atual;
        }

        public boolean remover(int key) {
            if (raiz == null) {
                return false;
            } 
            No atual = raiz;
            No pai = raiz;
            boolean filho_Esq = true;
            while (atual.dado != key) {
                pai = atual;
                if(key < atual.dado ) { 
                    atual = atual.filhoEsq;
                    filho_Esq = true; 
                }
                else { 
                    atual = atual.filhoDir; 
                    filho_Esq = false; 
                }
                if (atual == null) {
                    return false;
                } 
            } 
            if (atual.filhoEsq == null && atual.filhoDir == null) {
                if (atual == raiz ) {
                    raiz = null;
                } 
                else if (filho_Esq) {
                    pai.filhoEsq = null;
                } 
                else pai.filhoDir = null; 
            }
            else if (atual.filhoDir == null) {
                if (atual == raiz) {
                    raiz = atual.filhoEsq;
                } 
                else if (filho_Esq) {
                    pai.filhoEsq = atual.filhoEsq; 
                }
                else{
                    pai.filhoDir = atual.filhoEsq;
                } 
            }
            else if (atual.filhoEsq == null) {
                if (atual == raiz) {
                    raiz = atual.filhoDir; 
                }
                else if (filho_Esq){ 
                    pai.filhoEsq = atual.filhoDir; 
                }
                else {
                    pai.filhoDir = atual.filhoDir; 
                }
            }
            else {
                No sucessor = noSucessor(atual);
                if (atual == raiz) {
                    raiz = sucessor;
                } 
                else if(filho_Esq) {
                    pai.filhoEsq = sucessor;
                } 
                else {
                    pai.filhoDir = sucessor;
                } 
                sucessor.filhoEsq = atual.filhoEsq;                         
            }
            return true;
        }
        
        public No noSucessor(No apaga) { 
            No paiSucessor = apaga;
            No sucessor = apaga;
            No atual = apaga.filhoDir; 
            while (atual != null) { 
                paiSucessor = sucessor;
                sucessor = atual;
                atual = atual.filhoEsq; 
            } 
            if (sucessor != apaga.filhoDir) { 
                paiSucessor.filhoEsq = sucessor.filhoDir; 
                sucessor.filhoDir = apaga.filhoDir;                        
            }
            return sucessor;
        }

        public void imprimir(int tipo) {
            switch(tipo){
                case 1:
                    System.out.print("\n Exibindo em ordem: ");
                    inOrder(raiz);
                    break;
                case 2:
                    System.out.print("\n Exibindo em pos-ordem: ");
                    posOrder(raiz);
                    break;
                case 3:
                    System.out.print("\n Exibindo em pre-ordem: ");
                    preOrder(raiz);
                    break;
            }
            System.out.println();
        }

        public void inOrder(No atual) {
            if (atual != null) {
                inOrder(atual.filhoEsq);
                System.out.print(atual.dado + " ");
                inOrder(atual.filhoDir);
            }
        }

        public void preOrder(No atual) {
            if (atual != null) {
                System.out.print(atual.dado + " ");
                preOrder(atual.filhoEsq);
                preOrder(atual.filhoDir);
            }
        }

        public void posOrder(No atual) {
            if (atual != null) {
                posOrder(atual.filhoEsq);
                posOrder(atual.filhoDir);
                System.out.print(atual.dado + " ");
            }
        }   
    }  
}
