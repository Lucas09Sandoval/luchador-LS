import java.util.Scanner;
public class inventarioLuchadores {
	
	luchador_LucasSandoval luch = new luchador_LucasSandoval();
	
	public void menu(){
    	luch.nombres();
    	int opc=0;
        do{
        Scanner leer = new Scanner(System.in);
        System.out.println("1. Agregar un luchador(límite:15)");
        System.out.println("2. Mostrar todos los luchadores");
        System.out.println("3. Mostrar datos de un luchador");
        System.out.println("4. Filtrar luchador");
        System.out.println("5. Eliminar luchador(Solo elimina el último creado)"); 
        System.out.println("6. Crear objeto equipable");
        System.out.println("7. Salir");
        opc = leer.nextInt();
        ObjetoEquipable obj= new ObjetoEquipable();
           
        switch(opc){
         case 1: luch.agregarUnLuchador(luch.rango(),luch.hp(),luch.atk(),luch.def(),luch.spd(), luch.elegirNombre(luch.nombres()),luch.elegirFaccion(luch.faccion()));
                 menu();
                 break;             
         case 2: luch.mostrarPeleadores(); 
                 menu();
                 break;
         case 3: luch.mostrarDatosDeUnLuchador(ingresarLuchador());
                 menu();
                 break;
         case 4: filtrarLuchador();
        	     break;
         case 5: luch.eliminarLuchador();
                 menu();
        	     break;
         case 6: obj.generarObjetoEquipable();
                 menu();
        	     break;
         case 7: System.out.println("Adios!");
                 break;
        }
        }while(opc>7 || opc<1);    	
    }
	public static int ingresarLuchador(){
		Scanner leer = new Scanner(System.in);
		int peleador;
		System.out.println("Ingrese el luchador que desea ver");
		peleador = leer.nextInt();
		return peleador;
	}
	public static void filtrarLuchador(){
		inventarioLuchadores filtLuch= new inventarioLuchadores();
		Scanner leer = new Scanner(System.in);
		int filtro =0;		
		do{ System.out.println("Desea filtrar por:");
			System.out.println("1.Facción");
			System.out.println("2.Rango");
			filtro = leer.nextInt();
			switch(filtro){
			case 1:filtLuch.filtrarFacc();
			filtLuch.menu();			
			break;
			case 2:filtLuch.filtrarRang();
			filtLuch.menu();
			break;
				}
		}while(filtro>2||filtro<1);		
	}
	
	public void filtrarFacc(){
		int fac;
		do{
		System.out.println("Ingrese facción que desea filtrar");	
		System.out.println("1. Agua");
		System.out.println("2. Fuego");
		System.out.println("3. Tierra");
		Scanner leer= new Scanner(System.in);
		fac = leer.nextInt();
		luch.filtrarFaccion(fac);
		}while(fac>3||fac<1);
	}
    public void filtrarRang(){
    	System.out.println("Los rangos de los luchadores estan entre 1 y 5");
    	System.out.println("Ingrese rango que desea filtrar:");
		Scanner leer= new Scanner(System.in);
		int rang = leer.nextInt();
		luch.filtrarRango(rang);
		
	}
}
