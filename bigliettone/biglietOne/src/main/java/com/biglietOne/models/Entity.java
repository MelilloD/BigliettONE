package com.biglietOne.models;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Map;

public abstract class Entity {
	
	private int id;

	@Override
	public String toString() {
		return "[ID=" + id + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Entity fromMap(Map<String, String> param) {

		String nomeProp;
		String valoreProp;

		for(Method m : this.getClass().getMethods()) {

			if(m.getName().startsWith("set")) {

				nomeProp = m.getName().substring(3);

				if(param.containsKey(nomeProp)) {

					valoreProp = param.get(nomeProp);

					String tipo = m.getParameters()[0].getType().getSimpleName();
					

					try {
						switch (tipo.toLowerCase()) {
						case "string":
							m.invoke(this, valoreProp);
							break;
							
						case "int":
							m.invoke(this, Integer.parseInt(valoreProp));
							break;
							
						case "date":
							m.invoke(this, Date.valueOf(valoreProp));
							break;
							
						case "double":
							m.invoke(this, Double.parseDouble(valoreProp));
							break;

						case "float":
							m.invoke(this, Float.parseFloat(valoreProp));
							break;

						case "boolean"	:
							//Per i boolean dobbiamo pensare a tutti i modi in cui
							//potrebbero arrivare i valori boolean:
							//Dal db ad esempio arrivano 1 e 0
							//Dall'utente potrebbe arrivare si, s�, true, etc.
							m.invoke(this,	valoreProp.equals("1")				||
											valoreProp.equalsIgnoreCase("true")	||
											valoreProp.equalsIgnoreCase("t")	||
											valoreProp.equalsIgnoreCase("vero")	||
											valoreProp.equalsIgnoreCase("v")	||
											valoreProp.equalsIgnoreCase("si")	||
											valoreProp.equalsIgnoreCase("s")	||
											valoreProp.equalsIgnoreCase("s�")	||
											valoreProp.equalsIgnoreCase("y"))	;
						break;

						default:
							System.err.println("Non ho riconosciuto il tipo: " + tipo);
							break;
						}

					}catch (Exception e) {
						System.err.println("Errore nel metodo fromMap di " + this.getClass().getName());
						e.printStackTrace();
					}


				}


			}


		}

		return this;
	}
}
