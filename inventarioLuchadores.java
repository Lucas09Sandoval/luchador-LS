import java.util.ArrayList;
import java.util.Scanner;
public class inventarioLuchadores {
	
	static ArrayList<luchador_LucasSandoval> inventario = new ArrayList<luchador_LucasSandoval>();
	
//Metodos para "agregar", "mostrar todos" y "ver un luchador" en la clase Luchador_LucasSandoval
	
	 //Metodo que mustre todos los luchadores del inventario
	public void mostrarInv(){
		for(int i=0; i<inventario.size();i++){	    		
		System.out.print("Luchador N°"+" "+i+"\t"+"Nombre "+inventario.get(i).getNom());
		System.out.print("\t"+"Rango "+"\t"+inventario.get(i).getRango());
		System.out.print("\t"+"Facción "+"\t"+inventario.get(i).getFaccion());
		System.out.println(""); 	
		}  
	}
	
	//Metodo que muestra un solo luchador con todos sus datos	    	
	  public void verUnLuchador(int opc){
	    	System.out.println("Luchador N°"+" "+opc);
	    	System.out.println("Nombre "+inventario.get(opc).getNom());
   		System.out.println("Rango "+"\t"+inventario.get(opc).getRango());
   		System.out.println("Facción "+"\t"+inventario.get(opc).getFaccion());
   		System.out.println("HP "+"\t"+inventario.get(opc).getHp());
   		System.out.println("ATK "+"\t"+inventario.get(opc).getAtk());
   		System.out.println("DEF "+"\t"+inventario.get(opc).getDef());
   		System.out.println("SPD "+"\t"+inventario.get(opc).getSpd());
   		System.out.println(""); 	    	
	    }	   
	
	//Metodo que agrega luchador al inventario
	public void agregarLuchador(ArrayList<luchador_LucasSandoval>listaLuchs){
		Scanner leer = new Scanner(System.in);
		int opc;
		do{
		    System.out.println("Ingrese luchador que desea agregar");
		    opc= leer.nextInt();
		}while(opc>(listaLuchs.size()-1));	    		        	
	        inventario.add(listaLuchs.get(opc));
	        listaLuchs.remove(opc);
	        System.out.println("Se agrego un luchador al inventario");
	        //for para probar el arraylist siguiente
	        for(int i=0;i<inventario.size();i++){
	        System.out.println(inventario.get(i).getNom());
	        }
	}		
	//Metodo que elimina un luchador
	   public void eliminarUnluchador(){
		   Scanner leer = new Scanner(System.in);
			int opc;
			do{
			    System.out.println("Ingrese luchador que desea eliminar");
			    opc= leer.nextInt();
			}while(opc>(inventario.size()-1));	    		        	
		        inventario.remove(opc);
		        System.out.println("Se elimino un luchador del inventario");
		        //for para probar el arraylist siguiente
		        for(int i=0;i<inventario.size();i++){
		        System.out.println(inventario.get(i).getNom());
		        }	
	    } 
	//Metodo que filtra los luchadores
	public void filtrar(){
		
		int opc;
		Scanner leer = new Scanner(System.in);
		do{//para asegurarse que sea una opción valida
		System.out.println("¿Desea filtrar por:");
		System.out.println("1. Rango");
		System.out.println("2.Facción");
		opc =leer.nextInt();	
		}while(opc>2 || opc<1);
		
		int a=0; //variable para imprimir los peleadores filtrados
		String F=" ";//para filtrar en Facción haciendo uso del metodo equals
		
		if(opc==1){int rang;
			do{
			System.out.println("Ingrese el rango que desea filtrar(desde 1 a 5)");
			rang = leer.nextInt();
			}while(rang>5 || rang<1);
			
			for(int i=0;i<inventario.size();i++){
				if(inventario.get(i).getRango()==rang){
					System.out.println("El peleador N°"+i);
					a++;
				}				
			}			
			System.out.println("Los luchadores del rango "+rang+" en el inventario son en total:"+a);			
		}else{int fac;	//para obtener la facción del menu que viene abajo		      
		        do{
				System.out.println("Ingrese la facción que desea filtrar");
				System.out.println("1. Agua");
				System.out.println("2. Fuego");
				System.out.println("3. Tierra");
				fac = leer.nextInt();}while(fac>3 || fac<1);
		        
		        if(fac==1){F= "Agua";}
		        if(fac==2){F= "Fuego";}
		        if(fac==3){F= "Tierra";}
		        
				for(int i=0;i<inventario.size();i++){
					if(F.equals(inventario.get(i).getFaccion())){
						System.out.println("El peleador N°"+i);
						a++;
					}				
				}			
				System.out.println("Total de luchadores de la facción "+F+" en el inventario son en total:"+a);				
		}
    }
}
