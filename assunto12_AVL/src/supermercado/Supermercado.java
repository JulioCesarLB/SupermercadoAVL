package supermercado;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Supermercado {

	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		AVLProdutos avl = new AVLProdutos();
		int opcao;
		do {
			System.out.println(" 0 - Sair");
			System.out.println(" 1 - Inserir produto");
			System.out.println(" 2 - Mostrar produtod com precos menores que 1 valor");
			System.out.println(" 3 - Remover produto");
			System.out.println(" 4 - Consultar produto");
			opcao = le.nextInt();

			switch (opcao) {
			case 0:
				System.out.println(" Encerrado o programa");
				break;
			case 1:
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, " Insira o codigo"));
				String descricao =JOptionPane.showInputDialog(null, " Insira a descrição");
				double preco = Double.parseDouble(JOptionPane.showInputDialog(null, " Insira o preço"));
				
				avl.root = avl.inserirAVL(avl.root,new Produto(codigo,descricao,preco));
				avl.atualizaAlturas(avl.root);
				avl.root = avl.balanceamento(avl.root);
				avl.atualizaAlturas(avl.root);
				break;
			case 2:
				avl.listaMaisBarato(avl.root, 3);
				break;
			case 3:
				
				break;
			case 4:
				codigo = Integer.parseInt(JOptionPane.showInputDialog(null, " Insira o codigo"));
				Produto produto = avl.consultaProduto(avl.root, codigo);
				JOptionPane.showMessageDialog(null, produto.toString());
				break;
			default:
				System.out.println("Opcao Invalida");
			}
		} while (opcao != 0);
		le.close();

	}


}
