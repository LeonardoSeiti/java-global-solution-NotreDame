package br.com.fiap.global.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.global.model.entity.Paciente;

public class PacienteRepository extends Repository {
	public static ArrayList<Paciente> findAll() {
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		String sql = "select * from T_CADASTRO_PACIENTE";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setIdCadastroPaciente(rs.getLong("NR_ID_CADASTRO_PACIENTE"));
				paciente.setCpf(rs.getString("NR_CPF"));
				paciente.setTipoSanguineo(rs.getString("DS_TIPO_SANGUINEO"));
				paciente.setNomeSeguro(rs.getString("NM_EMPRESA_SEGURO_SAUDE"));
				paciente.setNumeroSeguro(rs.getString("NR_SEGURO_SAUDE"));
				paciente.setDescricaoAlergia(rs.getString("DS_ALERGIAS"));
				paciente.setDoencasCronicas(rs.getString("DS_DOENCAS_CRONICAS"));
				paciente.setCirurgiasRealizadas(rs.getString("DS_CIRURGIAS_REALIZADAS"));
				pacientes.add(paciente);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return pacientes;
	}

	public static Paciente save(Paciente paciente) {
		String sql = "insert into T_CADASTRO_PACIENTE (NR_ID_CADASTRO_PACIENTE, NR_CPF, DS_TIPO_SANGUINEO,"
				+ " NM_EMPRESA_SEGURO_SAUDE, NR_SEGURO_SAUDE, DS_ALERGIAS, DS_DOENCAS_CRONICAS, DS_CIRURGIAS_REALIZADAS)"
				+ "values (?,?,?,?,?,?,?,?) ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, paciente.getIdCadastroPaciente());
			ps.setString(2, paciente.getCpf());
			ps.setString(3, paciente.getTipoSanguineo());
			ps.setString(4, paciente.getNomeSeguro());
			ps.setString(5, paciente.getNumeroSeguro());
			ps.setString(6, paciente.getDescricaoAlergia());
			ps.setString(7, paciente.getDoencasCronicas());
			ps.setString(8, paciente.getCirurgiasRealizadas());

			if (ps.executeUpdate() > 0) {
				return paciente;
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