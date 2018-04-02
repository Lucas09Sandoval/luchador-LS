import java.util.ArrayList;
import java.util.Scanner;
public class inventarioLuchadores {
	
//Metodos para "agregar", "mostrar todos" y "ver un luchador" en la clase Luchador_LucasSandoval
	
	//Metodo que elimina un luchador
	   public int eliminarUnluchador(int opc,ArrayList<luchador_LucasSandoval> listaLuchs, int luchT){
	    listaLuchs.remove(opc);
	    luchT--;
	    return luchT;
	    } 
	//Metodo que filtra los luchadores
	public void filtrar(ArrayList<luchador_LucasSandoval> listaLuchs){
		
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
			
			for(int i=0;i<listaLuchs.size();i++){
				if(listaLuchs.get(i).getRango()==rang){
					System.out.println("El peleador N°"+i);
					a++;
				}				
			}			
			System.out.println("Los luchadores del rango "+rang+" son en total:"+a);			
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
		        
				for(int i=0;i<listaLuchs.size();i++){
					if(F.equals(listaLuchs.get(i).getFaccion())){
						System.out.println("El peleador N°"+i);
						a++;
					}				
				}			
				System.out.println("Total de luchadores de la facción "+F+" son en total:"+a);				
		}
    }
}
