package com.revature.app;

import io.javalin.Javalin;

public class Driver {
	static int currentIndex;
	static Collection coll = new Collection();
	
	public static void main(String[] args) {
		currentIndex = 0;
		
		Javalin app = Javalin.create();
		
		app.start(7776);
		 
		app.post("/collection", ctx -> {
			coll.arrayList.add(ctx.formParam("item"));
			currentIndex++;
			
			String responseText = "";
			
			for (int index = 0 ; index < currentIndex; index++) {
				if (coll.arrayList.get(index) != null) {
					responseText += coll.arrayList.get(index) + "<br>";
				}
			}
			ctx.html(responseText);
		});
	}
}
