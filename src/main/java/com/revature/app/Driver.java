package com.revature.app;

import io.javalin.Javalin;

public class Driver {
	static int currentIndex;
	static Collection coll = new Collection();
	
	public static void main(String[] args) {
		currentIndex = 0;
		
		Javalin app = Javalin.create();
		
		app.start(7777);
		 
		app.post("/collection", ctx -> {
			coll.collection[currentIndex] = ctx.formParam("item");
			currentIndex++;
			
			String responseText = "";
			
			for (int index = 0; index < currentIndex; index++) {
				if (coll.collection[index] != null) {
					responseText += coll.collection[index] + "<br>";
				}
			}
			ctx.html(responseText);
		});
	}
}
