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
            System.out.println(" 1 - Inserir vetor: ");
            System.out.println(" 2 - Inverter ");
            System.out.println(" 3 - Buscar ");
            System.out.println(" 4 - Remover ");
            System.out.println(" 0 - Sair ");
            opcao = tec.nextInt();
                
            
            switch (opcao){
                case 1: for(int i = 0 ; i<vet.length ; i++){
                            System.out.println("Digete o valor a ser inserido no vetor: ");
                            vet[i] = tec.nextInt();
                        }
                case 2: for(int i = 0 ; i<vet.length ; i++){
                            j = vet.length - (i-1);
                            vet2[i] = vet[j];
                        }
                        System.out.println("Vetor 1:");
                        for(int i = 0 ; i<vet.length ; i++){
                            System.out.println(vet[i]+" | ");
                        }
                        System.out.println("Vetor 2:");
                        for(int i = 0 ; i<vet.length ; i++){
                            System.out.println(vet2[i]+" | ");
                        }
                    break;
                
            
            }
        }
    }
    
}
