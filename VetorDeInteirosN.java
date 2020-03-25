/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetornteste;
import java.util.Scanner;

/**
 *
 * @author kaiog
 */
public class VetorNteste {
    static Scanner tec = new Scanner(System.in);
    static int vet[] = new int[6];
    static int vet2[] = new int[6];

    public static void main(String[] args) {
        // TODO code application logic here
        int j=0;
        for(int i = 0 ; i<vet.length ; i++){
            vet[i] = i;//Não entendi a parte da função randomica
        }
        System.out.println("====Vetor De Inteiros======");
        int cont =0;
        int opcao=-1;
        while(opcao!=0){            
            
            System.out.println("Digite a opção desejada ");
            System.out.println(" 1 - Inserir vetor ");
            System.out.println(" 2 - Inverter ");
            System.out.println(" 3 - Buscar ");
            System.out.println(" 4 - Remover ");
            System.out.println(" 5 - Imprimir ");
            System.out.println(" 0 - Sair ");
            opcao = tec.nextInt();
                
            
            switch (opcao){
                
                case 1: //INSERIR
                        for(int i = 0 ; i<vet.length ; i++){
                            System.out.println("Digete o valor a ser inserido no vetor: ");
                            vet[i] = tec.nextInt();
                            cont = cont+1;
                        }
                break;
                
                case 2://INVERTER
                        int meio = (int)vet.length/2;
                        for(int i = 0 ; i<vet.length; i++){
                           j = (vet.length-1)-i;
                           vet2[i] = vet[j];
                           vet2[j] = vet[i];
                        }
                        System.out.println("Vetor 1:");
                        for(int i = 0 ; i<vet.length ; i++){
                            System.out.print(vet[i]+" | ");
                        }
                        System.out.println();
                        System.out.println("Vetor 2:");
                        for(int i = 0 ; i<vet.length ; i++){
                            System.out.print(vet2[i]+" | ");
                        }
                        System.out.println();
                    break;
                    
                case 3: //BUSCAR
                        System.out.println("Digite numero para buscar:");
                        int busca = tec.nextInt();
                        int posicao =0;
                        boolean achou = false;
                        for (int i = 0; i < vet.length; i++) {
                            if(vet[i] == busca){
                                posicao = i;
                                achou = true;
                            }                          
                        }
                        if(achou == true){
                            System.out.println("Encontrado na Posição: "+ posicao);
                            break;
                        }else{
                            System.out.println("Não Encontrado!");
                            break;
                        }
                case 4: //REMOVER
                        System.out.println("Digite número para remover:");
                        int remover = tec.nextInt();                     
                        int posicao1 =0;
                        boolean achou1 = false;
                        for (int i = 0; i < vet.length; i++) {
                            if(vet[i] == remover){
                                posicao1 = i;
                                achou1 = true;
                            }                          
                        }
                        if(achou1 == true){
                            for (int i = posicao1; i < (vet.length-1); i++) {
                                vet[i] = vet[i+1];
                            }
                            System.out.println("Removido com sucesso!");
                        }else{
                            System.out.println("Falha ao remover");
                        }
                    break;
                case 5: //IMPRIMIR
                    for(int i = 0 ; i<vet.length ; i++){
                            System.out.print(vet[i]+" | ");
                        }
                    break;
            }//switch
        }//while
    }//Main
}
