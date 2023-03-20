package consjhonar;

import java.util.*;

public class ConsJhoNar {
    
 
    
    

   
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        String puerta = "", propietario, dire, pobla;
        int planta, metros, nHabi,numPi,num,codPostal;
        EdiJhoNar edi1 = new EdiJhoNar();
   
        boolean salir = false;
        do {
            //menu
            System.out.println("-----------------------------------------");
            System.out.println("\t\t1\tConstruir edificio");
            System.out.println("\t\t2\tConstruir pisos");
            System.out.println("\t\t3\tModificar un piso dado");
            System.out.println("\t\t4\tBuscar un piso");
            System.out.println("\t\t5\tEliminar un piso");
            System.out.println("\t\t6\tMostrar información de todos los pisos");
            System.out.println("\t\t7\tMostrar información del edificio");
            System.out.println("\t\t8\tSalir");
            System.out.println("-----------------------------------------");
            System.out.print("ELIGE UNA OPCIÓN: ");
            byte opc = sc.nextByte();

            switch (opc) {
                case 1:
                    //pide datos del edificio por pantalla
                    sc.nextLine();
                    System.out.print("Inserte la direccion del edificio:");
                    dire= sc.nextLine();
                    System.out.print("Enserta el número: ");
                    num=sc.nextInt();
                    System.out.print("Inserta el codigo postal: ");
                    codPostal= sc.nextInt();
                    sc.nextLine();
                    System.out.print("Inserta la población: ");
                    pobla= sc.nextLine();
                    System.out.print("Inserta el número de pisos: ");
                    numPi=sc.nextInt();
                    //crea un edificio con los datos
                    edi1 = new EdiJhoNar(dire, num, codPostal, pobla, numPi);
                    break;
                case 2:
                    //hara una llamada al metodo de arraylleno, segun el retorno
                    //el edificio esta vacio, esta lleno o se insertara un piso
                    switch (EdiJhoNar.arrLLeno()) {
                        case -3:
                            System.out.println("El edificio no existe");
                            break;
                        case -1:
                            System.out.println("El edifico esta lleno");
                            break;

                        case 0:
                            sc.nextLine();
                            System.out.print("Inserta el propiertario: ");
                            propietario = sc.nextLine();
                            System.out.print("Inserta la planta: ");
                            planta = sc.nextInt();

                            //pida el dato de puerta hasta que cumpla los patrones
                            do {
                                sc.nextLine();
                                System.out.print("Inserta puerta: ");
                                puerta = sc.nextLine();
                                //lo pasa a mayusculas
                                puerta = puerta.toUpperCase();
                                System.out.println(puerta);
                            } while (!EdiJhoNar.valLetra(puerta));
                            System.out.print("Inserta los metros cuadradaos: ");
                            metros = sc.nextInt();
                            System.out.print("Inserta el número de habitaciones: ");
                            nHabi = sc.nextInt();
                            //llama a busacrPisos, si el retorno es igual a -1, significa que no 
                            //existe, por lo que lo inserta con los datos antes pedidos
                            if (EdiJhoNar.buscaPiso(planta, puerta) == -1) {
                                edi1.insertarPiso(propietario, puerta, planta, metros, nHabi);
                                System.out.println("Se ha insertao el piso concretamente");
                            } else {
                                //si existe, mostrara un mensaje de que ya existe
                                System.out.println("El Piso " + planta + puerta + " ya existe");
                            }
                    }

                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Inserta la planta: ");
                    planta = sc.nextInt();
                    do {
                        sc.nextLine();
                        System.out.print("Inserta puerta: ");
                        puerta = sc.nextLine();
                        puerta = puerta.toUpperCase();
                        System.out.println(puerta);
                    } while (!EdiJhoNar.valLetra(puerta));
                    //llamara a bsuacrPisos si el retorno es distinto de -1, la cual
                    //sera la posicion del array, se llama a actualizar propietario
                    //el cual se le pasa, la planta, la puerta y el nuevo propietario
                    if (EdiJhoNar.buscaPiso(planta, puerta) != -1) {
                        System.out.print("Inserta el nuevo propietario ");
                        propietario = sc.nextLine();
                        System.out.println(EdiJhoNar.actualizaPro(planta, puerta, propietario));

                    } else {
                        //si devuelve -1 es que el piso no existe, no se puede cmabiar de propietario
                        System.out.println("El Piso " + planta + puerta + " no existe");
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.print("Inserta la planta: ");
                    planta = sc.nextInt();
                    do {
                        sc.nextLine();
                        System.out.print("Inserta puerta: ");
                        puerta = sc.nextLine();
                        puerta = puerta.toUpperCase();
                    } while (!EdiJhoNar.valLetra(puerta));
                     //llama a busacr piso, que devulve posicion, con la cual se llama
                    //al tostring pasandole la posicion, nos devolvera los datos del piso
                    if (EdiJhoNar.buscaPiso(planta, puerta) != -1) {
                        int pos = EdiJhoNar.buscaPiso(planta, puerta);
                        System.out.println("El piso se encuentra en la posición " + pos);
                        System.out.println(EdiJhoNar.toString(pos));

                    } else {
                        System.out.println("El Piso " + planta + puerta + " no existe");
                    }
                    break;
                case 5:

                    sc.nextLine();
                    System.out.print("Inserta la planta: ");
                    planta = sc.nextInt();
                    do {
                        sc.nextLine();
                        System.out.print("Inserta puerta [ A | B]: ");
                        puerta = sc.nextLine();
                        puerta = puerta.toUpperCase();
                    } while (!EdiJhoNar.valLetra(puerta));
                      //llama a borrar piso, segun se existe o no se borra
                    if (EdiJhoNar.borrarPiso(puerta, planta)) {
                       System.out.println("El Piso " + planta + puerta + " se ha borrado");

                    } else {
                        System.out.println("El Piso " + planta + puerta + " no existe");
                    }

                    break;
                case 6:
                    //llama al metodo de listar pisos
                    EdiJhoNar.listaPisos();
                    break;
                case 7:
                    //llama al metodo tostring de edicio
                    System.out.println(edi1.toString());
                    break;
                case 8:
                    //Salidaa
                    salir = true;
                    break;

                default:
                    System.out.println("Introduce una opción correcta: ");
                //ingrese una opcion correcta
            }

        } while (!salir);
        sc.close();
    }
    
    
    
    
    
    
    

}
