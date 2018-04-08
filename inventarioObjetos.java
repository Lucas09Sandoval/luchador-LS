import java.util.ArrayList;
import java.util.Scanner;


public class inventarioObjetos {
	
	static ArrayList<ObjetoEquipable> inventarioObj = new ArrayList<ObjetoEquipable>();
		
		 //Metodo que mustre todos los Objetos del inventario de Objetos
		public void mostrarInvObj(){
			for(int i=0; i<inventarioObj.size();i++){	    		
			System.out.print("Obj N°:"+" "+i+"\t"+"Nombre "+inventarioObj.get(i).getNom());
			System.out.print("\t"+"Estrellas: "+"\t"+inventarioObj.get(i).getEstrellas());
			System.out.print("\t"+"MejoraTotal: "+"\t"+inventarioObj.get(i).getMejoraFinal());
			System.out.print("\t"+"Estadistica que mejora: "+"\t"+inventarioObj.get(i).getEstadistica());
			System.out.println(""); 	
			}  
		}		
		//Metodo que agrega un objeto al inventario de objetos
		public void agregarObjeto(ArrayList<ObjetoEquipable> objetos){
			Scanner leer = new Scanner(System.in);
			int opc;
			do{
			    System.out.println("Ingrese objeto que desea agregar");
			    opc= leer.nextInt();
			}while(opc>(objetos.size()-1));	    		        	
		        inventarioObj.add(objetos.get(opc));
		        objetos.remove(opc);
		        System.out.println("Se agrego un objeto al inventario de objetos");
		        //for para probar el arraylist siguiente
		        /* for(int i=0;i<inventarioObj.size();i++){
		        System.out.println(inventarioObj.get(i).getNom());
		        }*/
		}		
		//Metodo que elimina un Objeto
		   public void eliminarUnObjeto(){
			   Scanner leer = new Scanner(System.in);
				int opc;
				do{
				    System.out.println("Ingrese Objeto que desea eliminar");
				    opc= leer.nextInt();
				}while(opc>(inventarioObj.size()-1));	    		        	
			        inventarioObj.remove(opc);
			        System.out.println("Se elimino un objeto del inventario de objetos");
			        //for para probar el arraylist siguiente
			        /*
			        for(int i=0;i<inventarioObj.size();i++){
			        System.out.println(inventarioObj.get(i).getNom());
			        }	*/
		    } 
		//Metodo que filtra los Objetos
		public void filtrarObj(){
			Scanner leer = new Scanner(System.in);
			int a=0; //variable para imprimir los Objetos filtrados		
		int stars;
		do{
		System.out.println("Ingrese las estrellas que desea filtrar(desde 1 a 10)");
		stars = leer.nextInt();
		}while(stars>10 || stars<1);
		
		for(int i=0;i<inventarioObj.size();i++){
			if(inventarioObj.get(i).getEstrellas()==stars){
				System.out.println("El Obj N°"+i);
				a++;
			}	
         }System.out.println("Los objetos de "+stars+" estrellas el inventario de objetos son en total:"+a);
		}
     }	
