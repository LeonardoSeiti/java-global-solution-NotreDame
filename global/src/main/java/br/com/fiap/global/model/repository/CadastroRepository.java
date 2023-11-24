package br.com.fiap.global.model.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.global.model.entity.Cadastro;

public class CadastroRepository extends Repository {
	public static ArrayList<Cadastro> findAll() {
		ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();
		String sql = "select * from t_cadastro";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cadastro cadastro = new Cadastro();
				cadastro.setIdCadastro(rs.getLong("NR_ID_CADASTRO"));
				cadastro.setNome(rs.getString("NM_NOME"));
				cadastro.setDataDeNascimentol(rs.getDate("DT_DATA_DE_NASCIMENTO").toLocalDate());
				cadastro.setGenero(rs.getString("DS_GENERO"));
				cadastro.setCep(rs.getString("NR_CEP"));
				cadastro.setDescricaoLogradouro(rs.getString("DS_LOGRADOURO"));
				cadastro.setNumeroLogradouro(rs.getInt("NR_NUMERO_LOGRADOURO"));
				cadastro.setNomeCidade(rs.getString("NM_CIDADE"));
				cadastro.setNomeEstado(rs.getString("NM_ESTADO"));
				cadastro.setNumeroTelefone(rs.getString("NR_TELEFONE"));
				cadastro.setDescricaoEmail(rs.getString("DS_EMAIL"));
				cadastro.setTipoDocumento(rs.getString("TP_DOCUMENTO"));

				cadastros.add(cadastro);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return cadastros;
	}

	public static Cadastro save(Cadastro cadastro) {
		String sql = "insert into T_CADASTRO "
				+ "(NR_ID_CADASTRO,NM_NOME,DT_DATA_DE_NASCIMENTO,DS_GENERO,NR_CEP,DS_LOGRADOURO,NR_NUMERO_LOGRADOURO,NM_CIDADE,NM_ESTADO,NR_TELEFONE,DS_EMAIL,TP_DOCUMENTO)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, cadastro.getIdCadastro());
			ps.setString(2, cadastro.getNome());
			ps.setDate(3, Date.valueOf(cadastro.getDataDeNascimentol()));
			ps.setString(4, cadastro.getGenero());
			ps.setString(5, cadastro.getCep());
			ps.setString(6, cadastro.getDescricaoLogradouro());
			ps.setInt(7, cadastro.getNumeroLogradouro());
			ps.setString(8, cadastro.getNomeCidade());
			ps.setString(9, cadastro.getNomeEstado());
			ps.setString(10, cadastro.getNumeroTelefone());
			ps.setString(11, cadastro.getDescricaoEmail());
			ps.setString(12, cadastro.getTipoDocumento());
			if (ps.executeUpdate() > 0) {
				return cadastro;
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

	public static boolean delete(Long idCadastro) {
		String sql = "delete from T_CADASTRO where NR_ID_CADASTRO = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, idCadastro);
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao excluir: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return false;
	}

	public static Cadastro update(Cadastro cadastro, Long idCadastro) {
		String sql = "UPDATE T_CADASTRO SET NM_NOME=?, DT_DATA_DE_NASCIMENTO=?, DS_GENERO=?, NR_CEP=?, DS_LOGRADOURO=?, "
				+ "NR_NUMERO_LOGRADOURO=?, NM_CIDADE=?, NM_ESTADO=?, NR_TELEFONE=?, DS_EMAIL=?, TP_DOCUMENTO=? WHERE NR_ID_CADASTRO=?";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cadastro.getNome());
			ps.setDate(2, Date.valueOf(cadastro.getDataDeNascimentol()));
			ps.setString(3, cadastro.getGenero());
			ps.setString(4, cadastro.getCep());
			ps.setString(5, cadastro.getDescricaoLogradouro());
			ps.setInt(6, cadastro.getNumeroLogradouro());
			ps.setString(7, cadastro.getNomeCidade());
			ps.setString(8, cadastro.getNomeEstado());
			ps.setString(9, cadastro.getNumeroTelefone());
			ps.setString(10, cadastro.getDescricaoEmail());
			ps.setString(11, cadastro.getTipoDocumento());
			ps.setLong(12, idCadastro);
			if (ps.executeUpdate() > 0) {
				return cadastro;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
}