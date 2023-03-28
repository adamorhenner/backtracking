package com.uni7.backtracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BacktrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BacktrackingApplication.class, args);
/*
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		a.addChild(b);
		a.addChild(c);
		b.addChild(d);
		c.addChild(d);
		c.addChild(e);
*/

		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");
		Node i = new Node("I");
		Node j = new Node("J");
		Node k = new Node("K");

		a.addChild(b);
		a.addChild(c);

		b.addChild(d);
		b.addChild(f);

		c.addChild(d);
		c.addChild(e);

		e.addChild(g);

		g.addChild(h);

		h.addChild(i);
		h.addChild(j);

		Graph grafo = new Graph();

		List<Node> path = grafo.buscaEmRetrocesso(a,d);

		if (path == null) {
			System.out.println("Não foi encontrado caminho.");
		} else {
			System.out.println("Caminho encontrado:");
			for (Node node : path) {
				System.out.println(node.getName());
			}
		}
	}
}
