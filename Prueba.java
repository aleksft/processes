class Prueba{

    public static void main(String [] args){
	Arbol a = new Arbol("a(b+c)+dd(c+be)+ac(b+e+d+bc)");
	Arbol b = new Arbol("a(b+c(e+d+bc))+d(d+dc+dbe)");
	Arbol c = new Arbol("a(b+c(e+d+bc))+dd(c+be)");
	Arbol d = new Arbol("a(b+c)+a(b+c)+dd(c+be+be)+ac(b+e+d+bc)");
	Arbol e = new Arbol("a+dd(c+e)+abc(e+b)");
	Arbol f = new Arbol("");
	CTrazas conjunto1 = a.trazas();
	CTrazas conjunto2 = b.trazas();
	CTrazas conjunto3 = c.trazas();
	CTrazas conjunto4 = d.trazas();
	CTrazas conjunto5 = e.trazas();
	CTrazas conjunto6 = f.trazas();
	System.out.println("\n Primera parte de la prueba: procesos, trazas y equivalencias \n");
	System.out.println("Tenemos los siguientes arboles:");
	System.out.println("Arbol a: "+a.toString());
	System.out.println("Arbol b: "+b.toString());
	System.out.println("Arbol c: "+c.toString());
	System.out.println("Arbol d: "+d.toString());
	System.out.println("Arbol e: "+e.toString());
	System.out.println("Arbol f: "+f.toString());
	System.out.println("\n Con los siguientes conjuntos de trazas: ");
	System.out.println("Trazas de a: "+conjunto1.toString());
	System.out.println("Trazas de b: "+conjunto2.toString());
	System.out.println("Trazas de c: "+conjunto3.toString());
	System.out.println("Trazas de d: "+conjunto4.toString());
	System.out.println("Trazas de e: "+conjunto5.toString());
	System.out.println("Trazas de f: "+conjunto6.toString());
	System.out.println("respectivamente");
	System.out.println("\n Veamos la equivalencia de trazas:");
	System.out.println("a y b: "+a.equivalenteTrazas(b));
	System.out.println("a y c: "+a.equivalenteTrazas(c));
	System.out.println("a y d: "+a.equivalenteTrazas(d));
	System.out.println("a y e: "+a.equivalenteTrazas(e));
	System.out.println("a y f: "+a.equivalenteTrazas(f));
	System.out.println("b y c: "+b.equivalenteTrazas(c));
	System.out.println("b y d: "+b.equivalenteTrazas(d));
	System.out.println("b y e: "+b.equivalenteTrazas(e));
	System.out.println("b y f: "+b.equivalenteTrazas(f));
	System.out.println("c y d: "+c.equivalenteTrazas(d));
	System.out.println("c y e: "+c.equivalenteTrazas(e));
	System.out.println("c y f: "+c.equivalenteTrazas(f));
	System.out.println("d y e: "+d.equivalenteTrazas(e));
	System.out.println("d y f: "+d.equivalenteTrazas(f));
	System.out.println("e y f: "+e.equivalenteTrazas(f));
	System.out.println("\n Veamos ahora si son bisimilares:");
	System.out.println("a y b: "+a.bisimilares(b));
	System.out.println("a y c: "+a.bisimilares(c));
	System.out.println("a y d: "+a.bisimilares(d));
	System.out.println("a y e: "+a.bisimilares(e));
	System.out.println("a y f: "+a.bisimilares(f));
	System.out.println("b y c: "+b.bisimilares(c));
	System.out.println("b y d: "+b.bisimilares(d));
	System.out.println("b y e: "+b.bisimilares(e));
	System.out.println("b y f: "+b.bisimilares(f));
	System.out.println("c y d: "+c.bisimilares(d));
	System.out.println("c y e: "+c.bisimilares(e));
	System.out.println("c y f: "+c.bisimilares(f));
	System.out.println("d y e: "+d.bisimilares(e));
	System.out.println("d y f: "+d.bisimilares(f));
	System.out.println("e y f: "+e.bisimilares(f));
	System.out.println("\n Primera parte de la prueba terminada, segunda parte: Pr.java");
    }
}