package br.com.fiap.global.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.global.model.entity.Prontuario;

public class ProntuarioRepository extends Repository {
	public static ArrayList<Prontuario> findAll() {
		ArrayList<Prontuario> prontuarios = new ArrayList<Prontuario>();
		String sql = "select * from T_PRONTUARIO";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prontuario prontuario = new Prontuario();
				prontuario.setIdProntuario(rs.getLong("NR_ID_PRONTUARIO"));
				prontuarios.add(prontuario);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return prontuarios;
	}

	public static Prontuario save(Prontuario prontuario) {
		String sql = "insert into T_PRONTUARIO (NR_ID_CADASTRO_PACIENTE, NR_ID_PRONTUARIO)"
				+ "values (SQ_ID_CADASTRO_SEQUENCE.NEXTVAL,?) ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, prontuario.getIdProntuario());
		
			if (ps.executeUpdate() > 0) {
				return prontuario;
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