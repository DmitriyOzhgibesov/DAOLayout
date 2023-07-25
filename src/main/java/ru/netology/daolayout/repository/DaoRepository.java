package ru.netology.daolayout.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class DaoRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String sqlQuery;

    public DaoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        sqlQuery = read("schema.sql");
    }

    public List<String> getProductName(String name){
        SqlParameterSource parameterSource = new MapSqlParameterSource("name", name);
        List<String> productName = namedParameterJdbcTemplate.queryForList(sqlQuery,parameterSource, String.class);
        return productName;
    }

    public static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}