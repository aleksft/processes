import java.io.IOException;

class Programa{

    public static void main(String [] args){
	Teclado t = new Teclado();
	Teclado aux = new Teclado();
	ListaArboles lista = new ListaArboles();
	String s;
	Arbol arb1, arb2;
	CTrazas conjt;
	CAcciones conjacc;
	int eleccion;
	boolean respuesta;
	int opcion = 0;
	int opaux;

	while(opcion!=-1){
	    System.out.println("\nSi desea crear un arbol pulse 1");
	    System.out.println("Si desea comparar en trazas dos arboles pulse 2");
	    System.out.println("Si desea comparar en bisimilacion dos arboles pulse 3");
	    System.out.println("Si desea saber el conjunto de trazas de un arbol pulse 4");
	    System.out.println("Si desea saber el conjunto de acciones de un arbol pulse 5");
	    System.out.println("Si desea comparar el conjunto de acciones de un arbol pulse 6");
	    System.out.println("Si desea listar los arboles creados pulse 7");
	    System.out.println("Pulse cualquier otro numero para salir");
	    System.out.println("Al elegir su opcion pulse enter \n");
	    try{
		opcion = t.leeInt();
		switch(opcion){
		case 1:{
		    System.out.println("Escriba el String del arbol");
		    s = aux.leeString();
		    arb1 = new Arbol(s);
		    lista.add(arb1);
		    break;
		}
		case 2:{
		    System.out.println(lista.toString());
		    System.out.println("Elija dos arboles, pulsando enter al final de cada una");
		    eleccion = aux.leeInt();
		    arb1 = lista.get(eleccion);
		    eleccion = aux.leeInt();
		    arb2 = lista.get(eleccion);
		    respuesta = arb1.equivalenteTrazas(arb2);
		    System.out.println("Son equivalentes en trazas? "+respuesta);
		    break;
		}
		case 3:{
		    System.out.println(lista.toString());
		    System.out.println("Elija dos arboles, pulsando enter al final de cada una");
		    eleccion = aux.leeInt();
		    arb1 = lista.get(eleccion);
		    eleccion = aux.leeInt();
		    arb2 = lista.get(eleccion);
		    respuesta = arb1.bisimilares(arb2);
		    System.out.println("Son equivalentes en bisimulacion? "+respuesta);
		    break;
		}
		case 4:{
		    System.out.println(lista.toString());
		    System.out.println("Elija un arbol y pulse enter");
		    eleccion = aux.leeInt();
		    arb1 = lista.get(eleccion);
		    conjt = arb1.trazas();
		    System.out.println(conjt.toString());
		    break;
		}
		case 5:{
		    System.out.println(lista.toString());
		    System.out.println("Elija un arbol y pulse enter");
		    eleccion = aux.leeInt();
		    arb1 = lista.get(eleccion);
		    conjacc = arb1.conjuntoDeAcciones();
		    System.out.println(conjacc.toString());
		    break;
		}
		case 6:{
		    System.out.println("comparacion entre 2 arboles ya creados pulse 1");
		    System.out.println("si no, elija cualquier otro numero");
		    opaux = aux.leeInt();
		    if(opaux==1){
			System.out.println(lista.toString());
			System.out.println("Elija dos arboles");
			eleccion = aux.leeInt();
			arb1 = lista.get(eleccion);
			eleccion = aux.leeInt();
			arb2 = lista.get(eleccion);
			respuesta = arb1.enConjuntoDeAcciones(arb2);
			System.out.println("\nEl conjunto del primero esta contenido en");
			System.out.println("el del segundo? "+respuesta);
			respuesta = arb2.enConjuntoDeAcciones(arb1);
			System.out.println("\nEl conjunto del segundo esta contenido en");
			System.out.println("el del primero? "+respuesta);
			respuesta = arb1.mismoConjuntoDeAcciones(arb2);
			System.out.println("\nLos conjunto son iguales? "+respuesta);
		    }
		    else{
			System.out.println(lista.toString());
			System.out.println("Elija un arbol y pulse enter");
			eleccion = aux.leeInt();
			arb1 = lista.get(eleccion);
			System.out.println("Escriba un String de un arbol para comparar");
			s = aux.leeString();
			respuesta = arb1.enConjuntoDeAcciones(s);
			System.out.println("\nEl conjunto de acciones del arbol esta en");
			System.out.println("el del string? "+respuesta);
		    }
		    break;
		}
		case 7:{
		    System.out.println(lista.toString());
		    break;
		}
		default: opcion = -1;
		}
	    } catch(IOException e){
		System.out.println("No ha introducido un dato correcto");
	    }
	}
    }
}