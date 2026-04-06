// public class submenu {
//     public void alterar(){

//         System.out.println("+==ALTERAR CADASTRO===");

//         /* Busca do Registro */
//         System.out.print("|= Informe o codigo: ");
//         int cod = Integer.parseInt(scan.nextLine());

//         Veiculo v = daoVeiculo.consultar(cod);

//         if(v != null){ // Se existir um veiculo, mostra os dados e pede a alteração
//             int opc = -1;
//             do { 
//                 System.out.println("==ALTERAR CADASTRO==");
//                 System.out.println("-----DADOS-----");
//                 System.out.println("Codigo: " + v.getCodigo());
//                 System.out.println("[1] Modelo: " + v.getModelo());
//                 System.out.println("[2] Marca: " + v.getMarca());
//                 System.out.println("[3] Chassi: " + v.getChassi());
//                 System.out.println("[4] Ano: " + v.getAno());
//                 System.out.println("[0] Sair");
//                 System.out.println("=============================");
                
//                 try{
//                     System.out.print("Escolha um dado para alterar: ");
//                     opc = Integer.parseInt(scan.nextLine());
//                 }catch(Exception e){
//                     System.out.println("ERRO: Informe um valor valido!");
//                 }
//                 System.out.println(""); // Print apenas para espaçamento

//                 switch (opc) {
//                     case 1:
//                         System.out.print("|= Informe o modelo: ");
//                         v.setModelo(scan.nextLine);
//                         break;
//                     case 2:
//                         System.out.print("|= Informe o marca: ");
//                         v.setMarca(scan.nextLine);
//                         break;
//                     case 3:
//                         System.out.print("|= Informe o chassi: ");
//                         v.setChassi(scan.nextLine);
//                         break;
//                     case 4:
//                         System.out.print("|= Informe o ano: ");
//                         v.setAno(Integer.parseInt(scan.nextLine));
//                         break;
//                     case 0:
//                         System.out.println("Saindo...");
//                         break;
//                     default:
//                         System.out.println("ERRO: Opção invalida!");
//                         break;
//                 }
//             } while (opc != 0);

//             int qtd = daoVeiculo.alterar(v);
//             String resultado = qtd > 0 ? "SUCESSO: Atualização realizada!" : "ERRO: Atualização não realizada!";
//             System.out.println(resultado);
//         }
//         else{
//             System.out.println("AVISO: Nenhum veiculo encontrado!");
//         }
//     }
// }
