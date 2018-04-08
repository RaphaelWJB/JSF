package br.com.framework.interfac.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable {

	// Salva os dados
	void save(T obj) throws Exception;

	void persist(T obj) throws Exception;

	// Salva ou Atualiza
	void saveOrUpdate(T obj) throws Exception;

	// Atualiza dados
	void update(T obj) throws Exception;

	// Deleta dados
	void delete(T obj) throws Exception;

	// Salva ou atualiza e retorna o objeto em estado persistencia
	T merge(T obj) throws Exception;

	// Carrega uma lista de dados da classe
	List<T> findList(Class<T> entidade) throws Exception;

	Object findById(Class<T> entidade, Long id) throws Exception;

	T findByPorId(Class<T> entidade, Long id) throws Exception;

	List<T> findListQueryDinamica(String sql) throws Exception;

	// Executar update com HQL
	void executeUpdateQueryDinamica(String sql) throws Exception;

	// executar update com SQL
	void executeUpdateSqlDinamica(String sql) throws Exception;

	// Limpa a Sessão do hibernate
	void clearSession() throws Exception;

	// Retira uma objeto da sessão do hibernate
	void evict(Object objs) throws Exception;

	Session getSession() throws Exception;

	List<?> getListSqlDinamica(String sql) throws Exception;

	// JDBC do Spring
	JdbcTemplate getJdbcTemplate();

	SimpleJdbcTemplate getSimpleJdbcTemplate();

	SimpleJdbcInsert getSimpleJdbcInsert();

	Long totalRegistros(String table) throws Exception;

	Query obterQuery(String query) throws Exception;
	
	// Carregamento dinamico com JSF e PrimeFaces
	List<T> findListByQueryDinamica(String query, int iniciaRegistro, int maximoResultado) throws Exception;

}
