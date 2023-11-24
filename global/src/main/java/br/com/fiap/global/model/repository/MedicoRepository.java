package br.com.fiap.global.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.global.model.entity.Medico;

public class MedicoRepository extends Repository {
	public static ArrayList<Medico> findAll() {
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		String sql = "select * from T_CADASTRO_MEDICO";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Medico medico = new Medico();
				medico.setIdCadastroMedico(rs.getLong("NR_ID_CADASTRO_MEDICO"));
				medico.setCrm(rs.getString("NR_CRM"));
				medico.setEspecialidade(rs.getString("DS_ESPECIALIDADE"));
				medicos.add(medico);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return medicos;
	}

	public static Medico save(Medico medico) {
		String sql = "insert into T_CADASTRO_MEDICO (NR_ID_CADASTRO_MEDICO, NR_CRM, DS_ESPECIALIDADE)"
				+ "values (?,?,?) ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, medico.getIdCadastroMedico());
			ps.setString(2, medico.getCrm());
			ps.setString(3, medico.getEspecialidade());

			if (ps.executeUpdate() > 0) {
				return medico;
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