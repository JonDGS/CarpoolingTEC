package Server;
/* Clase encargada de crerar la lista de los destinos que
 * tendra la aplicacion
 * ademas de crear tambien las conecciones
 * 
 */

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
				
		NodoG aa = new NodoG("1", "Rio_Segundo", RioSegundo);   NodoG ab = new NodoG("2", "Alajuela_Centro", AlajuelaCentro);
		NodoG ac = new NodoG("3", "Poas", Poas);                NodoG ad = new NodoG("4", "Carrizal", Carrizal);
		NodoG ae = new NodoG("5", "Grecia", Grecia);            NodoG af = new NodoG("6", "Atenas", Atenas);
		NodoG ag = new NodoG("7", "Turrucares", Turrucares);    NodoG ah = new NodoG("8", "Coyol", Coyol);
		NodoG ai = new NodoG("9", "Montecillos", Montecillos);  NodoG aj = new NodoG("10", "San_Carlos", SanCarlos);
		nodos.addLast(aa);nodos.addLast(ab);nodos.addLast(ac);nodos.addLast(ad);nodos.addLast(ae);nodos.addLast(af);nodos.addLast(ag);nodos.addLast(ah);
		nodos.addLast(ai);nodos.addLast(aj);
		NodoG ak = new NodoG("11", "SanJose_Centro", SanJoseCentro); NodoG al = new NodoG("12", "Hatillo", Hatillo);
		NodoG am = new NodoG("13", "Desamparados", Desamparados);    NodoG an = new NodoG("14", "Escazu", Escazu);
		NodoG ao = new NodoG("15", "Aserri", Aserri);                NodoG ap = new NodoG("16", "Alajuelita", Alajuelita);
		NodoG aq = new NodoG("17", "Coronado", Coronado);            NodoG ar = new NodoG("18", "Zapote", Zapote);
		NodoG as = new NodoG("19", "Goicoechea", Goicoechea);        NodoG at = new NodoG("20", "Guadalupe", Guadalupe);
		nodos.addLast(ak);nodos.addLast(al);nodos.addLast(am);nodos.addLast(an);nodos.addLast(ao);nodos.addLast(ap);nodos.addLast(aq);nodos.addLast(ar);
		nodos.addLast(as);nodos.addLast(at);
		NodoG au = new NodoG("21", "TEC", TEC);            NodoG av = new NodoG("22", "Cartago_Centro", CartagoCentro);
		NodoG aw = new NodoG("23", "Lima", Lima);          NodoG ax = new NodoG("24", "Paraiso", Paraiso);
		NodoG ay = new NodoG("25", "Ujarras", Ujarras);    NodoG az = new NodoG("26", "Aguacaliente", Aguacaliente);
		NodoG ba = new NodoG("27", "Ochomogo", Ochomogo);  NodoG bb = new NodoG("28", "ElGuarco", ElGuarco);
		NodoG bc = new NodoG("29", "Tejar", Tejar);        NodoG bd = new NodoG("30", "Dulcecombre", Dulcecombre);
		nodos.addLast(au);nodos.addLast(av);nodos.addLast(aw);nodos.addLast(ax);nodos.addLast(ay);nodos.addLast(az);nodos.addLast(ba);nodos.addLast(bb);
		nodos.addLast(bc);nodos.addLast(bd);
		
		
		
		return nodos;
	}
	
	public List<Coneccion> listConecciones(List<NodoG> nodo){
		
		List<Coneccion> conecciones = new List<Coneccion>();
		//conecciones fijas : alajuela
		Coneccion aa = new Coneccion("aa", nodo.getData(9),nodo.getData(4),ranNum());
		Coneccion ab = new Coneccion("ab", nodo.getData(2),nodo.getData(4),ranNum());
		Coneccion ac = new Coneccion("ac", nodo.getData(2),nodo.getData(1),ranNum());
		Coneccion ad = new Coneccion("ad", nodo.getData(4),nodo.getData(1),ranNum());
		Coneccion ae = new Coneccion("ae", nodo.getData(5),nodo.getData(7),ranNum());
		Coneccion af = new Coneccion("af", nodo.getData(6),nodo.getData(7),ranNum());
		Coneccion ag = new Coneccion("ag", nodo.getData(7),nodo.getData(8),ranNum());
		Coneccion ah = new Coneccion("ah", nodo.getData(8),nodo.getData(1),ranNum());
		Coneccion ai = new Coneccion("ai", nodo.getData(1),nodo.getData(3),ranNum());
		Coneccion aj = new Coneccion("aj", nodo.getData(1),nodo.getData(0),ranNum());
		conecciones.addLast(aa);conecciones.addLast(ab);conecciones.addLast(ac);conecciones.addLast(ad);conecciones.addLast(ae);
		conecciones.addLast(af);conecciones.addLast(ag);conecciones.addLast(ah);conecciones.addLast(ai);conecciones.addLast(aj);
		//conecciones fijas : San Jose
		Coneccion ak = new Coneccion("ak", nodo.getData(14),nodo.getData(11),ranNum());
		Coneccion al = new Coneccion("al", nodo.getData(11),nodo.getData(10),ranNum());
		Coneccion am = new Coneccion("am", nodo.getData(11),nodo.getData(15),ranNum());
		Coneccion an = new Coneccion("an", nodo.getData(15),nodo.getData(10),ranNum());
		Coneccion ao = new Coneccion("ao", nodo.getData(14),nodo.getData(15),ranNum());
		Coneccion ap = new Coneccion("ap", nodo.getData(14),nodo.getData(12),ranNum());
		Coneccion aq = new Coneccion("aq", nodo.getData(12),nodo.getData(17),ranNum());
		Coneccion ar = new Coneccion("ar", nodo.getData(10),nodo.getData(17),ranNum());
		Coneccion as = new Coneccion("as", nodo.getData(19),nodo.getData(17),ranNum());
		Coneccion at = new Coneccion("at", nodo.getData(19),nodo.getData(10),ranNum());
		Coneccion au = new Coneccion("au", nodo.getData(18),nodo.getData(19),ranNum());
		Coneccion av = new Coneccion("av", nodo.getData(16),nodo.getData(18),ranNum());
		conecciones.addLast(ak);conecciones.addLast(al);conecciones.addLast(am);conecciones.addLast(an);conecciones.addLast(ao);
		conecciones.addLast(ap);conecciones.addLast(aq);conecciones.addLast(ar);conecciones.addLast(as);conecciones.addLast(at);
		conecciones.addLast(au);conecciones.addLast(av);
		//conecciones fijas : Cartago
		Coneccion aw = new Coneccion("aw", nodo.getData(26),nodo.getData(22),ranNum());
		Coneccion ax = new Coneccion("ax", nodo.getData(22),nodo.getData(21),ranNum());
		Coneccion ay = new Coneccion("ay", nodo.getData(22),nodo.getData(27),ranNum());
		Coneccion az = new Coneccion("az", nodo.getData(27),nodo.getData(21),ranNum());
		Coneccion ba = new Coneccion("ba", nodo.getData(28),nodo.getData(21),ranNum());
		Coneccion bb = new Coneccion("bb", nodo.getData(25),nodo.getData(28),ranNum());
		Coneccion bc = new Coneccion("bc", nodo.getData(21),nodo.getData(20),ranNum());
		Coneccion bd = new Coneccion("bd", nodo.getData(29),nodo.getData(21),ranNum());
		Coneccion be = new Coneccion("be", nodo.getData(29),nodo.getData(20),ranNum());
		Coneccion bf = new Coneccion("bf", nodo.getData(23),nodo.getData(20),ranNum());
		Coneccion bg = new Coneccion("bg", nodo.getData(24),nodo.getData(23),ranNum());
		conecciones.addLast(aw);conecciones.addLast(ax);conecciones.addLast(ay);conecciones.addLast(az);conecciones.addLast(ba);
		conecciones.addLast(bb);conecciones.addLast(bc);conecciones.addLast(bd);conecciones.addLast(be);conecciones.addLast(bf);
		conecciones.addLast(bg);
		//conecciones fijas : alajuela- San Jose
		Coneccion bh = new Coneccion("bh", nodo.getData(3),nodo.getData(13),ranNum());
		Coneccion bi = new Coneccion("bi", nodo.getData(0),nodo.getData(13),ranNum());
		conecciones.addLast(bh);conecciones.addLast(bi);
		
		//conecciones fijas : San Jose- cartago
		Coneccion bj = new Coneccion("bj", nodo.getData(17),nodo.getData(26),ranNum());
		Coneccion bk = new Coneccion("bk", nodo.getData(18),nodo.getData(26),ranNum());
		conecciones.addLast(bj);conecciones.addLast(bk);
		
		//Conecciones aleatorias
		
		
		return conecciones;
	}
	
	private int ranNum() {
		int ranNum = (int) (Math.random() * 10) + 1;
		if(ranNum == 0) {
			return 5;
		}
		return ranNum;
	}
}
