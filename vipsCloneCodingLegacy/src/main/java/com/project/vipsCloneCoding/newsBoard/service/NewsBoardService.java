package com.project.vipsCloneCoding.newsBoard.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.project.vipsCloneCoding.newsBoard.dao.NewsBoardDAO;
import com.project.vipsCloneCoding.newsBoard.domain.NewsBoardVO;

@Service
public class NewsBoardService {
  @Autowired
  NewsBoardDAO newsBoardDAO;

  public String getTitle(int i) {

    try {
      return newsBoardDAO.getNewsBoardTable(i).getTitle();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public String getCreatedAt(int i) {
    try {
      Date temp = newsBoardDAO.getNewsBoardTable(i).getCreatedAt();
      SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd");
      return simple.format(temp);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public int getId(int i) {
    try {
      return newsBoardDAO.getNewsBoardTable(i).getId();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return 0;
  }

  public int getView(int i) {
    try {
      return newsBoardDAO.getNewsBoardTable(i).getView();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return 0;
  }

  public String getContents(int i) {
    try {
      return newsBoardDAO.getNewsBoardTable(i).getContents();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public int tableFinish() {
    try {
      return newsBoardDAO.countTable().getCount();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return 0;
  }

  public int tableFinish(String where) {
    try {
      return newsBoardDAO.searchcountTable(where).getCount();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return 0;
  }

  public int tableBottomController() {

    int temp = newsBoardDAO.countTable().getCount() / 10;

    if (newsBoardDAO.countTable().getCount() % 10 != 0) {
      temp = temp + 1;
    }
    return temp;
  }

  public int searchtableBottomController(String where) {

    int temp = newsBoardDAO.searchcountTable(where).getCount() / 10;

    if (newsBoardDAO.searchcountTable(where).getCount() % 10 != 0) {
      temp = temp + 1;
    }
    return temp;
  }


  public List<NewsBoardVO> getLastTen() {
    try {
      return newsBoardDAO.getLastTen();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public List<NewsBoardVO> getLastTen(int controll) {
    try {
      return newsBoardDAO.getLastTen(controll);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public void upView(int id) {
    try {
      newsBoardDAO.updateView(id, newsBoardDAO.getNewsBoardTable(id).getView() + 1);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } ;
  }

  public void imageUpload(MultipartFile image, String where, int id) {
    try {
      String savePath = Paths.get("../").toAbsolutePath().toString()
          + "/git/Java4FirstProject/vipsCloneCodingLegacy/src/main/webapp/resources/images/" + where
          + "/";
      if (!image.isEmpty()) {

        try {
          File dir = new File(savePath);
          dir.mkdir();
        } catch (Exception e) {
          e.printStackTrace();
        }
        String filename = id + ".png";
        String filepath = savePath + filename;
        File dest = new File(filepath);

        image.transferTo(dest);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
