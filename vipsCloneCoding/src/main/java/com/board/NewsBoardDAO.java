package main.java.com.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Repository
public class NewsBoardDAO {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public RowMapper<NewsBoardVO> mapper = new RowMapper<NewsBoardVO>() {
    @Override
    public NewsBoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new NewsBoardVO(rs.getInt("id"), rs.getString("user_id"), rs.getString("title"),
          rs.getString("board_contents"), rs.getDate("created_at"), rs.getInt("board_view"));
    }
  };

  @Test
  public void dropTable() throws Exception {
    jdbcTemplate.update("drop table newsboard");
  }

  @Test
  public void createNewsBoardTable() throws Exception {
    jdbcTemplate.update("create table newsboard(id number(10,0) generated as identity primary key, "
        + "user_id varchar2(20) not null, " + "title varchar2(200) not null, "
        + "board_contents varchar2(3000) not null, " + "created_at Date default sysdate, "
        + "board_view number(10,0), isDelete varchar2(15))");
  }

  public NewsBoardVO getNewsBoardTable(int id) throws Exception {
    return jdbcTemplate.queryForObject("select * from newsboard where id = ?", new Object[] {id},
        mapper);
  }
}
