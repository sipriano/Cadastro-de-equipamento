package br.com.rcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import br.com.rcm.service.*;

import br.com.rcm.factory.ConnectionFactory;
import br.com.rcm.model.Equipamento;

public class EquipamentoDAO {

	public void criar(Equipamento equi) {
		String sql = "INSERT INTO equipamento (nome, tipo, peso, id) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1 , equi.getNome());
				ps.setString(2, equi.getTipo());
				ps.setFloat(3, equi.getPeso());
				EquipamentoService service = new EquipamentoService();
				int aux = service.geraId();
				equi.setId(aux);
				ps.setInt(4, equi.getId());
				ps.execute();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Equipamento equi) {
		String sql = "UPDATE equipamento SET nome = ?, tipo = ?, peso = ? WHERE id = ?";
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, equi.getNome());
			ps.setString(2, equi.getTipo());
			ps.setFloat(4, equi.getPeso());
			ps.setInt(5, equi.getId());
			ps.execute();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void apagar(Equipamento equi) {
		String sql = "DELETE FROM equipamento WHERE id = ?";
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, equi.getId());
			ps.execute();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public Equipamento carregar(int id) {
		String sql = "SELECT * FROM equipamento WHERE id = ?";
		Equipamento equi = new Equipamento ();
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					equi.setId(rs.getInt("id"));
					equi.setNome(rs.getString("nome"));
					equi.setTipo(rs.getString("tipo"));
					//equi.setPeso("peso");
				}
				return equi;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Equipamento> listar() {
		String sql = "SELECT * FROM equipamento";
		List<Equipamento> equipamentos = new ArrayList<>();
		try (Connection conn = ConnectionFactory.obterConexao();

				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String tipo = rs.getString("tipo");
				float peso = rs.getFloat("peso");
				Equipamento equi = new Equipamento();
				equi.setId(id);
				equi.setNome(nome);
				equi.setTipo(tipo);
				equi.setPeso(peso);
				equipamentos.add(equi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipamentos;

	}
	
	public List <Equipamento> buscar (String chave){
		String sql = "SELECT * FROM equipamento WHERE UPPER(titulo) LIKE ?";
		List <Equipamento> equipamentos = new LinkedList <> ();
		try (Connection conn = ConnectionFactory.obterConexao();
			PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, "%" + chave + "%");
			try (ResultSet rs = ps.executeQuery()){
				while (rs.next()){
					equipamentos.add(new Equipamento (rs.getInt("id"), rs.getString("nome"), rs.getString("tipo"), rs.getFloat("peso")));
				}
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return equipamentos;
	}

}
