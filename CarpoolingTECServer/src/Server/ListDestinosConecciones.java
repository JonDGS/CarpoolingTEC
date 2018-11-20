package Server;

public class ListDestinosConecciones {
	
	
	public List<NodoG> ListDestinos(){
		List<NodoG> nodos = new List<NodoG>();
		
		//destinos
		//Alajuela
		Destino RioSegundo = new Destino("Rio_Segundo", 1); Destino AlajuelaCentro = new Destino("Alajuela_Centro", 2);
		Destino Poas = new Destino("Poas", 3); Destino Carrizal = new Destino("Carrizal", 4);
		Destino Grecia = new Destino("Grecia", 5); Destino Atenas = new Destino("Atenas", 6);
		Destino Turrucares = new Destino("Turrucares", 7); Destino Coyol = new Destino("Coyol", 8);
		Destino Montecillos = new Destino("Montecillos", 9); Destino SanCarlos = new Destino("San_Carlos", 10);
		// San José
		Destino SanJoseCentro = new Destino("San_Jose_Centro", 11); Destino Hatillo = new Destino("Hatillo", 12);
		Destino Desamparados = new Destino("Desamparados", 13); Destino Escazu = new Destino("Escazu", 14);
		Destino Aserri = new Destino("Aserri", 15); Destino Alajuelita = new Destino("Alajuelita", 16);
		Destino Coronado = new Destino("Coronado", 17); Destino Zapote = new Destino("Zapote", 18);
		Destino Goicoechea = new Destino("Goicoechea", 19); Destino Guadalupe = new Destino("Guadalupe", 20);
		//Carteles
		Destino TEC = new Destino("TEC", 21); Destino CartagoCentro = new Destino("Cartago_Centro", 22);
		Destino Lima = new Destino("Lima", 23); Destino Paraiso = new Destino("Paraiso", 24);
		Destino Ujarras = new Destino("Ujarras", 25); Destino Aguacaliente = new Destino("Aguacaliente", 26);
		Destino Ochomogo = new Destino("Ochomogo", 27); Destino ElGuarco = new Destino("El_Guarco", 28);
		Destino Tejar = new Destino("Tejar", 29); Destino Dulcecombre = new Destino("Dulcecombre", 30);
				
		NodoG aa = new NodoG("1", "Rio_Segundo", RioSegundo);NodoG ab = new NodoG("2", "Alajuela_Centro", AlajuelaCentro);
		NodoG ac = new NodoG("3", "Poas", Poas);NodoG ad = new NodoG("4", "Carrizal", Carrizal);
		NodoG ae = new NodoG("5", "Grecia", Grecia);NodoG af = new NodoG("6", "Atenas", Atenas);
		NodoG ag = new NodoG("7", "Turrucares", Turrucares);NodoG ah = new NodoG("8", "Coyol", Coyol);
		NodoG ai = new NodoG("9", "Montecillos", Montecillos);NodoG aj = new NodoG("10", "San_Carlos", SanCarlos);
		nodos.addLast(aa);nodos.addLast(ab);nodos.addLast(ac);nodos.addLast(ad);nodos.addLast(ae);nodos.addLast(af);nodos.addLast(ag);nodos.addLast(ah);
		nodos.addLast(ai);nodos.addLast(aj);
		NodoG ak = new NodoG("11", "SanJose_Centro", SanJoseCentro);NodoG al = new NodoG("12", "Hatillo", Hatillo);
		NodoG am = new NodoG("13", "Desamparados", Desamparados);NodoG an = new NodoG("14", "Escazu", Escazu);
		NodoG ao = new NodoG("15", "Aserri", Aserri);NodoG ap = new NodoG("16", "Alajuelita", Alajuelita);
		NodoG aq = new NodoG("17", "Coronado", Coronado);NodoG ar = new NodoG("18", "Zapote", Zapote);
		NodoG as = new NodoG("19", "Goicoechea", Goicoechea);NodoG at = new NodoG("20", "Guadalupe", Guadalupe);
		nodos.addLast(ak);nodos.addLast(al);nodos.addLast(am);nodos.addLast(an);nodos.addLast(ao);nodos.addLast(ap);nodos.addLast(aq);nodos.addLast(ar);
		nodos.addLast(as);nodos.addLast(at);
		NodoG au = new NodoG("11", "TEC", TEC);NodoG av = new NodoG("11", "Cartago_Centro", CartagoCentro);
		NodoG aw = new NodoG("11", "Lima", Lima);NodoG ax = new NodoG("11", "Paraiso", Paraiso);
		NodoG ay = new NodoG("11", "Ujarras", Ujarras);NodoG az = new NodoG("11", "Aguacaliente", Aguacaliente);
		NodoG ba = new NodoG("11", "Ochomogo", Ochomogo);NodoG bb = new NodoG("11", "ElGuarco", ElGuarco);
		NodoG bc = new NodoG("11", "Tejar", Tejar);NodoG bd = new NodoG("11", "Dulcecombre", Dulcecombre);
		nodos.addLast(au);nodos.addLast(av);nodos.addLast(aw);nodos.addLast(ax);nodos.addLast(ay);nodos.addLast(az);nodos.addLast(ba);nodos.addLast(bb);
		nodos.addLast(bc);nodos.addLast(bd);
		
		
		
		return nodos;
	}
	
	public List<Coneccion> listConecciones(){
		List<Coneccion> conecciones = new List<Coneccion>();
		
		
		
		
		return conecciones;
	}
}
