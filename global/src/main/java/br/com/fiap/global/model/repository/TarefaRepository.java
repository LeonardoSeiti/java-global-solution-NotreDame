package br.com.fiap.global.model.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.global.model.entity.Tarefa;

public class TarefaRepository extends Repository {
	public static ArrayList<Tarefa> findAll() {
		ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
		String sql = "select * from T_TAREFAS";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setIdTarefa(rs.getLong("NR_ID_TAREFA"));
				tarefa.setDescricaoTarefa(rs.getString("DS_TAREFA"));
				tarefa.setDataInicioTerefa(rs.getDate("DT_INICIO_TAREFA").toLocalDate());
				tarefa.setDataFimTarefa(rs.getDate("DT_DATA_FIM_TAREFA").toLocalDate());
				tarefa.setDescricaoProcedimento(rs.getString("DS_PROCEDIMENTO"));
				tarefas.add(tarefa);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return tarefas;
	}

	public static Tarefa save(Tarefa tarefa) {
		String sql = "insert into T_TAREFAS (NR_ID_CADASTRO_PACIENTE, NR_ID_PRONTUARIO,NR_ID_TAREFA, DS_TAREFA,"
				+ "DT_INICIO_TAREFA, DT_DATA_FIM_TAREFA, DS_PROCEDIMENTO )"
				+ "values (SQ_ID_CADASTRO_SEQUENCE.NEXTVAL,SQ_ID_PRONTUARIO_SEQUENCE.NEXTVAL,?,?,?,?,?) ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, tarefa.getIdTarefa());
			ps.setString(2, tarefa.getDescricaoTarefa());
			ps.setDate(3, Date.valueOf(tarefa.getDataInicioTerefa()));
			ps.setDate(4, Date.valueOf(tarefa.getDataFimTarefa()));
			ps.setString(5, tarefa.getDescricaoProcedimento());
			if (ps.executeUpdate() > 0) {
				return tarefa;
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