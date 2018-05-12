import java.util.ArrayList;
import java.util.Scanner;


public class InventarioObjetos {
	
	static ArrayList<ObjetoEquipable> inventarioObj = new ArrayList<ObjetoEquipable>();
		
		 //Metodo que mustre todos los Objetos del inventario de Objetos
		public void mostrarInvObj(){
			for(int i=0; i<inventarioObj.size();i++){	    		
			System.out.print("Obj N�:"+" "+i+"\t"+"Nombre "+inventarioObj.get(i).getNom());
			System.out.print("\t"+"Estrellas: "+"\t"+inventarioObj.get(i).getEstrellas());
			System.out.print("\t"+"MejoraTotal: "+"\t"+inventarioObj.get(i).getMejoraFinal());
			System.out.print("\t"+"Estadistica que mejora: "+"\t"+inventarioObj.get(i).getEstadistica());
			System.out.println(""); 	
			}  
		}		
		//Metodo que agrega un objeto al inventario de objetos
		public void agregarObjeto(){
			if(inventarioObj.size()==10){
				System.out.println("No se pueden agregar Objetos");}
			else{
				ObjetoEquipable objeto = new ObjetoEquipable();
				inventarioObj.add(objeto);				
			}
		}		
		//Metodo que elimina un Objeto
		   public void eliminarUnObjeto(){
			   if(inventarioObj.size()==0){
					System.out.println("No hay objetos para mover al inventario");}
				else{
			   Scanner leer = new Scanner(System.in);
				int opc;
				do{
				    System.out.println("Ingrese Objeto que desea eliminar (entre 0 y 9)");
				    opc= leer.nextInt();
				}while(opc>(inventarioObj.size()-1));	    		        	
			        inventarioObj.remove(opc);
			        System.out.println("Se elimino el objeto "+opc+" del inventario de objetos");
				}
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
				System.out.println("El Obj N�"+i);
				a++;
			}	
         }System.out.println("Los objetos de "+stars+" estrellas el inventario de objetos son en total:"+a);
		}
     }	