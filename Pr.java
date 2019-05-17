class Pr{

    public static void main(String [] args){
	Arbol a = new Arbol("a(b+c)+dd(c+be)+ac(b+e+d+bc)");
	Arbol b = new Arbol("a(b+c(e+d+bc))+d(d+dc+dbe)");
	Arbol c = new Arbol("a(b+c(e+d+bc))+dd(c+be)");
	Arbol d = new Arbol("a(b+c)+a(b+c)+dd(c+be+be)+ac(b+e+d+bc)");
	Arbol e = new Arbol("a+dd(c+e)+abc(e+b)");
	Arbol f = new Arbol("");
	CAcciones ca = a.conjuntoDeAcciones();
	CAcciones cb = b.conjuntoDeAcciones();
	CAcciones cc = c.conjuntoDeAcciones();
	CAcciones cd = d.conjuntoDeAcciones();
	CAcciones ce = e.conjuntoDeAcciones();
	CAcciones cf = f.conjuntoDeAcciones();
	System.out.println("\n Segunda parte de la prueba: conjuntos de acciones \n");
	System.out.println(" Veamos ahora cuales son los minimos conjuntos de acciones");
	System.out.println("que necesitamos para construir los arboles y las relaciones");
	System.out.println("entre ellos:");
	System.out.println("\nArbol a: "+a.toString());
	System.out.println("Conjunto de acciones de a: "+ca.toString());
	System.out.println("\nArbol b: "+b.toString());
	System.out.println("Conjunto de acciones de b: "+cb.toString());
	System.out.println("\nArbol c: "+c.toString());
	System.out.println("Conjunto de acciones de c: "+cc.toString());
	System.out.println("\nArbol d: "+d.toString());
	System.out.println("Conjunto de acciones de d: "+cd.toString());
	System.out.println("\nArbol e: "+e.toString());
	System.out.println("Conjunto de acciones de e: "+ce.toString());
	System.out.println("\nArbol f: "+f.toString());
	System.out.println("Conjunto de acciones de f: "+cf.toString());
	System.out.println("\n Un arbol puede construirse con un conjunto de acciones c");
	System.out.println("si su conjunto de acciones esta contenido en c");
	System.out.println("\nPuede a construirse con el conjunto de acciones de a(b+c)?");
	System.out.println(a.enConjuntoDeAcciones("a(b+c)"));
	System.out.println("\nPuede a construirse con el conjunto de acciones de b?");
	System.out.println(a.enConjuntoDeAcciones(b));
	System.out.println("\nY con el de f?");
	System.out.println(a.enConjuntoDeAcciones(f));
	System.out.println("\nY f con el de a?");
	System.out.println(f.enConjuntoDeAcciones(a));
	System.out.println("\nTienen a y b el mismo conjunto de acciones?");
	System.out.println(a.mismoConjuntoDeAcciones(b));
	System.out.println("\nY a y f?");
	System.out.println(a.mismoConjuntoDeAcciones(f));
	System.out.println("\n Fin de la prueba \n");
    }
}