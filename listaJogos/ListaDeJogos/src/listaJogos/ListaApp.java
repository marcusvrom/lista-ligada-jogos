package listaJogos;

public class ListaApp {
	Jogo inicio = null;
	int tamanho = 0;
	
	public void inserirInicioDaLista(int id, String nome, String descricao, String plataforma, float valor) {
		Jogo jogo = new Jogo(id, nome, descricao, plataforma, valor);
		jogo.proximo = inicio;
		inicio = jogo;
		tamanho++;
	}
	
	public Jogo retirarInicioDaLista() {
		if(inicio == null) {
			return null;
		}
		Jogo info = new Jogo(inicio.id, inicio.jogo, inicio.descricao, inicio.plataforma, inicio.valor);
		inicio = inicio.proximo;
		tamanho--;
		return info;
	}
	
	public void inserirFimDaLista(int id, String nome, String descricao, String plataforma, float valor) {
		Jogo jogo = new Jogo(id, nome, descricao, plataforma, valor);
		if(inicio == null) {
			jogo.proximo = null;
			inicio = jogo;
		} else {
			Jogo local = inicio;
			while(local.proximo != null) {
				local = local.proximo;
			}
			local.proximo = jogo;
			jogo.proximo = null;
		}
		tamanho++;
	}
	
	public Jogo retirarFimDaLista() {
		if(inicio == null) {
			return null;
		}
		Jogo local = inicio;
		while(local.proximo != null) {
			Jogo aux = local;
			local = local.proximo;
			if(local.proximo == null) {
				aux.proximo = null;
				tamanho--;
				return local;
			}
		}
		inicio = null;
		tamanho--;
		return local;
	}
	
	public String imprimirListaInversa() {
		String str = "(" + tamanho + ") ";
		Jogo ant = null;
		Jogo atual = inicio;
		while (atual != null) {
			Jogo seg = atual.proximo;
			atual.proximo = ant;
			ant = atual;
			atual = seg;
		}
		inicio = ant;
		Jogo local = inicio;
		while(local != null) {
			if(local.valor == 0f) {
				str += "\n" + "/*******************/ " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: Gr?tis";
			} else {
				str += "\n" + "/*******************/ " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: " + local.valor;
			}
			local = local.proximo;
		}
		return str;
	}
	
	public String imprimirNoComValorImparMenor200() {
		String str = "";
		Jogo local = inicio;
		while(local != null) {
			if(local.valor % 2 == 1 && local.valor < 200) {
				str += "/*******************/ " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: " + local.valor + "\n";
			}
			local = local.proximo;
		}
		return str;
	}
	
	public void buscarPoridEInserirPosterior(long idBusca, int id, String nome, String descricao, String plataforma, float valor) {
		Jogo local = inicio;
		for(int i = 0; i < tamanho; i++) {
			Jogo aux = local;
			local = local.proximo;
			if(aux.id == idBusca) {
				Jogo jogo = new Jogo(id, nome, descricao, plataforma, valor);
				aux.proximo = jogo;
				jogo.proximo = local;
				i = tamanho;
			}
		}
		tamanho++;
	}
	
	public void buscarPorPlataformaEAlterarPosterior(String plataformaBusca, String nome, String descricao, String plataforma, float valor) {
		Jogo local = inicio;
		for(int i = 0; i < tamanho; i++) {
			Jogo aux = local;
			if(aux.plataforma.equals(plataformaBusca)) {
				local = local.proximo;
				if(local != null) {
					String str1;
					if(local.valor == 0f) {
						str1 = "/*******************/ " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: Gr?tis";
					} else {
						str1 = "/*******************/ " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: " + local.valor;
					}
					System.out.println(str1);
					System.out.println("===================================");
					local.setJogo(nome);
					local.setDescricao(descricao);
					local.setPlataforma(plataforma);
					local.setValor(valor);
					String str2 = "Edi??o Completa: " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: " + local.valor;
					if(local.valor == 0f) {
						str2 = "/*******************/ " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: Gr?tis";
					} else {
						str2 = "/*******************/ " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: " + local.valor;
					}
					System.out.println(str2);
					i = tamanho;
				} else {
					System.out.println("===================================");
					System.out.println("Jogo n?o existente neste indice");
					System.out.println("===================================");
				}
			}
			if(local != null) {
				local = local.proximo;	
			}
		}
	}
	
	public Jogo buscarIdERemoverSegundoAnterior(int id) {
		if(inicio == null) {
			return null;
		}
		Jogo local = inicio;
		Jogo aux = local;
		local = local.proximo;
		Jogo aux2 = local;
		local = local.proximo;
		
		for(int i = 0; i < tamanho; i++) {
			Jogo aux3 = aux;
			if(aux != null) {
				aux = aux.proximo;
			}
			if(aux2 != null) {
				aux2 = aux2.proximo;
			}
			if(local != null) {
				local = local.proximo;
			}
			if(local != null) {
				if(local.id == id) {
					aux3.proximo = aux2;
					aux2.proximo = local;
					aux.proximo = null;
					tamanho--;
					return aux;
				}
			}
		}
		inicio = null;
		tamanho--;
		return aux;
		
	}
	
	public void inserirNaPosicaoK(int k, int id, String nome, String descricao, String plataforma, float valor) {
		System.out.println("K = " + k);
		if(k <= 0) {
			inserirInicioDaLista(id, nome, descricao, plataforma, valor);
		} else if (k >= tamanho) {
			inserirFimDaLista(id, nome, descricao, plataforma, valor);
		} else {
			Jogo local = inicio;
			for(int i = 0; i < k -1; i++) {
				local = local.proximo;
			}
			Jogo jogo = new Jogo(id, nome, descricao, plataforma, valor);
			jogo.proximo = local.proximo;
			local.proximo = jogo;
			tamanho++;
		}
	}
	
	public Jogo retirarNaPosicaoK3(int k) {
		System.out.println("K = " + k);
		k += 3;
		if(
			k < 0 
			|| k >= tamanho 
			|| inicio == null) {
			return null;
		} else if(k == 0) {
			return retirarInicioDaLista();		
		} else if (k == tamanho-1) {
			return retirarFimDaLista();
		}
		Jogo local = inicio;
		for(int i = 0; i < k - 1; i++) {
			local = local.proximo;
		}
		Jogo jogo = local.proximo;
		local.proximo = local.proximo.proximo;
		tamanho--;
		return jogo;
	}
	
	public String consultaJogoAnteriorAoK(int k) {
		System.out.println("K = " + k);
		if(inicio == null) {
			return null;
		} else if(k <= 0) {
			String str = "Jogo N?o Existente no ?ndice.";
			System.out.println("===================================");
			return str;
		} else if(k > tamanho - 1) {
			Jogo local = inicio;
			for(int i = 0; i < tamanho - 1; i++) {
				Jogo aux = local;
				local = local.proximo;
			}
			if(local.proximo == null) {
				if(local.valor == 0f) {
					String str = "\n" + "/*******************/ " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: Gr?tis";
					return str;
				} else {
					String str = "\n" + "/*******************/ " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: " + local.valor;
					return str;
				}
			}
		}
		Jogo local = inicio;
		for(int i = 0; i < k - 1; i++) {
			local = local.proximo;
		}
		String str = "/*******************/" + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: " + local.valor;
		return str;
	}
	
	public void alterarConteudoJogoPosicaoK(int k, String nome, String descricao, String plataforma, float valor) {
		System.out.println("K = " + k);
		Jogo local = inicio;
		Jogo aux = local;
		if(k < 0) {
			k = 0;
		} else if (k >= tamanho) {
			k = tamanho;
		}
		for(int j = 0; j <= k; j++) {
			aux = local;
			local = local.proximo;
		}
		if(aux != null) {
			String str1;
			if(aux.valor == 0f) {
				str1 = "/*******************/ " + "\n" + "ID: " + aux.id + "\n" + aux.jogo + " - " + aux.plataforma + "\n" + aux.descricao + "\n" + "R$: Gr?tis";
			} else {
				str1 = "/*******************/ " + "\n" + "ID: " + aux.id + "\n" + aux.jogo + " - " + aux.plataforma + "\n" + aux.descricao + "\n" + "R$: " + aux.valor;
			}
			System.out.println("===================================");
			System.out.println(str1);
			aux.setJogo(nome);
			aux.setDescricao(descricao);
			aux.setPlataforma(plataforma);
			aux.setValor(valor);
			String str2;
			if(aux.valor == 0f) {
				str2 = "/*******************/ " + "\n" + "ID: " + aux.id + "\n" + aux.jogo + " - " + aux.plataforma + "\n" + aux.descricao + "\n" + "R$: Gr?tis";
			} else {
				str2 = "/*******************/ " + "\n" + "ID: " + aux.id + "\n" + aux.jogo + " - " + aux.plataforma + "\n" + aux.descricao + "\n" + "R$: " + aux.valor;
			}
			System.out.println("===================================");
			System.out.println(str2);
			System.out.println("===================================");
			
		} else {
			System.out.println("===================================");
			System.out.println("Jogo n?o existente neste indice");
			System.out.println("===================================");
		}
		
	}
	
	// public String classificarPorOrdemNomeDoJogo() {
	//	String[] listaAlpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	//	String str = "(" + tamanho + ") ";
	//	Jogo local = inicio;
	//		while(local != null) {
	//				for(int i = 0; i < listaAlpha.length; i++) {
	//					if(local.jogo.startsWith(listaAlpha[i])) {
	//						str += "\n" + "/*******************/ " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: " + local.valor;
	//						local = local.proximo;
	//					}
	//				}
	//				if(local != null) {
	//					local = local.proximo;
	//				}
	//		}
	//	return str;
	// }
	
	public String toString() {
		String str = "(" + tamanho + ") ";
		Jogo local = inicio;
		while(local != null) {
			if(local.valor == 0f) {
				str += "\n" + "/*******************/ " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: Gr?tis";
			} else {
				str += "\n" + "/*******************/ " + "\n" + "ID: " + local.id + "\n" + local.jogo + " - " + local.plataforma + "\n" + local.descricao + "\n" + "R$: " + local.valor;
			}
			local = local.proximo;
		}
		return str;
	}
	
	public static void main(String [] args) {
		ListaApp l = new ListaApp();
		l.inserirFimDaLista(6, "Prepar3D", "Simulador de Voo", "PC", 0f);
		l.inserirInicioDaLista(5, "X-Plane", "Simulador de Voo", "PC", 150.00f);
		l.inserirInicioDaLista(4, "Flight Simulator", "Simulador de Voo", "PC", 200.00f);
		l.inserirInicioDaLista(3, "CS:GO", "FPS", "PC", 40.00f);
		l.inserirInicioDaLista(2, "Watch Dogs", "Jogo de Hacking", "XBOX", 85.00f);
		l.inserirInicioDaLista(1, "Hades", "Roguelike", "Switch", 65.00f);
		// Imprimir Lista
		System.out.println("\n");
		System.out.println("===================================");
		System.out.println("Imprimir Lista");
		System.out.println("===================================");
		System.out.println(l);
		System.out.println("///////////////////////////////////");
		
		// Imprimir os n?s com valor impar menores que R$200 no campo de Valor do Jogo
		System.out.println("\n");
		System.out.println("===================================");
		System.out.println("Imprimir os n?s com valor impar menores que R$200 no campo de Valor do Jogo");
		System.out.println("===================================");
		System.out.println(l.imprimirNoComValorImparMenor200());
		System.out.println("///////////////////////////////////");
		
		// Procurar um n? por plataforma e alterar o conte?do do proximo/posterior a ele
		System.out.println("\n");
		System.out.println("===================================");
		System.out.println("Procurar um n? por plataforma e alterar o conte?do do proximo/posterior a ele");
		System.out.println("===================================");
		l.buscarPorPlataformaEAlterarPosterior("XBOX", "Lol", "Moba", "PC", 0f);
		System.out.println("///////////////////////////////////");
		
		// Procurar um n? e remover o segundo n? anterior ao n? encontrado
		System.out.println("\n");
		System.out.println("===================================");
		System.out.println("Procurar um n? e remover o segundo n? anterior ao n? encontrado");
		System.out.println("===================================");
		l.buscarIdERemoverSegundoAnterior(5);
		System.out.println(l);
		System.out.println("///////////////////////////////////");
		
		// Inserir na posi??o K
		System.out.println("\n");
		System.out.println("===================================");
		System.out.println("Inserir na posi??o K");
		System.out.println("===================================");
		l.inserirNaPosicaoK(2, 8, "Minecraft", "Sandbox", "PC", 65.00f);
		System.out.println(l);
		System.out.println("///////////////////////////////////");
		
		// Remover na Posi??o K+3
		System.out.println("\n");
		System.out.println("===================================");
		System.out.println("Remover na Posi??o K+3");
		System.out.println("===================================");
		l.retirarNaPosicaoK3(0);
		System.out.println(l);
		System.out.println("///////////////////////////////////");
		
		// Consultar o n? anterior ao da posi??o K
		System.out.println("\n");
		System.out.println("===================================");
		System.out.println("Consultar o n? anterior ao da posi??o K");
		System.out.println("===================================");
		System.out.println(l.consultaJogoAnteriorAoK(3));
		System.out.println("///////////////////////////////////");
		
		// Alterar o conte?do de um n? na posi??o K
		System.out.println("\n");
		System.out.println("===================================");
		System.out.println("Alterar o conte?do de um n? na posi??o K");
		System.out.println("===================================");
		l.alterarConteudoJogoPosicaoK(0, "PAC-MAN", "Classico", "Atari", 0f);
		System.out.println("///////////////////////////////////");
		
		// Procurar um n? por id e inserir um novo n? depois/posteriormente ao n? encontrado
		System.out.println("\n");
		System.out.println("===================================");
		System.out.println("Procurar um n? por id e inserir um novo n? depois/posteriormente ao n? encontrado");
		System.out.println("===================================");
		l.buscarPoridEInserirPosterior(1, 12, "Crash Bandicoot", "Melhor jogo do mundo", "PS2", 10.0f);
		System.out.println(l);
		System.out.println("///////////////////////////////////");
		
		// Inserir n? no fim da lista
		System.out.println("\n");
		System.out.println("===================================");
		System.out.println("Inserir n? no fim da lista");
		System.out.println("===================================");
		l.inserirFimDaLista(13, "Nier Automata", "RPG", "PC", 120.00f);
		System.out.println(l);
		System.out.println("///////////////////////////////////");
		
		// Classificar em ordem crescente de nome do jogo
		// System.out.println("Classificar em ordem crescente de nome do jogo");
		// System.out.println("===================================");
		// System.out.println(l.classificarPorOrdemNomeDoJogo());
		// System.out.println("///////////////////////////////////");
		
		// Imprimir Lista Inversa
		System.out.println("\n");
		System.out.println("===================================");
		System.out.println("Imprimir Lista Inversa");
		System.out.println("===================================");
		System.out.println(l.imprimirListaInversa());
		System.out.println("///////////////////////////////////");
		
	}

}
