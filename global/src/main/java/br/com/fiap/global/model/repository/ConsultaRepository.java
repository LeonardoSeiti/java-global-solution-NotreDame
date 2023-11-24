package br.com.fiap.global.model.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.global.model.entity.Consulta;

public class ConsultaRepository extends Repository {
	public static ArrayList<Consulta> findAll() {
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		String sql = "select * from T_CONSULTA";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Consulta consulta = new Consulta();
				consulta.setIdConsulta(rs.getLong("NR_ID_CONSULTA"));
				consulta.setDataDaConsulta(rs.getDate("DT_DATA_DA_CONSULTA").toLocalDate());
				consulta.setHoraDaConsulta(rs.getString("HR_HORA_DA_CONSULTA"));
				consulta.setDescricaoMotivo(rs.getString("DS_MOTIVO"));
				consulta.setDescricaoSintomas(rs.getString("DS_SINTOMAS"));
				consulta.setDescricaoDiagnstico(rs.getString("DS_DIAGNOSTICO"));
				consultas.add(consulta);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return consultas;
	}

	public static Consulta save(Consulta consulta) {
		String sql = "insert into T_CONSULTA (NR_ID_CADASTRO_PACIENTE, NR_ID_PRONTUARIO, NR_ID_CONSULTA, DT_DATA_DA_CONSULTA,"
				+ "HR_HORA_DA_CONSULTA, DS_MOTIVO,DS_SINTOMAS, DS_DIAGNOSTICO)"
				+ "values (SQ_ID_CADASTRO_SEQUENCE.NEXTVAL,SQ_ID_PRONTUARIO_SEQUENCE.NEXTVAL,?,?,?,?,?,?) ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, consulta.getIdConsulta());
			ps.setDate(2, Date.valueOf(consulta.getDataDaConsulta()));
			ps.setString(3, consulta.getHoraDaConsulta()); 	
			ps.setString(4, consulta.getDescricaoMotivo());
			ps.setString(5, consulta.getDescricaoSintomas());
			ps.setString(6, consulta.getDescricaoDiagnstico());
			if (ps.executeUpdate() > 0) {
				return consulta;
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