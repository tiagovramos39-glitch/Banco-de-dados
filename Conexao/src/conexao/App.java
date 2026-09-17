package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/senai";
		String usuario = "root";
		String senha = "";
		
		//String sql = "INSERT INTO aluno (nome, email) VALUES (?, ?)";
		//String sql = "SELECT id,nome, email FROM aluno ORDER BY nome";
		//String sql = "UPDATE aluno SET nome = ?, email = ? WHERE id + ?";
		String sql = "DELETE FROM aluno WHERE id = ?";
		
		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement comando = conexao.prepareStatement(sql)) {
				//ResultSet resultado = comando.executeQuery()) {
			
			System.out.println("Conexão realizada com sucesso!");
			
			//comando.setString(1, "Ana Souza");
			//comando.setString(2, "ana@email.com");
			//int linhas = comando.executeUpdate();
			
			//System.out.println(linhas + " aluno cadastrado");
			
			//while (resultado.next()) {
				
				//int id = resultado.getInt("id");
				//String nome = resultado.getString("nome");
				//String email = resultado.getString("email");
				
				//System.out.printf("%d - %s - %s%n", id, nome, email);
			
			//comando.setString(1, "Ana Souza");
			//comando.setString(2, "ana.novo@email.com");
			//comando.setInt(3, 1);
			
			//int linhas = comando.executeUpdate();
			
			//System.out.println("Retorno: " + linhas);
			
			comando.setInt(1, 1);
			
			int linhas = comando.executeUpdate();
			
			System.out.println("Excluídos: " + linhas);
			
		} catch (SQLException e) {
			
			System.out.println("Falha na conexão: " + e.getMessage());
		
		}
	}
}