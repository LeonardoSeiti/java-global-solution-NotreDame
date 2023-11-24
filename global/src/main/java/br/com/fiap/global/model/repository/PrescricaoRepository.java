package br.com.fiap.global.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.global.model.entity.Prescricao;

public class PrescricaoRepository extends Repository {
	public static ArrayList<Prescricao> findAll() {
		ArrayList<Prescricao> prescricoes = new ArrayList<Prescricao>();
		String sql = "select * from T_PRESCRICAO";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prescricao prontuario = new Prescricao();
				prontuario.setIdPrescricao(rs.getLong("NR_ID_PRESCRICAO"));
				prontuario.setDiagnostico(rs.getString("DS_DIAGNOSTICO_FINAL"));
				prontuario.setDescricaoMedicamento(rs.getString("DS_MEDICAMENTO"));
				prontuario.setDescricaoPosologia(rs.getString("DS_POSOLOGIA"));
				
				prescricoes.add(prontuario);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return prescricoes;
	}

	public static Prescricao save(Prescricao prontuario) {
		String sql = "insert into T_PRESCRICAO (NR_ID_CADASTRO_PACIENTE, NR_ID_PRONTUARIO,NR_ID_PRESCRICAO,"
				+ "DS_DIAGNOSTICO_FINAL,DS_MEDICAMENTO,DS_POSOLOGIA)"
				+ "values (SQ_ID_CADASTRO_SEQUENCE.NEXTVAL,SQ_ID_PRONTUARIO_SEQUENCE.NEXTVAL,?,?,?,?) ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, prontuario.getIdPrescricao());
			ps.setString(2, prontuario.getDiagnostico());
			ps.setString(3, prontuario.getDescricaoMedicamento());
			ps.setString(4, prontuario.getDescricaoPosologia());
		
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