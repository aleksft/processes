/*
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Describe class Teclado here.
 *
 *
 * Created: Tue Apr  3 12:59:44 2007
 *
 * @author <a href="mailto:llana@sip.ucm.es">Luis Fernando Llana Diaz</a>
 * @version $Id: Teclado.java,v 1.3 2007-04-03 11:03:07 luis Exp $
 */
public class Teclado {
    private static final BufferedReader teclado =
	new BufferedReader(new InputStreamReader(System.in));
    
    public static int leeInt() throws IOException  {
        try  {
	    return Integer.parseInt(teclado.readLine());
	}
        catch (NumberFormatException e) {
	    System.out.println("Numero incorrecto, damelo otra vez.");
	    return leeInt();
	}
    }
    public static long leeLong() throws IOException  {
        try  {
	    return Long.parseLong(teclado.readLine());
	}
        catch (NumberFormatException e) {
	    System.out.println("Numero incorrecto, damelo otra vez.");
	    return leeLong();
	}
    }
    
    public static double leeDouble() throws IOException  {
        try {
	    return Double.parseDouble(teclado.readLine());
	} catch (NumberFormatException e) {
	    System.out.println("Numero incorrecto, damelo otra vez.");
	    return leeDouble();
	}
    }    
    
    public static String leeString() throws IOException {
        return teclado.readLine();
    }
}
