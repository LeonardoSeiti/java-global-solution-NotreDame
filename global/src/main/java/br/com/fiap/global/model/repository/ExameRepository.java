package br.com.fiap.global.model.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.global.model.entity.Exame;

public class ExameRepository extends Repository {
	public static ArrayList<Exame> findAll() {
		ArrayList<Exame> exames = new ArrayList<Exame>();
		String sql = "select * from T_EXAME";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Exame exame = new Exame();
				exame.setIdExame(rs.getLong("NR_ID_EXAME"));
				exame.setDescricaoTipoExame(rs.getString("DS_TIPO_EXAME"));
				exame.setDataDoExame(rs.getDate("DT_DATA_DO_EXAME").toLocalDate());
				exames.add(exame);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return exames;
	}

	public static Exame save(Exame exame) {
		String sql = "insert into T_EXAME (NR_ID_CADASTRO_PACIENTE, NR_ID_PRONTUARIO,NR_ID_EXAME, DS_TIPO_EXAME,"
				+ "DT_DATA_DO_EXAME, IM_RESULTADO )"
				+ "values (SQ_ID_CADASTRO_SEQUENCE.NEXTVAL,SQ_ID_PRONTUARIO_SEQUENCE.NEXTVAL,?,?,?,null) ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, exame.getIdExame());
			ps.setString(2, exame.getDescricaoTipoExame());
			ps.setDate(3, Date.valueOf(exame.getDataDoExame()));
		
			if (ps.executeUpdate() > 0) {
				return exame;
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