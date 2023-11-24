package br.com.fiap.global.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.global.model.entity.ContatoEmergencia;

public class ContatoEmergenciaRepository extends Repository {
	public static ArrayList<ContatoEmergencia> findAll() {
		ArrayList<ContatoEmergencia> contatos = new ArrayList<ContatoEmergencia>();
		String sql = "select * from T_CONTATO_EMERGENCIA";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ContatoEmergencia contato = new ContatoEmergencia();
				contato.setIdContatoEmergencia(rs.getLong("NR_ID_CONTATO_EMERGENCIA"));
				contato.setNomeEmergencial(rs.getString("NM_NOME_EMERGENCIA1"));
				contato.setNumeroDeTelefone(rs.getString("NR_TELEFONE_EMERGENCIA"));
				contato.setDescricaoFiliacao(rs.getString("DS_FILIACAO"));
				
				contatos.add(contato);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return contatos;
	}

	public static ContatoEmergencia save(ContatoEmergencia contato) {
		String sql = "insert into T_CONTATO_EMERGENCIA (NR_ID_CONTATO_EMERGENCIA, NR_ID_CADASTRO_PACIENTE, NM_NOME_EMERGENCIA1,"
				+ "NR_TELEFONE_EMERGENCIA, DS_FILIACAO)"
				+ "values(?,SQ_ID_CADASTRO_SEQUENCE.NEXTVAL,?,?,?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, contato.getIdContatoEmergencia());
			ps.setString(2, contato.getNomeEmergencial());
			ps.setString(3, contato.getNumeroDeTelefone());
			ps.setString(4, contato.getDescricaoFiliacao());
			if (ps.executeUpdate() > 0) {
				return contato;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}

}